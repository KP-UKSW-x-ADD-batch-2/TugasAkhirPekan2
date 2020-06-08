/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.ICountryDAO;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class CountryDAO implements ICountryDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public CountryDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Country";
            countries = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return countries;
    }

    @Override
    public Country getById(String id) {
        Country country = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Country WHERE Id = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            country = (Country) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return country;

    }

    @Override
    public List<Country> search(Object keyword) {
        List<Country> countries = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Country WHERE id LIKE '%a%' OR name LIKE '%a%'";      //SELECT * FROM `countries` WHERE id LIKE '%s%' OR name LIKE '%s%'
//            String hql = "FROM Country WHERE country = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", keyword);
            countries = session.createQuery(hql).list();
//            countries = (Country) query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return countries;
    }

    @Override
    public boolean insert(Country country) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(country);
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
    public boolean update(Country country) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.update(country);
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
    public boolean delete(String id) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();

        try {
            Country country = (Country) session.load(Country.class, id);
            session.delete(country);
//            session.delete(new Country(id));
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
