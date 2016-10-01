package hrejbapp;

import java.util.List;

import javax.ejb.Local;

@Local
public interface HREJBBeanLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    void removeRegions(Regions regions);

    List<Regions> getRegionsFindAll();

    void removeLocations(Locations locations);

    List<Locations> getLocationsFindAll();

    void removeCountries(Countries countries);

    List<Countries> getCountriesFindAll();

    void removeDepartments(Departments departments);

    List<Departments> getDepartmentsFindAll();

    void removeEmployees(Employees employees);

    List<Employees> getEmployeesFindAll();

    void removeJobs(Jobs jobs);

    List<Jobs> getJobsFindAll();
    public Departments findDepartmentById(Integer employeeId);
}
