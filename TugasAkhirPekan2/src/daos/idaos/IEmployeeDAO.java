/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Employee;

/**
 *
 * @author Yosef Febrianes
 */
public interface IEmployeeDAO {

    public List<Employee> getAll();

    public Employee getById(String id);

    public List<Employee> search(Object keyword);

    public boolean insert(Employee employee);

    public boolean update(Employee employee);

    public boolean delete(String id);
}
