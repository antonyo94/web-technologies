package main.java.com.aabate.scuolacalcio.controller;

import java.util.List;
import javax.validation.Valid;
import main.java.com.aabate.scuolacalcio.model.Ruolo;
import main.java.com.aabate.scuolacalcio.model.Utente;
import main.java.com.aabate.scuolacalcio.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class InserisciAccountController {
    
    @Autowired 
    UtenteService userDao;
    

    
    @RequestMapping(value="inserisci_account",method=RequestMethod.GET)
    public String inserisciAccountGet(@ModelAttribute Utente user,@ModelAttribute Ruolo role,Model model){
        model.addAttribute("utente",user);
        model.addAttribute("role",role);        
        return "inserisci_account";
    }
    
    @RequestMapping(value="inserisci_account",method=RequestMethod.POST)
    public String inserisciAccountPost(@Valid @ModelAttribute Utente user,BindingResult result,@ModelAttribute Ruolo role,Model model){
        
        if(userDao.findByUsername(user.getUsername()) != null){
            
            model.addAttribute("errore","Username non disponibile");
            return "inserisci_account";
        }
        if(result.hasErrors()){
            return "inserisci_account";
        }
        user.getRoles().add(role);
        userDao.save(user);
        return "/";       
    }
    
    @RequestMapping(value="lista_account",method=RequestMethod.GET)
    public String listaAccount(Model model){
        List<Utente> list = userDao.findAllAccount();
        model.addAttribute("listaA",list);       
        
        return "lista_account";
    }
    

    
}
