
package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Pagamento;
import main.java.com.aabate.scuolacalcio.repository.PagamentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PagamentoService")
public class PagamentoServiceImpl implements PagamentoService{

    @Autowired
    PagamentoDao pagamentoDao;
    
    @Override
    public void save(Pagamento pagamento) {
       pagamentoDao.save(pagamento);
    }

    @Override
    public List<Pagamento> findAllPaymentsByName(String cf) {
        return pagamentoDao.findAllPaymentsByName(cf);
    }

    @Override
    public List<Pagamento> findByNumTesserino(String numTesserino) {
       return pagamentoDao.findByNumTesserino(numTesserino);
    }

    @Override
    public List<Pagamento> findAllPayments() {
        return pagamentoDao.findAllPayments();
    }

    @Override
    public void deleteById(int id) {
        pagamentoDao.deleteById(id);
    }

    @Override
    public void deleteByNumTesserino(String numTesserino) {
       pagamentoDao.deleteByNumTesserino(numTesserino);
    }
    
    
}
