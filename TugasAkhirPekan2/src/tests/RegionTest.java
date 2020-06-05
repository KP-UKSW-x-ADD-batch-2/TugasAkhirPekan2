/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.RegionDAO;
import daos.idaos.IRegionDAO;
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
public class RegionTest {

    SessionFactory factory = new HibernateUtil().getSessionFactory();
    RegionDAO rdao = new RegionDAO(factory);
    IRegionDAO irdao = new RegionDAO(factory);

    Scanner scann = new Scanner(System.in);
    Region r = new Region();
    

    public static void main(String[] args) {

        RegionTest r = new RegionTest();
        Scanner scann = new Scanner(System.in);
        int lanjut = 0;
        do {
            System.out.println("1 = GetAll");
            System.out.println("2 = Insert");
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
        HibernateUtil sessionFactory = new HibernateUtil();
        IRegionDAO irdao = new RegionDAO(sessionFactory.getSessionFactory());
//        ICountryDAO icdao = new CountryDAO(sessionFactory.getSessionFactory());
        List<Region> regions = irdao.getAll();
        for (Region data : regions) {
            System.out.println(data.getId()+" "+data.getName()+" "+data.getCountryList().size());
//            for (Country country : data.getCountryList()) {
//                System.out.println("-" + country.getCountryName());
            }
        }
    
    void insert() {

        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();

        System.out.println("Masukkan Nama! = ");
        String name = scann.nextLine();

        Region region = new Region(id, name);
        System.out.println(rdao.insert(region));
    }

    void update() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Nama! = ");
        String name = scann.nextLine();
        
        Region region = new Region(id, name);
        System.out.println(rdao.update(region));
    }

    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        
        boolean del = rdao.delete(id);
        System.out.println(del);
    }

    void search() {
        System.out.println("Masukkan Keyword! = ");
        String keyword = scann.nextLine();

        List<Region> key = rdao.search(keyword);
        for (Region req : key) {
            System.out.println(req.getId()+" - "+req.getName());
        }
    }

    void getById() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();

        Region reg = rdao.getById(id);
        System.out.println(reg.getId() + " - " + reg.getName());

    }

}
