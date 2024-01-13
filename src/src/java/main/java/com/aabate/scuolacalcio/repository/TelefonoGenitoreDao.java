package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.TelefonoGenitore;

public interface TelefonoGenitoreDao {

    public void save(TelefonoGenitore telGenitore);

    public List<TelefonoGenitore> findByCf(String cf);

    public void deleteByCf(String cf);

    public void deleteByNumber(String numero);

    public List<TelefonoGenitore> findAllNumbers();

    public TelefonoGenitore findByNumber(String number);
}
