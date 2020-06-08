/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.ICountryController;
import daos.CountryDAO;
import daos.idaos.ICountryDAO;
import java.util.List;
import models.Country;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author User
 */
public class CountryController implements ICountryController {

    private ICountryDAO icdao;

    public CountryController(SessionFactory factory) {
        icdao = new CountryDAO(factory);
    }

    @Override
    public List<Country> getAll() {
        return icdao.getAll();
    }

    @Override
    public List<Country> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Country getById(String countryId) {
        return icdao.getById(countryId);
    }

    @Override
    public String insert(String countryId, String countryName, Region regionId) {
        Country reg = new Country(countryId, countryName, regionId);
        if (icdao.insert(reg)) {
            return "Insert " + countryId + " success!";
        } else {
            return "Insert " + countryId + " failed!";
        }
    }

    @Override
    public String update(String countryId, String countryName, Region regionId) {
        Country reg = new Country(countryId, countryName, regionId);
        if (icdao.update(reg)) {
            return "Update " + countryId + " success!";
        } else {
            return "Update " + countryId + " failed!";
        }
    }

    @Override
    public String delete(String countryId) {
        Country reg = new Country(countryId);
        if (icdao.delete(countryId)) {
            return "Delete " + countryId + " success!";
        } else {
            return "Delete " + countryId + " failed!";
        }
    }

}
