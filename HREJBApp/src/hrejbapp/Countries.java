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

@Entity
@NamedQueries({ @NamedQuery(name = "Countries.findAll", query = "select o from Countries o") })
@Table(name = "\"countries\"")
public class Countries implements Serializable {
    private static final long serialVersionUID = -1694643825906994135L;
    @Id
    @Column(name = "country_id", nullable = false)
    private String country_id;
    @Column(name = "country_name")
    private String country_name;
    @OneToMany(mappedBy = "countries", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Locations> locationsList;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regions;

    public Countries() {
    }

    public Countries(String country_id, String country_name, Regions regions) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.regions = regions;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }


    public List<Locations> getLocationsList() {
        return locationsList;
    }

    public void setLocationsList(List<Locations> locationsList) {
        this.locationsList = locationsList;
    }

    public Locations addLocations(Locations locations) {
        getLocationsList().add(locations);
        locations.setCountries(this);
        return locations;
    }

    public Locations removeLocations(Locations locations) {
        getLocationsList().remove(locations);
        locations.setCountries(null);
        return locations;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }
}
