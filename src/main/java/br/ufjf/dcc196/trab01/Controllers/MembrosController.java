package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MembrosController {

    @RequestMapping("membros.html")
    public String home()
    {
        return "membros";
    }
}
