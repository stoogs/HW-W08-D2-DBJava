package db;

import models.Book;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBBook {
    private static Session session;
    private static Transaction transaction;

    public static void save(Book book) { // ADDED
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static Book findById(int id){
        Book result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Book.class);
            cr.add(Restrictions.eq("id",id));
            result = (Book) cr.uniqueResult();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public static List<Book> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> results = null;

        try {
            Criteria cr = session.createCriteria(Book.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
