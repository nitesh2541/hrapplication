package hrejbapp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Jobs.findAll", query = "select o from Jobs o") })
@Table(name = "\"jobs\"")
public class Jobs implements Serializable {
    private static final long serialVersionUID = 7188378337084148422L;
    @Id
    @Column(name = "job_id", nullable = false)
    private String job_id;
    @Column(name = "job_title", nullable = false)
    private String job_title;
    @Column(name = "max_salary")
    private int max_salary;
    @Column(name = "min_salary")
    private int min_salary;

    public Jobs() {
    }

    public Jobs(String job_id, String job_title, int max_salary, int min_salary) {
        this.job_id = job_id;
        this.job_title = job_title;
        this.max_salary = max_salary;
        this.min_salary = min_salary;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }
}
