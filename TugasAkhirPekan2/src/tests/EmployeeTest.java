/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.EmployeeDAO;
import daos.idaos.IEmployeeDAO;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Departement;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeTest {
    
    HibernateUtil sessionFactory = new HibernateUtil();
    IEmployeeDAO iedao = new EmployeeDAO(sessionFactory.getSessionFactory());
    Scanner scann = new Scanner(System.in);
    Employee r = new Employee();
    SessionFactory factory = new HibernateUtil().getSessionFactory();
    EmployeeDAO edao = new EmployeeDAO(factory);
    
    public static void main(String[] args) {
        
        EmployeeTest r = new EmployeeTest();
        Scanner scann = new Scanner(System.in);
        int lanjut = 0;
        do {
            System.out.println("1 = Show");
            System.out.println("2 = Add");
            System.out.println("3 = Update");
            System.out.println("4 = Delete");
            System.out.println("5 = Search");
            System.out.println("6 = GetById");
            System.out.print("pilih mana? = ");
            int a = scann.nextInt();
            
            switch (a) {
                case 1:
                    r.getAll();
                    break;
                case 2:
                    r.insert();
                    break;
                case 3:
                    r.update();
                    break;
                case 4:
                    r.delete();
                    break;
                case 5:
                    r.search();
                    break;
                case 6:
                    r.getById();
                    break;
                default:
                    System.out.println("Pilih yang benar!");
                    break;
                
            }
            System.out.println("lagi? ");
            lanjut = scann.nextInt();
        } while (lanjut == 1);
        
    }
    
    void getAll() {
        List<Employee> employees = iedao.getAll();
        for (Employee data : employees) {
            System.out.println(data.getId() + " " + data.getFirstName() + " " + data.getLastName() + " " + data.getEmail() + " " + data.getPhoneNumber() + " " + data.getHireDate() + " " + data.getJob() + " " + data.getSalary() + " " + data.getCommisionPct() + " " + data.getManager() + " " + data.getDepartement());
        }
    }
    
    void insert() {
        
        System.out.println("Masukkan ID! = ");
        String ei = scann.nextLine();
        System.out.println("Masukkan First Name! = ");
        String fn = scann.nextLine();
        System.out.println("Masukkan Last Name! = ");
        String ln = scann.nextLine();
        System.out.println("Masukkan Email! = ");
        String e = scann.nextLine();
        System.out.println("Masukkan Phone Number! = ");
        String pn = scann.nextLine();
        System.out.println("Masukkan Hire Date! = ");
        String hd = scann.nextLine();
        System.out.println("Masukkan Job ID! = ");
        String ji = scann.nextLine();
        System.out.println("Masukkan Salary! = ");
        int s = scann.nextInt();
        System.out.println("Masukkan Commision Pct! = ");
        Float cp = scann.nextFloat();
        System.out.println("Masukkan Manager ID! = ");
        String mi = scann.nextLine();
        System.out.println("Masukkan Departement ID! = ");
        String di = scann.nextLine();
        
    Employee employee = new Employee(ei, fn, ln, e, pn, new Date(hd), new Job(ji), s, cp, new Employee(mi), new Departement(di));
//    Employee employee = new Employee("E021", "Wo", "Ok", "e@gmai.com", "12345678912", new Date("1999-12-12"), new Job("J001"), 8000000, 0, new Employee("E011"), new Departement("D002"));
        System.out.println(edao.insert(employee));

//        r.setId(ei);
//        r.setFirstName(fn);
//        r.setLastName(ln);
//        r.setEmail(e);
//        r.setPhoneNumber(pn);
//        r.setHireDate(hd);
//        r.setJob(ji);
//        r.setSalary(s);
//        r.setCommisionPct(cp);
//        r.setManager(mi);
//        r.setDepartement(di);
//
//        System.out.println(iedao.update(r));
    }
    
    void update() {
        System.out.println("Masukkan ID! = ");
        String ei = scann.nextLine();

        System.out.println("Masukkan First Name! = ");
        String fn = scann.nextLine();

        System.out.println("Masukkan Last Name! = ");
        String ln = scann.nextLine();

        System.out.println("Masukkan Email! = ");
        String e = scann.nextLine();

        System.out.println("Masukkan Phone Number! = ");
        String pn = scann.nextLine();

        System.out.println("Masukkan Hire Date! = ");
        String hd = scann.nextLine();

        System.out.println("Masukkan Job ID! = ");
        Job ji = new Job();

        System.out.println("Masukkan Salary! = ");
        int s = scann.nextInt();

        System.out.println("Masukkan Commision Pct! = ");
        Float cp = scann.nextFloat();

        System.out.println("Masukkan Manager ID! = ");
        Employee mi = new Employee();

        System.out.println("Masukkan Departement ID! = ");
        Departement di = new Departement();
//        
//        Employee employee = new Employee(ei, fn, ln, e, pn, hd, ji, s, cp, mi, di);
//        System.out.println(edao.update(employee));
        
        r.setId(ei);
        r.setFirstName(fn);
        r.setLastName(ln);
        r.setEmail(e);
        r.setPhoneNumber(pn);
//        r.setHireDate(hd);
        r.setJob(ji);
        r.setSalary(s);
        r.setCommisionPct(cp);
        r.setManager(mi);
        r.setDepartement(di);

        System.out.println(iedao.update(r));
        
    }
    
    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        
        boolean del = edao.delete(id);
        System.out.println(del);
    }

    void search() {
        System.out.println("Masukkan Keyword! = ");
        String id = scann.nextLine();

        List<Employee> locations = iedao.search(id);
        for (Employee data : locations) {
 System.out.println(data.getId() + " " + data.getFirstName() + " " + data.getLastName() + " " + data.getEmail() + " " + data.getPhoneNumber() + " " + data.getHireDate() + " " + data.getJob() + " " + data.getSalary() + " " + data.getCommisionPct() + " " + data.getManager() + " " + data.getDepartement());       }
    }
    
    void getById() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        
        Employee data = edao.getById(id);
            System.out.println(data.getId() + " " + data.getFirstName() + " " + data.getLastName() + " " + data.getEmail() + " " + data.getPhoneNumber() + " " + data.getHireDate() + " " + data.getJob() + " " + data.getSalary() + " " + data.getCommisionPct() + " " + data.getManager() + " " + data.getDepartement());
    }
    
}
