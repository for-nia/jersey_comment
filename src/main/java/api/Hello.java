package api;

import annotation.Compress;
import org.glassfish.jersey.server.ContainerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by fornia on 16/10/10.
 */
@Path("/")
public class Hello {

    private static Logger logger = LoggerFactory.getLogger(Hello.class);
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Compress
    public String  hello(ContainerRequest request){
        System.out.println(request.getRequestUri());
        logger.info("execute hello method");
        return "hello world";
    }
}
