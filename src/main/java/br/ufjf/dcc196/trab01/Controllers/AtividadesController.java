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

import br.ufjf.dcc196.trab01.Models.Atividade;
import br.ufjf.dcc196.trab01.Models.Sede;
import br.ufjf.dcc196.trab01.Persistence.AtividadeRepository;
import br.ufjf.dcc196.trab01.Persistence.SedeRepository;

@Controller
@RequestMapping("/atividades")
public class AtividadesController {

    @Autowired
    private AtividadeRepository repositoryAtividade;
    @Autowired
    private SedeRepository repositorySede;

    @RequestMapping(value = { "/", "", "/index" })
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        List<Atividade> atividades = repositoryAtividade.findAll();
        mv.addObject("atividades", atividades);
        mv.setViewName("atividades/index");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.GET)
    public ModelAndView carregaForm() {
        List<Sede> sedes = repositorySede.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sedes", sedes);
        mv.setViewName("atividades/criar");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.POST)
    public ModelAndView recebeForm(Atividade atividade, Long sedeAtividade) {
        Sede sede = repositorySede.getOne(sedeAtividade);
        atividade.setSede(sede);
        repositoryAtividade.save(atividade);
        List<Atividade> atividades = repositoryAtividade.findAll();
        ModelAndView mv = new ModelAndView("redirect:/atividades");
        mv.addObject("atividades", atividades);
        mv.setViewName("atividades/index");
        return mv;
    }

    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaEditar(@PathVariable(value = "id", required = true) Long id) {
        Atividade atividade = repositoryAtividade.getOne(id);
        SimpleDateFormat formatBra = new SimpleDateFormat("yyyy-MM-dd");
        String dataDeInicio = formatBra.format(atividade.getDataDeInicio());
        String dataDeFim = formatBra.format(atividade.getDataDeFim());
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("dataDeInicio", dataDeInicio);
        mv.addObject("dataDeFim", dataDeFim);
        mv.addObject("sedes", sedes);
        mv.addObject("sede", atividade.getSede());
        mv.addObject("atividade", atividade);
        mv.setViewName("atividades/editar");
        return mv;
    }

    @RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
    public ModelAndView recebeEditar(@RequestParam(value = "id", required = true) Long id, Atividade atividade) {
        atividade.setId(id);
        repositoryAtividade.save(atividade);
        List<Atividade> atividades = repositoryAtividade.findAll();
        ModelAndView mv = new ModelAndView("redirect:/atividades");
        mv.addObject("atividades", atividades);
        mv.setViewName("atividades/index");
        return mv;
    }

    @RequestMapping(value = { "/detalhes/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaDetalhes(@PathVariable(value = "id", required = true) Long id) {
        ModelAndView mv = new ModelAndView();
        Atividade atividade = repositoryAtividade.getOne(id);
        SimpleDateFormat formatBra = new SimpleDateFormat("yyyy-MM-dd");
        String dataDeInicio = formatBra.format(atividade.getDataDeInicio());
        String dataDeFim = formatBra.format(atividade.getDataDeFim());
        mv.addObject("dataDeInicio", dataDeInicio);
        mv.addObject("dataDeFim", dataDeFim);
        mv.addObject("atividade", atividade);
        mv.setViewName("atividades/detalhes");
        return mv;
    }

    @RequestMapping(value = { "/excluir/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaExcluir(@PathVariable(value = "id", required = true) Long id) {
        repositoryAtividade.deleteById(id);
        List<Atividade> atividades = repositoryAtividade.findAll();
        ModelAndView mv = new ModelAndView("redirect:/atividades");
        mv.addObject("atividades", atividades);
        mv.setViewName("atividades/index");
        return mv;
    }
}