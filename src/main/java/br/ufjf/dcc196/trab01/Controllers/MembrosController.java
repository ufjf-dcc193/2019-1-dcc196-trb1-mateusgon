package br.ufjf.dcc196.trab01.Controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc196.trab01.Models.Membro;
import br.ufjf.dcc196.trab01.Models.Sede;
import br.ufjf.dcc196.trab01.Persistence.MembroRepository;
import br.ufjf.dcc196.trab01.Persistence.SedeRepository;

@Controller
@RequestMapping("/membros")
public class MembrosController {

    @Autowired
    private MembroRepository repositoryMembro;
    @Autowired
    private SedeRepository repositorySede;

    @RequestMapping(value = { "/", "", "/index" })
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.GET)
    public ModelAndView carregaForm() {
        List<Sede> sedes = repositorySede.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sedes", sedes);
        mv.setViewName("membros/criar");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.POST)
    public ModelAndView recebeForm(Membro membro, Long sedeMembro) {
        Sede sede = repositorySede.getOne(sedeMembro);
        membro.setSede(sede);
        repositoryMembro.save(membro);
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
        return mv;
    }

    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaEditar(@PathVariable(value = "id", required = true) Long id) {
        Membro membro = repositoryMembro.getOne(id);
        SimpleDateFormat formatBra = new SimpleDateFormat("yyyy-MM-dd");
        String dataDeEntrada = formatBra.format(membro.getDataDeEntrada());
        String dataDeSaida = formatBra.format(membro.getDataDeSaida());
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("dataDeEntrada", dataDeEntrada);
        mv.addObject("dataDeSaida", dataDeSaida);
        mv.addObject("sedes", sedes);
        mv.addObject("sede", membro.getSede());
        mv.addObject("membro", membro);
        mv.setViewName("membros/editar");
        return mv;
    }

    @RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
    public ModelAndView recebeEditar(@RequestParam(value = "id", required = true) Long id, Membro membro) {
        membro.setId(id);
        repositoryMembro.save(membro);
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
        return mv;
    }

    @RequestMapping(value = { "/detalhes/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaDetalhes(@PathVariable(value = "id", required = true) Long id) {
        Membro membro = repositoryMembro.getOne(id);
        SimpleDateFormat formatBra = new SimpleDateFormat("yyyy-MM-dd");
        String dataDeEntrada = formatBra.format(membro.getDataDeEntrada());
        String dataDeSaida = formatBra.format(membro.getDataDeSaida());
        ModelAndView mv = new ModelAndView();
        mv.addObject("dataDeEntrada", dataDeEntrada);
        mv.addObject("dataDeSaida", dataDeSaida);
        mv.addObject("membro", membro);
        mv.setViewName("membros/detalhes");
        return mv;
    }

    @RequestMapping(value = { "/excluir/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaExcluir(@PathVariable(value = "id", required = true) Long id) {
        repositoryMembro.deleteById(id);
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
        return mv;
    }

}
