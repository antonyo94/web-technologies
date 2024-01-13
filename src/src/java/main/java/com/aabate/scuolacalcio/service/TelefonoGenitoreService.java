package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.TelefonoGenitore;

public interface TelefonoGenitoreService {

    void save(TelefonoGenitore telGenitore);

    public List<TelefonoGenitore> findByCf(String cf);

    public void deleteByCf(String cf);

    public void deleteByNumber(String numero);

    public List<TelefonoGenitore> findAllNumbers();

    public TelefonoGenitore findByNumber(String number);
}
