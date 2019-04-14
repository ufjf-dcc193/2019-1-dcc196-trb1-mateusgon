package br.ufjf.dcc196.trab01.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView home()
    {
        return new ModelAndView("atividades/index");
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.GET)
    public ModelAndView carregaForm()
    {
        List<Sede> sedes = repositorySede.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sedes", sedes);
        mv.setViewName("atividades/criar");
        return mv;
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.POST)
    public ModelAndView recebeForm(Atividade atividade, Long sedeAtividade)
    {
        Sede sede = repositorySede.getOne(sedeAtividade);
        atividade.setSede(sede);
        repositoryAtividade.save(atividade);
        ModelAndView mv = new ModelAndView();
        List<Atividade> atividades = repositoryAtividade.findAll();
        mv.addObject("atividades", atividades);
        mv.setViewName("atividades/index");
        return mv;
    }

    @RequestMapping(value = {"/editar"}, method = RequestMethod.GET)
    public ModelAndView carregaEditar()
    {
        return null;
    }

    @RequestMapping(value = {"/editar"}, method = RequestMethod.POST)
    public ModelAndView recebeEditar()
    {
        return null;
    }


    @RequestMapping(value = {"/detalhes"}, method = RequestMethod.GET)
    public ModelAndView carregaDetalhes(@RequestParam(value = "id", required = true) Long id)
    {
        Atividade atividade = repositoryAtividade.getOne(id);
        Sede sede = atividade.getSede();
        return null;
    }

    @RequestMapping(value = {"/excluir"}, method = RequestMethod.GET)
    public ModelAndView carregaExcluir(@RequestParam(value = "id", required = true) Long id)
    {
        repositoryAtividade.deleteById(id);
        ModelAndView mv = new ModelAndView();
        List<Atividade> atividades = repositoryAtividade.findAll();
        mv.addObject("membros", atividades);
        mv.setViewName("atividades/index");
        return mv;
    }
}