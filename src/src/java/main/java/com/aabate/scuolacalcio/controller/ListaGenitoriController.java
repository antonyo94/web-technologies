package main.java.com.aabate.scuolacalcio.controller;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.model.TelefonoGenitore;
import main.java.com.aabate.scuolacalcio.service.GenitoreService;
import main.java.com.aabate.scuolacalcio.service.TelefonoGenitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListaGenitoriController {

    @Autowired
    GenitoreService genitoreService;

    @Autowired
    TelefonoGenitoreService telGenitoreService;

    @RequestMapping(value = "lista_genitori", method = RequestMethod.GET)
    String listaGenitori(Model model) {
        List<Genitore> listG = genitoreService.findAllParents();
        List<TelefonoGenitore> listP = telGenitoreService.findAllNumbers();

        model.addAttribute("listP", listP);
        model.addAttribute("listG", listG);
        return "lista_genitori";
    }

    @RequestMapping(value = "rimuovi_genitore")
    String rimuoviGenitore(Model model, @ModelAttribute List<Genitore> list) {

        return "lista_genitori";
    }

    // delete user
    @RequestMapping(value = "/lista_genitori/delete")
    public String deleteUser(@RequestParam("cf") String cf) {

        genitoreService.deleteByCf(cf);

        return "redirect:/";

    }
}
