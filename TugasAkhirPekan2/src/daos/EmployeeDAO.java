/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.IEmployeeDAO;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeDAO implements IEmployeeDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public EmployeeDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Employee";
            employees = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employees;
    }

    @Override
    public Employee getById(String id) {
        Employee employee = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Employee WHERE Id = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            employee = (Employee) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employee;

    }

    @Override
    public List<Employee> search(Object keyword) {
        List<Employee> employees = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Employee WHERE id LIKE '%a%' OR name LIKE '%a%'";      //SELECT * FROM `employees` WHERE id LIKE '%s%' OR name LIKE '%s%'
//            String hql = "FROM Employee WHERE employee = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", keyword);
            employees = session.createQuery(hql).list();
//            employees = (Employee) query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employees;
    }

    @Override
    public boolean insert(Employee employee) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(employee);
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
    public boolean update(Employee employee) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.update(employee);
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
            Employee employee = (Employee) session.load(Employee.class, id);
            session.delete(employee);
//            session.delete(new Employee(id));
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