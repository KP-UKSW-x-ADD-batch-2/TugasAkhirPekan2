/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import models.Account;

/**
 *
 * @author Yosef Febrianes
 */
public interface ILoginRegisterDAO {

    public boolean insert(Account account);
    
    public Account getByUsername (String username);
}
