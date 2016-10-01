package hr.rservice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/hrapp")
public class RestInitializer extends Application {
    public RestInitializer() {
        super();
    }
}
