package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Utente;
import main.java.com.aabate.scuolacalcio.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("UtenteDao")
public class UtenteDaoImpl implements UtenteDao {

    @Override
    public Utente findByUsername(String username) {
        Utente user;
        String str = "FROM Utente where username= :value";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        query.setParameter("value", username);
        user = (Utente) query.uniqueResult();
        return user;
    }

    @Override
    public void save(Utente user) {
        
        if (this.findByUsername(user.getUsername()) != null) {
            //do nothing
        } else {
                
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(user);
            session.getTransaction().commit();
        }
    }



    @Override
    public List<Utente> findAllAccount() {
        List<Utente> users;
        String str = "FROM Utente";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        users = query.list();
        return users;
    }

}
