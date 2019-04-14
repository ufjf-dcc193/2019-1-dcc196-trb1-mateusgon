package br.ufjf.dcc196.trab01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "index"})
    public String home()
    {
        return "home/index";
    }

    @RequestMapping("sobre")
    public String about() {
        return "home/sobre";
    }
    
}