package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SedesController {

    @RequestMapping("sedes.html")
    public String home()
    {
        return "sedes";
    }
}