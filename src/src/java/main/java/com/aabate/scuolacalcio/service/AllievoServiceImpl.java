package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Allievo;
import main.java.com.aabate.scuolacalcio.repository.AllievoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AllievoeService")
public class AllievoServiceImpl implements AllievoService {

    @Autowired
    private AllievoDao allievoDao;

    @Override
    public void save(Allievo allievo) {
        allievoDao.save(allievo);
    }

    @Override
    public Allievo findByNumber(String number) {
        return allievoDao.findByNumber(number);
    }

    @Override
    public List<Allievo> findByCfParent(String cf) {
        return allievoDao.findByCfParent(cf);
    }

    @Override
    public List<Allievo> findAllItem() {
        return allievoDao.findAllItem();
    }

    @Override
    public void deleteByNumTesserino(String numeroTesserino) {
        allievoDao.deleteByNumTesserino(numeroTesserino);
    }

    @Override
    public void deleteByCf(String cf) {
        allievoDao.deleteByCf(cf);
    }
}
