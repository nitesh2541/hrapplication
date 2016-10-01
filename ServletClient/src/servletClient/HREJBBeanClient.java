package servletClient;

import hrejbapp.Countries;
import hrejbapp.Departments;
import hrejbapp.Employees;
import hrejbapp.HREJBBean;

import hrejbapp.Jobs;
import hrejbapp.Locations;
import hrejbapp.Regions;

import java.util.Hashtable;
import java.util.List;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HREJBBeanClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            HREJBBean hREJBBean = (HREJBBean) context.lookup("HRApp-HREJBApp-HREJBBean#hrejbapp.HREJBBean");
            for (Regions regions : (List<Regions>) hREJBBean.getRegionsFindAll()) {
                printRegions(regions);
            }
            for (Locations locations : (List<Locations>) hREJBBean.getLocationsFindAll()) {
                printLocations(locations);
            }
            for (Countries countries : (List<Countries>) hREJBBean.getCountriesFindAll()) {
                printCountries(countries);
            }
            for (Departments departments : (List<Departments>) hREJBBean.getDepartmentsFindAll()) {
                printDepartments(departments);
            }
            for (Employees employees : (List<Employees>) hREJBBean.getEmployeesFindAll()) {
                printEmployees(employees);
            }
            for (Jobs jobs : (List<Jobs>) hREJBBean.getJobsFindAll()) {
                printJobs(jobs);
            }
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printRegions(Regions regions) {
        System.out.println("region_id = " + regions.getRegion_id());
        System.out.println("region_name = " + regions.getRegion_name());
        System.out.println("countriesList = " + regions.getCountriesList());
    }

    private static void printLocations(Locations locations) {
        System.out.println("city = " + locations.getCity());
        System.out.println("location_id = " + locations.getLocation_id());
        System.out.println("postal_code = " + locations.getPostal_code());
        System.out.println("state_province = " + locations.getState_province());
        System.out.println("street_address = " + locations.getStreet_address());
        System.out.println("departmentsList = " + locations.getDepartmentsList());
        System.out.println("countries = " + locations.getCountries());
    }

    private static void printCountries(Countries countries) {
        System.out.println("country_id = " + countries.getCountry_id());
        System.out.println("country_name = " + countries.getCountry_name());
        System.out.println("locationsList = " + countries.getLocationsList());
        System.out.println("regions = " + countries.getRegions());
    }

    private static void printDepartments(Departments departments) {
        System.out.println("department_id = " + departments.getDepartment_id());
        System.out.println("department_name = " + departments.getDepartment_name());
        System.out.println("manager_id = " + departments.getManager_id());
        System.out.println("locations = " + departments.getLocations());
    }

    private static void printEmployees(Employees employees) {
        System.out.println("commission_pct = " + employees.getCommission_pct());
        System.out.println("createdBy = " + employees.getCreatedBy());
        System.out.println("createdDate = " + employees.getCreatedDate());
        System.out.println("department_id = " + employees.getDepartment_id());
        System.out.println("email = " + employees.getEmail());
        System.out.println("employee_id = " + employees.getEmployee_id());
        System.out.println("first_name = " + employees.getFirst_name());
        System.out.println("hire_date = " + employees.getHire_date());
        System.out.println("job_id = " + employees.getJob_id());
        System.out.println("last_name = " + employees.getLast_name());
        System.out.println("manager_id = " + employees.getManager_id());
        System.out.println("phone_INT = " + employees.getPhone_INT());
        System.out.println("salary = " + employees.getSalary());
        System.out.println("updatedBy = " + employees.getUpdatedBy());
        System.out.println("updatedDate = " + employees.getUpdatedDate());
    }

    private static void printJobs(Jobs jobs) {
        System.out.println("job_id = " + jobs.getJob_id());
        System.out.println("job_title = " + jobs.getJob_title());
        System.out.println("max_salary = " + jobs.getMax_salary());
        System.out.println("min_salary = " + jobs.getMin_salary());
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:9101");
        return new InitialContext(env);
    }
}
