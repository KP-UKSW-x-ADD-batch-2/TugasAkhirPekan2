/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.IEmployeeController;
import daos.EmployeeDAO;
import daos.idaos.IEmployeeDAO;
import java.util.Date;
import java.util.List;
import models.Departement;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO iedao;

    public EmployeeController(SessionFactory factory) {
        iedao = new EmployeeDAO(factory);
    }

    @Override
    public List<Employee> getAll() {
        return iedao.getAll();
    }

    @Override
    public List<Employee> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getById(String employeeId) {
        return iedao.getById(employeeId);
    }

    @Override
    public String insert(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commisionPct, String manager, String departement) {
        Employee reg = new Employee(
                employeeId,
                firstName,
                lastName,
                email,
                phoneNumber,
                new Date(hireDate),
                new Job(job),
                Integer.parseInt(salary),
                Float.parseFloat(commisionPct),
                new Employee(manager), new Departement(departement));
        if (iedao.insert(reg)) {
            return "Insert " + employeeId + " success!";
        } else {
            return "Insert " + employeeId + " failed!";
        }
    }

    @Override
    public String delete(String employeeId) {
        if (iedao.delete(employeeId)) {
            return "Delete " + employeeId + " success!";
        } else {
            return "Delete " + employeeId + " failed";
        }
    }

    @Override
    public String update(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commisionPct, String manager, String departement) {
        Employee reg = new Employee(
                employeeId,
                firstName,
                lastName,
                email,
                phoneNumber,
                new Date(hireDate),
                new Job(job),
                Integer.parseInt(salary),
                Float.parseFloat(commisionPct),
                new Employee(manager), new Departement(departement));
        if (iedao.update(reg)) {
            return "Update " + employeeId + " success!";
        } else {
            return "Update " + employeeId + " failed!";
        }
    }

}
