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
import org.hibernate.Session;
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
    public Region getById(String id) {
        return irdao.getById(id);
    }

    @Override
    public List<Region> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String name) {
        Region rr = new Region(id, name);
        if (irdao.insert(rr)) {
            return "Insert Success!";
        } else {
            return "Insert Success!";
        }
    }

    @Override
    public String update(String id, String name) {
            Region rr = new Region(id, name);
        if (irdao.update(rr)) {
            return "Update Success!";
        } else {
            return "Update Success!";
        }    
    }

    @Override
    public String delete(String id) {
        Region rr = new Region(id);
        if (irdao.delete(id)) {
            return "Delete "+id+" Success!";
        } else {
            return "Delete "+id+" Success!";
        }
    }

}
