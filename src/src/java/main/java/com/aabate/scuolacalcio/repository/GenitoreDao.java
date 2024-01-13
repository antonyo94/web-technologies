package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import main.java.com.aabate.scuolacalcio.model.Genitore;

public interface GenitoreDao {

    public void save(Genitore genitore);
    public Genitore findByCf(String cf);
    public List<Genitore> findAllParents();
    public void deleteByCf(String cf);
    public Genitore findByEmail(String email);
}
