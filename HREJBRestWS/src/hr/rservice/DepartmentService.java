package hr.rservice;

import hrejbapp.Departments;
import hrejbapp.HREJBBeanLocal;

import java.util.List;

import javax.ejb.EJB;

import javax.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Singleton
@Path("tut/department")
public class DepartmentService {
    public DepartmentService() {
        super();
    }
    @EJB
    HREJBBeanLocal SessionBean;
    
    @GET
    @Produces("application/xml")
    @Path("/dept")
    public List<Departments> getAllDepartment(){
    
      List<Departments>  emplist = SessionBean.getDepartmentsFindAll();

        return emplist;
        }
}
