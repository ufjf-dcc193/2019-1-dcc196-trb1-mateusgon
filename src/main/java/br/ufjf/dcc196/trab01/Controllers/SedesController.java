package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sedes")
public class SedesController {

    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView home()
    {
        return new ModelAndView("sedes/index");
    }

    @RequestMapping(value = {"/criar"})
    public ModelAndView criar()
    {
        return new ModelAndView("sedes/criar");
    }
}