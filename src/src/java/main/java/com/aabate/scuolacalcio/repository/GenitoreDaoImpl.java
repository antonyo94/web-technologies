package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import java.util.Locale.Category;
import org.hibernate.Query;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.service.AllievoService;
import main.java.com.aabate.scuolacalcio.service.TelefonoGenitoreService;
import main.java.com.aabate.scuolacalcio.service.UtenteService;
import org.springframework.stereotype.Repository;
import main.java.com.aabate.scuolacalcio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Repository("GenitoreDao")
public class GenitoreDaoImpl implements GenitoreDao {
    
    @Autowired
    TelefonoGenitoreService telGenitoreService;
    
    @Autowired
    AllievoService allievoService;
    
    @Autowired
    UtenteService utenteService;
    
    @Override
    public void save(Genitore genitore) {
        if (this.findByCf(genitore.getCf()) != null) {
            //do nothing
        } else {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(genitore);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Genitore> findAllParents() {
        List<Genitore> result;
        String str = "FROM Genitore";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        result = query.list();
        return result;

    }

    @Override
    public void deleteByCf(String cf) {

        Genitore genitore;
        String str = "FROM Genitore WHERE cf=:cf"; 
        telGenitoreService.deleteByCf(cf);
        allievoService.deleteByCf(cf);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(str);
        query.setParameter("cf", cf);
        genitore = (Genitore) query.uniqueResult();
        session.delete(genitore);
        session.getTransaction().commit();

    }

    @Override
    public Genitore findByEmail(String email) {
        Genitore genitore;
        String str = "FROM Genitore where email= :value";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        query.setParameter("value", email);
        genitore = (Genitore) query.uniqueResult();
        return genitore;
    }

    @Override
    public Genitore findByCf(String cf) {
        Genitore genitore;
        String str = "FROM Genitore where cf=:value";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        query.setParameter("value", cf);
        genitore = (Genitore) query.uniqueResult();
        return genitore;
    }

}
