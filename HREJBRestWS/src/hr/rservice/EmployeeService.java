package hr.rservice;

import hrejbapp.Employees;
import hrejbapp.HREJBBeanLocal;
import hrejbapp.Locations;

import java.util.List;

import javax.ejb.EJB;

import javax.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Singleton
@Path("tut/employee")

public class EmployeeService {

    //Lookup EJB session bean
    @EJB
    HREJBBeanLocal SessionBean;

    public EmployeeService() {
        super();
    }

    @GET
    @Produces("application/xml,application/json")
    @Path("/emp")
    public List<Employees> getAllEmployees(){
      //      EmployeeList listOfEmployees = new EmployeeList();
      List<Employees>  emplist =  SessionBean.getEmployeesFindAll();
      
        return emplist;
        }

 
  
    
    @GET
    @Produces("application/xml,application/json")
    @Path("/loc")
    public List<Locations> getAllLocations(){
    
      List<Locations>  emplist = SessionBean.getLocationsFindAll();

        return emplist;
        }
}
