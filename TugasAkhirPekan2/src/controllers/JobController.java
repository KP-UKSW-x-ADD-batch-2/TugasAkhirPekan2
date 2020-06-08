/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.IJobController;
import daos.JobDAO;
import daos.idaos.IJobDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author User
 */
public class JobController implements IJobController {

    private IJobDAO ijdao;

    public JobController(SessionFactory factory) {
        ijdao = new JobDAO(factory);
    }

    @Override
    public List<Job> getAll() {
        return ijdao.getAll();
    }

    @Override
    public List<Job> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

    @Override
    public Job getById(String jobId) {
        return ijdao.getById(jobId);
    }

    @Override
    public String insert(String jobId, String jobTitle, int minSalary, int maxSalary) {
        Job reg = new Job(jobId, jobTitle, minSalary, maxSalary);
        if (ijdao.insert(reg)) {
            return "Insert " + jobId + " success!";
        } else {
            return "Insert " + jobId + " failed!";
        }
    }

    @Override
    public String delete(String jobId) {
        if (ijdao.delete(jobId)) {
            return "Delete " + jobId + " success!";
        } else {
            return "Delete " + jobId + " failed";
        }
    }

    @Override
    public String update(String jobId, String jobTitle, int minSalary, int maxSalary) {
        Job reg = new Job(jobId, jobTitle, minSalary, maxSalary);
        if (ijdao.update(reg)) {
            return "Update " + jobId + " success!";
        } else {
            return "Update " + jobId + " failed!";
        }
    }

}
