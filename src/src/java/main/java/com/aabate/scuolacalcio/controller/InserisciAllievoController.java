package main.java.com.aabate.scuolacalcio.controller;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.model.TelefonoGenitore;
import main.java.com.aabate.scuolacalcio.service.GenitoreService;
import main.java.com.aabate.scuolacalcio.service.TelefonoGenitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import main.java.com.aabate.scuolacalcio.model.Allievo;
import main.java.com.aabate.scuolacalcio.model.Ruolo;
import main.java.com.aabate.scuolacalcio.model.Utente;
import main.java.com.aabate.scuolacalcio.service.AllievoService;
import main.java.com.aabate.scuolacalcio.service.UtenteService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InserisciAllievoController {

    @Autowired
    GenitoreService genitoreService;

    @Autowired
    TelefonoGenitoreService telGenitoreService;

    @Autowired
    AllievoService allievoService;

    @Autowired
    UtenteService utenteService;

    private Object model;

    @RequestMapping(value = "inserisci_allievo", method = RequestMethod.GET)
    public String inserisciAllievoGet(@ModelAttribute Genitore genitore, @ModelAttribute TelefonoGenitore telGenitore, @ModelAttribute Allievo allievo, Utente utente, Model model) {
        model.addAttribute("genitore", genitore);
        model.addAttribute("telGenitore", telGenitore);
        model.addAttribute("allievo", allievo);
        model.addAttribute("utente", utente);
        return "inserisci_allievo";
    }

    @RequestMapping(value = "inserisci_allievo", method = RequestMethod.POST)
    public String inserisciAllievoPost(@ModelAttribute Genitore genitore, @ModelAttribute TelefonoGenitore telGenitore, @Valid @ModelAttribute Allievo allievo, BindingResult result, @ModelAttribute Utente utente, Model model) {

        boolean error = false;
        Ruolo ruolo = new Ruolo();
        ruolo.setName("ROLE_PARENT");

        if (genitore.getNomeGenitore().isEmpty()) {
            model.addAttribute("erroreCf", "Codice Fiscale richiesto");
            error = true;
        }
        if (genitore.getEmail().isEmpty()) {
            model.addAttribute("erroreEmail", "Inserire Email");
            error = true;
        }

        telGenitore.setGenitore(genitore);
        genitore.getNumeriTelefono().add(telGenitore);
        allievo.setGenitore(genitore);
        utente.setUsername(genitore.getEmail());
        utente.getRoles().add(ruolo);

        if (result.hasErrors() || error) {
            return "inserisci_allievo";
        }

        genitoreService.save(genitore);
        telGenitoreService.save(telGenitore);
        allievoService.save(allievo);
        utenteService.save(utente);
        return "redirect:lista_genitori";

    }

    @RequestMapping(value = "lista_allievi", method = RequestMethod.GET)
    public String listaAllievi(Model model) {
        List<Allievo> listaA = allievoService.findAllItem();
        model.addAttribute("listaA", listaA);
        return "lista_allievi";
    }

    @RequestMapping(value = "/lista_allievi/delete")
    public String deleteAllievo(@RequestParam("numTesserino") String numeroTesserino) {
        allievoService.deleteByNumTesserino(numeroTesserino);
        return "redirect:/";

    }

}
