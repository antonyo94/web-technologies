package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Genitore;

public interface GenitoreService {

    void save(Genitore genitore);
    public List<Genitore> findAllParents();
    public void deleteByCf(String cf);
    public Genitore findByEmail(String email);
    public Genitore findByCf(String cf);
}
