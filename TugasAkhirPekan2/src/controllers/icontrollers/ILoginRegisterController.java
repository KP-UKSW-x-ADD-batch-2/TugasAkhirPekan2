/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

/**
 *
 * @author Yosef Febrianes
 */
public interface ILoginRegisterController {

    public String register(String id, String username, String password);

    public boolean login(String username, String password);
}
