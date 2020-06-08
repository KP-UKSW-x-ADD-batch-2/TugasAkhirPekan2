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
import daos.idaos.IAccountDAO;

/**
 *
 * @author Yosef Febrianes
 */
public class AccountDAO implements IAccountDAO{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public AccountDAO(SessionFactory factory){
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
}
