package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Utente;

public interface UtenteService {

    public Utente findByUsername(String username);
    public void save(Utente user);
    public List<Utente> findAllAccount();
    
}
