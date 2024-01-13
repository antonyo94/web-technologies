package main.java.com.aabate.scuolacalcio.controller;

import javax.validation.Valid;
import main.java.com.aabate.scuolacalcio.model.Allievo;
import main.java.com.aabate.scuolacalcio.model.Pagamento;
import main.java.com.aabate.scuolacalcio.service.AllievoService;
import main.java.com.aabate.scuolacalcio.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InserisciPagamentoController {

    @Autowired
    PagamentoService pagamentoDao;

    @Autowired
    AllievoService allievoDao;

    @RequestMapping(value = "inserisci_pagamento", method = RequestMethod.GET)
    public String inserisci_pagamentoGet(@ModelAttribute Pagamento pagamento, @ModelAttribute Allievo allievo, Model model) {

        model.addAttribute("pagamento", pagamento);
        model.addAttribute(allievo);
        return "inserisci_pagamento";
    }

    @RequestMapping(value = "inserisci_pagamento", method = RequestMethod.POST)
    public String inserisci_pagamentoPost(@Valid @ModelAttribute Pagamento pagamento, BindingResult result, @ModelAttribute Allievo allievo, Model model) {
        Allievo all = allievoDao.findByNumber(allievo.getNumeroTesserino());

        if (result.hasErrors()) {
            return "inserisci_pagamento";
        }
        if (all == null) {
            model.addAttribute("errore", "Numero Tesserino non valido!");
            return "inserisci_pagamento";
        }
        pagamento.setNumTesserino(all);
        pagamentoDao.save(pagamento);

        return "redirect:lista_pagamenti";
    }

}
