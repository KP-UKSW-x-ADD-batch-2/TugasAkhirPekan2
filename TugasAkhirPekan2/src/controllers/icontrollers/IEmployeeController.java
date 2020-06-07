/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.Date;
import java.util.List;
import models.Departement;
import models.Employee;
import models.Job;

/**
 *
 * @author Yosef Febrianes
 */
public interface IEmployeeController {

    public List<Employee> getAll();

    public List<Employee> search(Object keyword);

    public Employee getById(String employeeId);

    public String insert(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commisionPct, String manager, String departement);

    public String update(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commisionPct, String manager, String departement);

    public String delete(String employeeId);
}
