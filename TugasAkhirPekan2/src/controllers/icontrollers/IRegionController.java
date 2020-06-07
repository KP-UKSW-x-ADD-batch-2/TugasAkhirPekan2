/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author Yosef Febrianes
 */
public interface IRegionController {

    public List<Region> getAll();

    public List<Region> search(Object keyword);

    public Region getById(String regionId);

    public String insert(String regionId, String regionName);

    public String update(String regionId, String regionName);

    public String delete(String regionId);

}
