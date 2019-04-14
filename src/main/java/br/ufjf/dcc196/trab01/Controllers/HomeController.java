package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "index.html"})
    public String home()
    {
        return "home/index";
    }

    @RequestMapping("sobre.html")
    public String about() {
        return "home/sobre";
    }
    
}