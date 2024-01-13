package main.java.com.aabate.scuolacalcio.service;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Pagamento;

public interface PagamentoService {

    public void save(Pagamento pagamento);

    public List<Pagamento> findAllPaymentsByName(String cf);

    public List<Pagamento> findByNumTesserino(String numTesserino);

    public List<Pagamento> findAllPayments();

    public void deleteById(int id);

    public void deleteByNumTesserino(String numTesserino);
}
