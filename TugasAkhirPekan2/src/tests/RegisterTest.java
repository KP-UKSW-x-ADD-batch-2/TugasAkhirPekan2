/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import daos.AccountDAO;
import java.util.Scanner;
import models.Account;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import daos.idaos.IAccountDAO;

/**
 *
 * @author Yosef Febrianes
 */
public class RegisterTest {

    HibernateUtil sessionFactory = new HibernateUtil();
    IAccountDAO irdao = new AccountDAO(sessionFactory.getSessionFactory());
    Account a = new Account();
    SessionFactory factory = new HibernateUtil().getSessionFactory();
    AccountDAO adao = new AccountDAO(factory);

    public static void main(String[] args) {
        RegisterTest r = new RegisterTest();
        Scanner scann = new Scanner(System.in);
        int lanjut = 0;
        do {
            System.out.println("1 = Add");
            System.out.println("2 = Add");
            System.out.print("pilih mana? = ");
            int a = scann.nextInt();

            switch (a) {
                case 1:
                    r.insert();
                    break;
                case 2:
                    r.insert();
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

        Account account = new Account(id, un, pl);
        System.out.println(adao.insert(account));
    }
}
