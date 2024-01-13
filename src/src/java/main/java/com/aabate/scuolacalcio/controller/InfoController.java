package main.java.com.aabate.scuolacalcio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

    @RequestMapping(value = "news")
    public String news() {
        return "news";
    }

    @RequestMapping(value = "contatti")
    public String contatti() {
        return "contatti";
    }

}
