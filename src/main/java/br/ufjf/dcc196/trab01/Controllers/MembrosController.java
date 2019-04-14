package br.ufjf.dcc196.trab01.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
        return mv;
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.GET)
    public ModelAndView carregaForm()
    {
        List<Sede> sedes = repositorySede.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sedes", sedes);
        mv.setViewName("membros/criar");
        return mv;
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.POST)
    public ModelAndView recebeForm(Membro membro, Long sedeMembro)
    {
        Sede sede = repositorySede.getOne(sedeMembro);
        membro.setSede(sede);
        repositoryMembro.save(membro);
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
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
        Membro membro = repositoryMembro.getOne(id);
        Sede sede = membro.getSede();
        return null;
    }

    @RequestMapping(value = {"/excluir"}, method = RequestMethod.GET)
    public ModelAndView carregaExcluir(@RequestParam(value = "id", required = true) Long id)
    {
        repositoryMembro.deleteById(id);
        ModelAndView mv = new ModelAndView();
        List<Membro> membros = repositoryMembro.findAll();
        mv.addObject("membros", membros);
        mv.setViewName("membros/index");
        return mv;
    }

}
