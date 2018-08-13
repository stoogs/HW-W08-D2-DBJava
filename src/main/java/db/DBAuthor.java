package db;


import models.Author;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBAuthor {

        private static Session session;
        private static Transaction transaction;

        public static void save(Author author) { // ADDED
            session = HibernateUtil.getSessionFactory().openSession();
            try {
                transaction = session.beginTransaction();
                session.save(author);
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

        public static Author findById(int id){
            Author result = null;
            session = HibernateUtil.getSessionFactory().openSession();
            try{
                Criteria cr = session.createCriteria(Author.class);
                cr.add(Restrictions.eq("id",id));
                result = (Author) cr.uniqueResult();
            } catch(HibernateException ex) {
                ex.printStackTrace();
            }finally {
                session.close();
            }
            return result;
        }

    public static List<Author> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Author> results = null;

        try {
            Criteria cr = session.createCriteria(Author.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void update(int id, String newName) { // ADDED
    Author result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Author.class);
            cr.add(Restrictions.eq("id",id));
            result = (Author) cr.uniqueResult();
            System.out.println(result.getName());
            result.setName(newName);
            transaction = session.beginTransaction();
            session.update(result);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
