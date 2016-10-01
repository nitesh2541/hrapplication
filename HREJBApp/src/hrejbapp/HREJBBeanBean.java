package hrejbapp;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "HREJBBean", mappedName = "HRApp-HREJBApp-HREJBBean")
public class HREJBBeanBean implements HREJBBean, HREJBBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "HREJBApp")
    private EntityManager em;

    public HREJBBeanBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public void removeRegions(Regions regions) {
        regions = em.find(Regions.class, regions.getRegion_id());
        em.remove(regions);
    }

    /** <code>select o from Regions o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Regions> getRegionsFindAll() {
        return em.createNamedQuery("Regions.findAll", Regions.class).getResultList();
    }

    public void removeLocations(Locations locations) {
        locations = em.find(Locations.class, locations.getLocation_id());
        em.remove(locations);
    }

    /** <code>select o from Locations o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Locations> getLocationsFindAll() {
        return em.createNamedQuery("Locations.findAll", Locations.class).getResultList();
    }

    public void removeCountries(Countries countries) {
        countries = em.find(Countries.class, countries.getCountry_id());
        em.remove(countries);
    }

    /** <code>select o from Countries o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Countries> getCountriesFindAll() {
        return em.createNamedQuery("Countries.findAll", Countries.class).getResultList();
    }

    public void removeDepartments(Departments departments) {
        departments = em.find(Departments.class, departments.getDepartment_id());
        em.remove(departments);
    }

    /** <code>select o from Departments o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Departments> getDepartmentsFindAll() {
        return em.createNamedQuery("Departments.findAll", Departments.class).getResultList();
    }

    public void removeEmployees(Employees employees) {
        employees = em.find(Employees.class, employees.getEmployee_id());
        em.remove(employees);
    }

    /** <code>select o from Employees o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Employees> getEmployeesFindAll() {
        return em.createNamedQuery("Employees.findAll", Employees.class).getResultList();
    }

    public void removeJobs(Jobs jobs) {
        jobs = em.find(Jobs.class, jobs.getJob_id());
        em.remove(jobs);
    }

    /** <code>select o from Jobs o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Jobs> getJobsFindAll() {
        return em.createNamedQuery("Jobs.findAll", Jobs.class).getResultList();
    }
    
    public Departments findDepartmentById(Integer departmentId){
        return (Departments) em.find(Departments.class,departmentId);
    }
}
