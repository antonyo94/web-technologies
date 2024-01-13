package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.TelefonoGenitore;
import main.java.com.aabate.scuolacalcio.repository.TelefonoGenitoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TelefonoGenitoreService")
public class TelefonoGenitoreServiceImpl implements TelefonoGenitoreService {

    @Autowired
    private TelefonoGenitoreDao telGenitoreDao;

    @Override
    public void save(TelefonoGenitore telGenitore) {
        telGenitoreDao.save(telGenitore);
    }

    

     public void deleteByNumber(String numero){
         telGenitoreDao.deleteByNumber(numero);
     }
     
     public List<TelefonoGenitore> findAllNumbers(){
       return   telGenitoreDao.findAllNumbers();
     }

    @Override
    public TelefonoGenitore findByNumber(String number) {
        return telGenitoreDao.findByNumber(number);
    }

    @Override
    public List<TelefonoGenitore> findByCf(String cf) {
       return telGenitoreDao.findByCf(cf);
    }

    @Override
    public void deleteByCf(String cf) {
        telGenitoreDao.deleteByCf(cf);
    }
}
