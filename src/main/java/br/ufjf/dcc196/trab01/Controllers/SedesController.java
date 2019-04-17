package br.ufjf.dcc196.trab01.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc196.trab01.Models.Atividade;
import br.ufjf.dcc196.trab01.Models.Membro;
import br.ufjf.dcc196.trab01.Models.Sede;
import br.ufjf.dcc196.trab01.Persistence.AtividadeRepository;
import br.ufjf.dcc196.trab01.Persistence.MembroRepository;
import br.ufjf.dcc196.trab01.Persistence.SedeRepository;

@Controller
@RequestMapping("/sedes")
public class SedesController {

    @Autowired
    private SedeRepository repositorySede;
    @Autowired
    private AtividadeRepository repositoryAtividade;
    @Autowired
    private MembroRepository repositoryMembro;
    
    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.GET)
    public ModelAndView carregaForm()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sedes/criar");
        return mv;
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.POST)
    public ModelAndView recebeForm(Sede sede)
    {
        repositorySede.save(sede);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }

    @RequestMapping(value = {"/editar"}, method = RequestMethod.GET)
    public ModelAndView carregaEditar(@RequestParam(value = "id", required = true) Long id)
    {
        Sede sede = repositorySede.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sede", sede);
        mv.setViewName("sedes/editar");
        return mv;
    }

    @RequestMapping(value = {"/editar"}, method = RequestMethod.POST)
    public ModelAndView recebeEditar(@RequestParam(value = "id", required = true) Long id, Sede sede)
    {
        sede.setId(id);
        repositorySede.save(sede);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }


    @RequestMapping(value = {"/detalhes"}, method = RequestMethod.GET)
    public ModelAndView carregaDetalhes(@RequestParam(value = "id", required = true) Long id)
    {
        Sede sede = repositorySede.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("");
        return mv;
    }

    @RequestMapping(value = {"/detalhes/{tipoInfoSede}/{id}"}, method = RequestMethod.GET)
    public @ResponseBody List getInfoSede(@PathVariable("tipoInfoSede") String tipoInfoSede, @PathVariable("id") Long id)
    {
        if (tipoInfoSede.equals("atividades"))
        {
            List<Atividade> atividadesFinais = new ArrayList<>();
            List<Atividade> atividades = repositoryAtividade.findAll();
            for (Atividade atv : atividades) {
                if (atv.getSede().getId() == id)
                {
                    atividadesFinais.add(atv);
                }
            }
            return atividadesFinais;
        }
        else
        {
            List<Membro> membrosFinais = new ArrayList<>();
            List<Membro> membros = repositoryMembro.findAll();
            for (Membro membro : membros) {
                if (membro.getSede().getId() == id)
                {
                    membrosFinais.add(membro);
                }
            }
            return membrosFinais;
        }
    }

    @RequestMapping(value = {"/excluir"}, method = RequestMethod.GET)
    public ModelAndView carregaExcluir(@RequestParam(value = "id", required = true) Long id)
    {
        repositorySede.deleteById(id);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }
}