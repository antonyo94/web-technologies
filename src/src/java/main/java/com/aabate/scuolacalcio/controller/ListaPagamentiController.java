/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.aabate.scuolacalcio.controller;

import java.security.Principal;
import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Pagamento;
import main.java.com.aabate.scuolacalcio.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListaPagamentiController {

    private Object RequestMethog;
    private Object principal;
    @Autowired
    PagamentoService pagamentoDao;

    @RequestMapping(value = "lista_pagamenti_effettuati", method = RequestMethod.GET)
    public String listaPagamentiGet(Model model, Principal principal) {

        String name = principal.getName(); //get logged in username
        if (pagamentoDao.findAllPayments().isEmpty()) {
            model.addAttribute("username", name);
            return "lista_pagamenti_effettuati";
        } 
            List<Pagamento> listaPagamenti = pagamentoDao.findAllPaymentsByName(name);
            model.addAttribute("listaPagamenti", listaPagamenti);
            model.addAttribute("username", name);
            return "lista_pagamenti_effettuati";


    }

    @RequestMapping(value = "lista_pagamenti", method = RequestMethod.GET)
    public String listaPagamentiEffettuatiGet(Model model) {
        if (pagamentoDao.findAllPayments().isEmpty()) {
            //do nothing
            return "lista_pagamenti";
        } else {
            List<Pagamento> listaPagamenti = pagamentoDao.findAllPayments();
            model.addAttribute("listaPagamenti", listaPagamenti);
            return "lista_pagamenti";
        }

    }

    @RequestMapping(value = "/lista_pagamenti/delete")
    public String deletePagamento(@RequestParam("id") int id) {
        pagamentoDao.deleteById(id);
        return "redirect:/";

    }

}
