package hrejbapp;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "Employees.findAll", query = "select o from Employees o") })
@Table(name = "\"employees\"")
@XmlRootElement
public class Employees implements Serializable {
    private static final long serialVersionUID = -3768110492768131225L;
    @Column(name = "commission_pct")
    private Integer commission_pct;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    @Column(name = "department_id")
    private int department_id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Id
    @Column(name = "employee_id", nullable = false)
    private int employee_id;
    @Column(name = "first_name")
    private String first_name;
    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date", nullable = false)
    private Date hire_date;
    @Column(name = "job_id", nullable = false)
    private String job_id;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "manager_id")
    private int manager_id;
    @Column(name = "phone_INT")
    private String phone_INT;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "UPDATED_DATE")
    private Timestamp updatedDate;

    public Employees() {
    }

    public Employees(Integer commission_pct, String createdBy, Timestamp createdDate, int department_id, String email,
                     int employee_id, String first_name, Date hire_date, String job_id, String last_name,
                     int manager_id, String phone_INT, Integer salary, String updatedBy, Timestamp updatedDate) {
        this.commission_pct = commission_pct;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.department_id = department_id;
        this.email = email;
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.last_name = last_name;
        this.manager_id = manager_id;
        this.phone_INT = phone_INT;
        this.salary = salary;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public Integer getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(Integer commission_pct) {
        this.commission_pct = commission_pct;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getPhone_INT() {
        return phone_INT;
    }

    public void setPhone_INT(String phone_INT) {
        this.phone_INT = phone_INT;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
