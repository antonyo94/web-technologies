package main.java.com.aabate.scuolacalcio.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Allievo;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.model.Pagamento;
import main.java.com.aabate.scuolacalcio.service.AllievoService;
import main.java.com.aabate.scuolacalcio.service.GenitoreService;
import main.java.com.aabate.scuolacalcio.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("PagamentoDao")
public class PagamentoDaoImpl implements PagamentoDao {

    @Autowired
    GenitoreService genitoreDao;

    @Autowired
    AllievoService allievoDao;

    @Override
    public void save(Pagamento pagamento) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(pagamento);
        session.getTransaction().commit();
    }

    @Override
    public List<Pagamento> findAllPaymentsByName(String username) {

        List<Pagamento> item;
        List<Pagamento> risultato = new ArrayList<Pagamento>();
        Allievo allievo;
        Genitore genitore = genitoreDao.findByEmail(username);
        List<Allievo> listaFigli = allievoDao.findByCfParent(genitore.getCf());
        Iterator it = listaFigli.iterator();
        while (it.hasNext()) {
            allievo = (Allievo) it.next();
            item = this.findByNumTesserino(allievo.getNumeroTesserino());
            for (Pagamento i : item) {
                risultato.add(i);
            }
        }
        return risultato;
    }

    @Override
    public List<Pagamento> findByNumTesserino(String numTesserino) {
        List<Pagamento> result;
        String str = "FROM Pagamento where numTesserino.numeroTesserino=:numeroTesserino";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(str);
        query.setParameter("numeroTesserino", numTesserino);
        result = query.list();
        return result;
    }

    @Override
    public List<Pagamento> findAllPayments() {
        List<Pagamento> result;
        String str = "FROM Pagamento";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        result = query.list();
        return result;
    }

    @Override
    public void deleteById(int id) {
        Pagamento pagamento;
        String str = "FROM Pagamento WHERE id=:id";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(str);
        query.setParameter("id", id);
        pagamento = (Pagamento) query.uniqueResult();
        session.delete(pagamento);
        session.getTransaction().commit();
    }

    @Override
    public void deleteByNumTesserino(String numTesserino) {
        if (this.findByNumTesserino(numTesserino).isEmpty()) {
            //do nothing
        } else {
            Pagamento pagamento;
            String str = " FROM Pagamento WHERE numTesserino.numeroTesserino=:numeroTesserino";
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery(str);
            query.setParameter("numeroTesserino", numTesserino);
            pagamento = (Pagamento) query.uniqueResult();
            session.delete(pagamento);
            session.getTransaction().commit();
        }

    }

}
