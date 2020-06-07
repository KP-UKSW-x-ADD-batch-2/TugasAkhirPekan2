/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yosef Febrianes
 */
@Entity
@Table(name = "job_historys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobHistory.findAll", query = "SELECT j FROM JobHistory j")
    , @NamedQuery(name = "JobHistory.findByEmployee", query = "SELECT j FROM JobHistory j WHERE j.employee = :employee")
    , @NamedQuery(name = "JobHistory.findByStartDate", query = "SELECT j FROM JobHistory j WHERE j.startDate = :startDate")
    , @NamedQuery(name = "JobHistory.findByEndDate", query = "SELECT j FROM JobHistory j WHERE j.endDate = :endDate")})
public class JobHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employee")
    private String employee;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "job", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Job job;
    @JoinColumn(name = "employee", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee1;
    @JoinColumn(name = "departement", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departement departement;

    public JobHistory() {
    }

    public JobHistory(String employee) {
        this.employee = employee;
    }

    public JobHistory(String employee, Date startDate, Date endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employee != null ? employee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobHistory)) {
            return false;
        }
        JobHistory other = (JobHistory) object;
        if ((this.employee == null && other.employee != null) || (this.employee != null && !this.employee.equals(other.employee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.JobHistory[ employee=" + employee + " ]";
    }
    
}
