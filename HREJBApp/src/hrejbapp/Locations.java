package hrejbapp;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "Locations.findAll", query = "select o from Locations o") })
@Table(name = "\"locations\"")
@XmlRootElement
public class Locations implements Serializable {
    private static final long serialVersionUID = 5387258751838042668L;
    @Column(name = "city", nullable = false)
    private String city;
    @Id
    @Column(name = "location_id", nullable = false)
    private int location_id;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "state_province")
    private String state_province;
    @Column(name = "street_address")
    private String street_address;
    @OneToMany(mappedBy = "locations", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Departments> departmentsList;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;

    public Locations() {
    }

    public Locations(String city, Countries countries, int location_id, String postal_code, String state_province,
                     String street_address) {
        this.city = city;
        this.countries = countries;
        this.location_id = location_id;
        this.postal_code = postal_code;
        this.state_province = state_province;
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public Departments addDepartments(Departments departments) {
        getDepartmentsList().add(departments);
        departments.setLocations(this);
        return departments;
    }

    public Departments removeDepartments(Departments departments) {
        getDepartmentsList().remove(departments);
        departments.setLocations(null);
        return departments;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }
}
