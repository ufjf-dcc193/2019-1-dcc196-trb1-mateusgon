package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc196.trab01.Models.Sede;

@Controller
@RequestMapping("/sedes")
public class SedesController {

    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView home()
    {
        return new ModelAndView("sedes/index");
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.GET)
    public ModelAndView carregaForm()
    {
        return new ModelAndView("sedes/criar");
    }

    @RequestMapping(value = {"/criar"}, method = RequestMethod.POST)
    public ModelAndView recebeForm(Sede sede)
    {
        System.out.println(sede.getNome());
        System.out.println(sede.getSite());
        System.out.println(sede.getBairro());
        System.out.println(sede.getCidade());
        System.out.println(sede.getEstado());
        System.out.println(sede.getTelefone());
        return new ModelAndView("sedes/index");
    }
}