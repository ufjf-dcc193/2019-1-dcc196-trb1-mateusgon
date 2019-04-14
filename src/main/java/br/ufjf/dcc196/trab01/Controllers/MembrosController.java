package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/membros")
public class MembrosController {

    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView home()
    {
        return new ModelAndView("membros/index");
    }
}
