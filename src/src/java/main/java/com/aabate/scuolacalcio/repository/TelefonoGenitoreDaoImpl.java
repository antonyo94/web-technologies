package main.java.com.aabate.scuolacalcio.repository;

import java.util.List;
import main.java.com.aabate.scuolacalcio.model.Genitore;
import main.java.com.aabate.scuolacalcio.model.TelefonoGenitore;
import org.springframework.stereotype.Repository;
import main.java.com.aabate.scuolacalcio.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository("TelefonoGenitoreDao")
public class TelefonoGenitoreDaoImpl implements TelefonoGenitoreDao {

    @Override
    public void save(TelefonoGenitore telGenitore) {
        if (this.findByNumber(telGenitore.getNumeroTelefono()) != null) {
    //do nothing
        } else {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(telGenitore);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteByNumber(String numero) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "DELETE FROM TelefonoGenitore"
                + "WHERE numeroT = :numero";
        Query query = session.createQuery(hql);
        query.setParameter("numero", numero);
        query.executeUpdate();

    }



    @Override
    public List<TelefonoGenitore> findAllNumbers() {
        List<TelefonoGenitore> result;
        String str = "FROM TelefonoGenitore";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        result = query.list();
        return result;
    }

    @Override
    public TelefonoGenitore findByNumber(String number) {
        TelefonoGenitore telGenitore;
        String str = "FROM TelefonoGenitore where numeroTelefono=:value";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(str);
        query.setParameter("value", number);
        telGenitore = (TelefonoGenitore) query.uniqueResult();
        return telGenitore;
    }

    @Override
    public List<TelefonoGenitore> findByCf(String cf) {
        List<TelefonoGenitore> result;
        String str = "FROM TelefonoGenitore where genitore.cf=:cf";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(str);
        query.setParameter("cf", cf);
        result = query.list();
        return result;
    }

    @Override
    public void deleteByCf(String cf) {
               if (this.findByCf(cf).isEmpty()) {
            //do nothing
        } else {
            List<TelefonoGenitore> telGenitore;
            String str = " FROM TelefonoGenitore WHERE genitore.cf=:cf";
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery(str);
            query.setParameter("cf",cf);
            telGenitore = query.list();
            if(telGenitore.isEmpty()){
                //do nothing
            }
            else{
                for(TelefonoGenitore i: telGenitore){
                    session.delete(i);
                }
            }
            session.getTransaction().commit();
        }
    }

}
