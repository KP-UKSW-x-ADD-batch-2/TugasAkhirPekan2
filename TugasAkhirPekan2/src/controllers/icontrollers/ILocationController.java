/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Country;
import models.Location;

/**
 *
 * @author Yosef Febrianes
 */
public interface ILocationController {

    public List<Location> getAll();

    public List<Location> search(Object keyword);

    public Location getById(String locationId);

    public String insert(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String country);

    public String update(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String country);

    public String delete(String locationId);
}
