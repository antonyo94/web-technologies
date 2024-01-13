package main.java.com.aabate.scuolacalcio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import main.java.com.aabate.scuolacalcio.model.Ruolo;
import main.java.com.aabate.scuolacalcio.model.Utente;
import main.java.com.aabate.scuolacalcio.repository.UtenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("UtenteService")
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteDao userDao;

    @Override
    public Utente findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(Utente user) {
        userDao.save(user);
    }


    @Override
    public List<Utente> findAllAccount() {
       return userDao.findAllAccount();
    }

}
