/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.ILocationDAO;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Yosef Febrianes
 */
public class LocationDAO implements ILocationDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public LocationDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Location";
            locations = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return locations;
    }

    @Override
    public Location getById(String id) {
        Location location = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Location WHERE Id = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            location = (Location) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return location;

    }

    @Override
    public List<Location> search(Object keyword) {
        List<Location> locations = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Location WHERE id LIKE '%a%' OR name LIKE '%a%'";      //SELECT * FROM `locations` WHERE id LIKE '%s%' OR name LIKE '%s%'
//            String hql = "FROM Location WHERE location = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", keyword);
            locations = session.createQuery(hql).list();
//            locations = (Location) query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return locations;
    }

    @Override
    public boolean insert(Location location) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(location);
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
    public boolean update(Location location) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.update(location);
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
            Location location = (Location) session.load(Location.class, id);
            session.delete(location);
//            session.delete(new Location(id));
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
