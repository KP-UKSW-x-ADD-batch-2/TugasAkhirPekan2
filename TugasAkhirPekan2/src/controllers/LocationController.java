/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.ILocationController;
import daos.LocationDAO;
import daos.LocationDAO;
import daos.idaos.ILocationDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author Yosef Febrianes
 */
public class LocationController implements ILocationController {

    private ILocationDAO ildao;

    public LocationController(SessionFactory factory) {
        ildao = new LocationDAO(factory);
    }

    @Override
    public List<Location> getAll() {
        return ildao.getAll();
    }

    @Override
    public List<Location> search(Object keyword) {
        return ildao.search(keyword);
    }

    @Override
    public Location getById(String locationId) {
        return ildao.getById(locationId);
    }

    @Override
    public String insert(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String country) {

        Location reg = new Location(locationId, streetAddress, postalCode, city, stateProvince, new Country(country));
        if (ildao.insert(reg)) {
            return "Insert " + locationId + " success!";
        } else {
            return "Insert " + locationId + " failed!";
        }
    }

    @Override
    public String update(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String country) {

        Location reg = new Location(locationId, streetAddress, postalCode, city, stateProvince, new Country(country));
        if (ildao.update(reg)) {
            return "Update " + locationId + " success!";
        } else {
            return "Update " + locationId + " failed";
        }
    }

    @Override
    public String delete(String locationId) {
        if (ildao.delete(locationId)) {
            return "Delete " + locationId + " success!";
        } else {
            return "Delete " + locationId + " failed";
        }
    }

}
