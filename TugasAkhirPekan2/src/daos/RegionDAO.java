/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.IRegionDAO;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import models.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Yosef Febrianes
 */
public class RegionDAO implements IRegionDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public RegionDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Region";
            regions = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return regions;
    }

    @Override
    public Region getById(String id) {
        Region region = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE Id = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            region = (Region) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public List<Region> search(Object keyword) {
        List<Region> region = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {

            String hql = "FROM Region WHERE id LIKE '%a%' OR name LIKE '%a%'";                  //SELECT * FROM `countries` WHERE countries.country_name LIKE '%1%' OR countries.country_id LIKE '%1%'
            Query query = session.createQuery(hql);
            query.setParameter("a", keyword);
            region = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public boolean insert(Region region) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(region);
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
    public boolean update(Region region) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.update(region);
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
//            session.delete(id);
            Region region = (Region) session.load(Region.class, id);
            session.delete(region);
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
