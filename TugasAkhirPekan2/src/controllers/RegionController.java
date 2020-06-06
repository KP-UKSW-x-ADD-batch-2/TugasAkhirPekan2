/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.IRegionController;
import daos.RegionDAO;
import daos.idaos.IRegionDAO;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Yosef Febrianes
 */
public class RegionController implements IRegionController {

    private IRegionDAO irdao;

    public RegionController(SessionFactory factory) {
        irdao = new RegionDAO(factory);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<Region> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Region getById(String regionId) {
        return irdao.getById(regionId);
    }

    @Override
    public String insert(String regionId, String regionName) {
        Region reg = new Region(regionId, regionName);
        if (irdao.insert(reg)) {
            return "Insert "+regionId+" success!";
        } else {
            return "Insert "+regionId+" failed!";
        }
    }

    @Override
    public String update(String regionId, String regionName) {
        Region reg = new Region(regionId, regionName);
        if (irdao.update(reg)) {
            return "Update "+regionId+" success!";
        } else {
            return "Update "+regionId+" failed";
        }
    }

    @Override
    public String delete(String regionId) {
        if (irdao.delete(regionId)) {
            return "Delete "+regionId+" success!";
        } else {
            return "Delete "+regionId+" failed";
        }
    }

}
