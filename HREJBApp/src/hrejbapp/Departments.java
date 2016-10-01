package hrejbapp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "Departments.findAll", query = "select o from Departments o") })
@Table(name = "\"departments\"")
@XmlRootElement
public class Departments implements Serializable {
    private static final long serialVersionUID = -8088331141921530022L;
    @Id
    @Column(name = "department_id", nullable = false)
    private int department_id;
    @Column(name = "department_name", nullable = false)
    private String department_name;
    @Column(name = "manager_id")
    private int manager_id;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;

    public Departments() {
    }

    public Departments(int department_id, String department_name, Locations locations, int manager_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.locations = locations;
        this.manager_id = manager_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }


    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }
}
