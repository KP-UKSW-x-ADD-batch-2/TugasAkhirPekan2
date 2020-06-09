/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.LoginRegisterDAO;
import java.util.Scanner;
import models.Account;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import daos.idaos.ILoginRegisterDAO;

/**
 *
 * @author Yosef Febrianes
 */
public class LoginRegisterTest {

    HibernateUtil sessionFactory = new HibernateUtil();
    ILoginRegisterDAO irdao = new LoginRegisterDAO(sessionFactory.getSessionFactory());
    Account a = new Account();
    SessionFactory factory = new HibernateUtil().getSessionFactory();
    LoginRegisterDAO lrdao = new LoginRegisterDAO(factory);

    public static void main(String[] args) {
        LoginRegisterTest r = new LoginRegisterTest();
        Scanner scann = new Scanner(System.in);
        int lanjut = 0;
        do {
            System.out.println("1 = Register");
            System.out.println("2 = Get By Username");
            System.out.print("pilih mana? = ");
            int a = scann.nextInt();

            switch (a) {
                case 1:
                    r.insert();
                    break;
                case 2:
                    r.getByUsername();
                    break;

            }
            System.out.println("lagi? ");
            lanjut = scann.nextInt();
        } while (lanjut == 1);
    }

    void insert() {

        Scanner scann = new Scanner(System.in);

        System.out.println("Masukkan ID anda! = ");
        String id = scann.nextLine();
        System.out.println("Masukkan username! = ");
        String un = scann.nextLine();
        System.out.println("Masukkan password! = ");
        String p = scann.nextLine();
        System.out.println("Masukkan password lagi! = ");
        String pl = scann.nextLine();

        Account account = new Account(id, un, p);
        System.out.println(lrdao.insert(account));
    }

    void getByUsername() {
        Scanner scann = new Scanner(System.in);

        System.out.println("Masukkan username! = ");
        String un = scann.nextLine();
//        System.out.println("Masukkan password! = ");
//        String p = scann.nextLine();
        
        Account acc = lrdao.getByUsername(un);
        System.out.println(acc.getId() +" - "+ acc.getUsername() +" - "+ acc.getPassword());
    }
}
