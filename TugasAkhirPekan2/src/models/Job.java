/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yosef Febrianes
 */
@Entity
@Table(name = "jobs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
    , @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id")
    , @NamedQuery(name = "Job.findByTitle", query = "SELECT j FROM Job j WHERE j.title = :title")
    , @NamedQuery(name = "Job.findByMinSalary", query = "SELECT j FROM Job j WHERE j.minSalary = :minSalary")
    , @NamedQuery(name = "Job.findByMaxSalary", query = "SELECT j FROM Job j WHERE j.maxSalary = :maxSalary")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "min_salary")
    private int minSalary;
    @Basic(optional = false)
    @Column(name = "max_salary")
    private int maxSalary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    private List<JobHistory> jobHistoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Job() {
    }

    public Job(String id) {
        this.id = id;
    }

    public Job(String id, String title, int minSalary, int maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @XmlTransient
    public List<JobHistory> getJobHistoryList() {
        return jobHistoryList;
    }

    public void setJobHistoryList(List<JobHistory> jobHistoryList) {
        this.jobHistoryList = jobHistoryList;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Job[ id=" + id + " ]";
    }
    
}
