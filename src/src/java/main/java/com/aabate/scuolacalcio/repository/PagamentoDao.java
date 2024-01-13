

package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Pagamento;

public interface PagamentoDao {
    public void save(Pagamento pagamento);
    public List<Pagamento> findAllPaymentsByName(String username);
    public List<Pagamento> findByNumTesserino(String numTesserino);
    public List<Pagamento> findAllPayments();
    public void deleteById(int id);
    public void deleteByNumTesserino(String numTesserino);
}
