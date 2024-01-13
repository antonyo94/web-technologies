package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.repository.GenitoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GenitoreService")
public class GenitoreServiceImpl implements GenitoreService {

    @Autowired
    private GenitoreDao genitoreDao;
    

    @Override
    public void save(Genitore genitore) {
        genitoreDao.save(genitore);
    }

    @Override
    public List<Genitore> findAllParents(){
        return genitoreDao.findAllParents();
    }
    
    @Override
    public void deleteByCf(String cf){
        genitoreDao.deleteByCf(cf);
    }

    @Override
    public Genitore findByEmail(String email) {
        return genitoreDao.findByEmail(email);
    }

    @Override
    public Genitore findByCf(String cf) {
       return genitoreDao.findByCf(cf);
    }
}
