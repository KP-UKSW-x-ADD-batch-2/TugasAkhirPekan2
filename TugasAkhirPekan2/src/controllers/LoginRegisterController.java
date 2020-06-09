/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.ILoginRegisterController;
import daos.LoginRegisterDAO;
import daos.idaos.ILoginRegisterDAO;
import models.Account;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author Yosef Febrianes
 */
public class LoginRegisterController implements ILoginRegisterController {

    private ILoginRegisterDAO ilrdao;

    public LoginRegisterController(SessionFactory factory) {
        ilrdao = new LoginRegisterDAO(factory);
    }

    @Override
    public String register(String id, String username, String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        Account acc = new Account(id, username, hashed);
        if (ilrdao.insert(acc)) {
            return "Register " + username + " success!";
        } else {
            return "Register " + username + " failed!";
        }
    }

    @Override
    public boolean login(String username, String password) {
        Account acc = ilrdao.getByUsername(username);
        
        if (acc != null && BCrypt.checkpw(password, acc.getPassword())) {
//        if (BCrypt.checkpw(password, acc.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
