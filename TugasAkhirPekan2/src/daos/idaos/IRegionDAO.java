/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author Yosef Febrianes
 */
public interface IRegionDAO {

    public List<Region> getAll();

    public Region getById(String id);

    public List<Region> search(Object keyword);

    public boolean insert(Region region);

    public boolean update(Region region);

    public boolean delete(String id);
}
