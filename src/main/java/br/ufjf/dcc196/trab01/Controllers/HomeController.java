package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @RequestMapping({"", "index.html"})
    public String home()
    {
        return "index";
    }

    @RequestMapping("sobre.html")
    public String about() {
        return "sobre";
    }
    
}