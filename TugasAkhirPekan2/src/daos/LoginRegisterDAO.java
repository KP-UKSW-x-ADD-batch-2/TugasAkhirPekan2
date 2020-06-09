/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import daos.idaos.ILoginRegisterDAO;
import org.hibernate.Query;

/**
 *
 * @author Yosef Febrianes
 */
public class LoginRegisterDAO implements ILoginRegisterDAO{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public LoginRegisterDAO(SessionFactory factory){
    this.factory = factory;
    }

    @Override
    public boolean insert(Account account){
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(account);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Account getByUsername(String username) {
        Account account = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Account WHERE username = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", username);
            account = (Account) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return account;
    }
}
