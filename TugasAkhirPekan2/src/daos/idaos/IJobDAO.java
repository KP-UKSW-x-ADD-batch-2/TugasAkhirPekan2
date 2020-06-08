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
 * @author user
 */
public interface IRegionDAO {

    public List<Job> getAll();

    public Region getById(String id);

    public List<Job> search(Object keyword);

    public boolean insert(Job job);

    public boolean update(Job job);

    public boolean delete(String id);
}