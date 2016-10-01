package hrejbapp;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Regions.findAll", query = "select o from Regions o") })
@Table(name = "\"regions\"")
public class Regions implements Serializable {
    private static final long serialVersionUID = 8947351990625240306L;
    @Id
    @Column(name = "region_id", nullable = false)
    private int region_id;
    @Column(name = "region_name")
    private String region_name;
    @OneToMany(mappedBy = "regions", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Countries> countriesList;

    public Regions() {
    }

    public Regions(int region_id, String region_name) {
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public List<Countries> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Countries> countriesList) {
        this.countriesList = countriesList;
    }

    public Countries addCountries(Countries countries) {
        getCountriesList().add(countries);
        countries.setRegions(this);
        return countries;
    }

    public Countries removeCountries(Countries countries) {
        getCountriesList().remove(countries);
        countries.setRegions(null);
        return countries;
    }
}
