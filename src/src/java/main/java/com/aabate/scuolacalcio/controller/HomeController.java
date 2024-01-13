package main.java.com.aabate.scuolacalcio.controller;

import main.java.com.aabate.scuolacalcio.model.Allievo;
import main.java.com.aabate.scuolacalcio.model.Pagamento;
import main.java.com.aabate.scuolacalcio.model.Ruolo;
import main.java.com.aabate.scuolacalcio.model.Utente;
import main.java.com.aabate.scuolacalcio.service.PagamentoService;
import main.java.com.aabate.scuolacalcio.service.UtenteService;
import main.java.com.aabate.scuolacalcio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @Autowired 
    UtenteService utenteDao;
    
    @RequestMapping({"/", "/home"})
    public String home() {
        
        Utente u = new Utente();
        Ruolo r = new Ruolo();
        u.setUsername("user");
        u.setPassword("user");
        r.setName("ROLE_ADMIN");
        u.getRoles().add(r);
        utenteDao.save(u);
                
        return "index";
    }
}
