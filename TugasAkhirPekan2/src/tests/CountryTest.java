/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.CountryDAO;
import daos.idaos.ICountryDAO;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Yosef Febrianes
 */
public class CountryTest {
    
    HibernateUtil sessionFactory = new HibernateUtil();
    ICountryDAO icdao = new CountryDAO(sessionFactory.getSessionFactory());
    Scanner scann = new Scanner(System.in);
    Country c = new Country();
    SessionFactory factory = new HibernateUtil().getSessionFactory();
    CountryDAO cdao = new CountryDAO(factory);
    
    public static void main(String[] args) {
        
        CountryTest r = new CountryTest();
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
        List<Country> countries = icdao.getAll();
        for (Country data : countries) {
            System.out.println(data.getId() + " " + data.getName() + " " + data.getRegion().getId());
        }
    }
    
    void insert() {
        
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Name! = ");
        String name = scann.nextLine();
        System.out.println("Masukkan Region ID! = ");
        String regionId = scann.nextLine();
        
        Country country = new Country(id, name, new Region(regionId));
        System.out.println(cdao.insert(country));
    }
    
    void update() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Name! = ");
        String name = scann.nextLine();
        System.out.println("Masukkan Region ID! = ");
        String regionId = scann.nextLine();

        Country country = new Country(id, name, new Region(regionId));
        System.out.println(cdao.update(country));
    }

    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        
        boolean del = cdao.delete(id);
        System.out.println(del);
    }

    void search() {
        System.out.println("Masukkan Keyword! = ");
        String id = scann.nextLine();
        
        List<Country> countries = icdao.search(id);
        for (Country data : countries) {
            System.out.println(data.getId() +" - "+ data.getName() +" - "+ data.getRegion().getId());
        }
    }
    
    void getById() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        
        Country data = cdao.getById(id);
        System.out.println(data.getId() +" - "+ data.getName() +" - "+ data.getRegion().getId());
    }
    
}
