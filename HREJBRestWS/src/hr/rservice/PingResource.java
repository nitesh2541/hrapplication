package hr.rservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ping")
public class PingResource {
    public PingResource() {
        super();
    }
    @GET
    @Produces(value="application/json")
    public String ping(){
        return "{'ping ':'Nitesh'}";
        }
}
