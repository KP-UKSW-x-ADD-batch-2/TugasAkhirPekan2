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

    public Region getById(String id);

    public List<Region> search(Object keyword);

    public String insert(String id, String name);

    public String update(String id, String name);

    public String delete(String id);
}
