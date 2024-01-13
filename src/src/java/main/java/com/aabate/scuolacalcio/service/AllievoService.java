
package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Allievo;


public interface AllievoService {
    
    public void save(Allievo allievo);
    public Allievo findByNumber(String number);
    public List<Allievo> findByCfParent(String cf);
    public List<Allievo> findAllItem();
    public void deleteByNumTesserino(String numeroTesserino);
     public void deleteByCf(String cf);
    
}
