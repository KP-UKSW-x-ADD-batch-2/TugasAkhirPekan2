/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;
import java.util.List;
import models.Country;
import models.Region;

/**
 *
 * @author User
 */
public interface ICountryController {

    public List<Country> getAll();

    public List<Country> search(Object keyword);

    public Country getById(String countryId);

    public String insert(String countryId, String countryName, Region regionId);

    public String update(String countryId, String countryName, Region regionId);

    public String delete(String countryId);

}
