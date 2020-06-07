/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.LocationDAO;
import daos.idaos.ILocationDAO;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Yosef Febrianes
 */
public class LocationTest {

    HibernateUtil sessionFactory = new HibernateUtil();
    ILocationDAO ildao = new LocationDAO(sessionFactory.getSessionFactory());
    Scanner scann = new Scanner(System.in);
    Location l = new Location();
    SessionFactory factory = new HibernateUtil().getSessionFactory();
    LocationDAO ldao = new LocationDAO(factory);

    public static void main(String[] args) {

        LocationTest l = new LocationTest();
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
                    l.getAll();
                    break;
                case 2:
                    l.insert();
                    break;
                case 3:
                    l.update();
                    break;
                case 4:
                    l.delete();
                    break;
                case 5:
                    l.search();
                    break;
                case 6:
                    l.getById();
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
        List<Location> locations = ildao.getAll();
        for (Location data : locations) {
            System.out.println(data.getId() + " " + data.getStreetAddress() + "-" + data.getPostalCode() + "-" + data.getCity() + "-" + data.getStateProvince() + "-" + data.getCountry().getId());
        }
    }

    void insert() {

        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Street Address! = ");
        String sa = scann.nextLine();
        System.out.println("Masukkan Postal Code! = ");
        String pc = scann.nextLine();
        System.out.println("Masukkan City! = ");
        String c = scann.nextLine();
        System.out.println("Masukkan State Province! = ");
        String sp = scann.nextLine();
        System.out.println("Masukkan Country ID! = ");
        String ci = scann.nextLine();

        Location location = new Location(id, sa, pc, c, sp, new Country(ci));
        System.out.println(ldao.insert(location));
    }

    void update() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan Street Address! = ");
        String sa = scann.nextLine();
        System.out.println("Masukkan Postal Code! = ");
        String pc = scann.nextLine();
        System.out.println("Masukkan City! = ");
        String c = scann.nextLine();
        System.out.println("Masukkan State Province! = ");
        String sp = scann.nextLine();
        System.out.println("Masukkan Country ID! = ");
        String ci = scann.nextLine();

        Location location = new Location(id, sa, pc, c, sp, new Country(ci));
        System.out.println(ldao.update(location));
    }

    void delete() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();

        boolean del = ldao.delete(id);
        System.out.println(del);
    }

    void search() {
        System.out.println("Masukkan Keyword! = ");
        String id = scann.nextLine();

        List<Location> locations = ildao.search(id);
        for (Location data : locations) {
            System.out.println(data.getId() + " " + data.getStreetAddress() + "-" + data.getPostalCode() + "-" + data.getCity() + "-" + data.getStateProvince() + "-" + data.getCountry().getId());
        }
    }

    void getById() {
        System.out.println("Masukkan ID! = ");
        String id = scann.nextLine();

        Location data = ldao.getById(id);
        System.out.println(data.getId() + " " + data.getStreetAddress() + "-" + data.getPostalCode() + "-" + data.getCity() + "-" + data.getStateProvince() + "-" + data.getCountry().getId());
    }

}
