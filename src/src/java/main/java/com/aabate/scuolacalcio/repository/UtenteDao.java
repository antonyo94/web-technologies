package main.java.com.aabate.scuolacalcio.repository;


import java.util.List;
import org.springframework.stereotype.Repository;
import main.java.com.aabate.scuolacalcio.model.Utente;

public interface UtenteDao {
    
    public void save(Utente user);
    public List<Utente> findAllAccount();
    public Utente findByUsername(String username);

    
}
