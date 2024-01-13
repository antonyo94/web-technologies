package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Allievo;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.service.PagamentoService;
import main.java.com.aabate.scuolacalcio.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AllievoDao")
public class AllievoDaoImpl implements AllievoDao {

    @Autowired
    PagamentoService pagamentoDao;

    @Override
    public void save(Allievo allievo) {

        if (this.findByNumber(allievo.getNumeroTesserino()) != null) {
            //do nothing
        } else {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(allievo);
            session.getTransaction().commit();
        }

    }

    @Override
    public Allievo findByNumber(String number) {
        Allievo allievo;
        String str = "FROM Allievo where numeroTesserino=:value";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        query.setParameter("value", number);
        allievo = (Allievo) query.uniqueResult();
        return allievo;
    }

    @Override
    public List<Allievo> findByCfParent(String cf) {
        List<Allievo> result;
        String str = "FROM Allievo where genitore.cf=:cf";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(str);
        query.setParameter("cf", cf);
        result = query.list();
        return result;
    }

    @Override
    public List<Allievo> findAllItem() {
        List<Allievo> result;
        String str = "FROM Allievo";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        result = query.list();
        return result;
    }

    @Override
    public void deleteByNumTesserino(String numeroTesserino) {
        Allievo allievo;
        String str = "FROM Allievo WHERE numeroTesserino=:numTesserino";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(str);
        query.setParameter("numTesserino", numeroTesserino);
        pagamentoDao.deleteByNumTesserino(numeroTesserino);

        allievo = (Allievo) query.uniqueResult();
        session.delete(allievo);
        session.getTransaction().commit();
    }

    @Override
    public void deleteByCf(String cf) {
        if (this.findByCfParent(cf).isEmpty()) {
            //do nothing
        } else {
            List<Allievo> allievo;
            String str = " FROM Allievo WHERE genitore.cf=:cf";
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery(str);
            query.setParameter("cf", cf);
            allievo = query.list();
            if (allievo.isEmpty()) {
                //do Nothing
            } else {
                for (Allievo i : allievo) {
                    pagamentoDao.deleteByNumTesserino(i.getNumeroTesserino());
                    session.delete(i);
                }

                session.getTransaction().commit();
            }

        }
    }
}
