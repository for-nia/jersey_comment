package api;


import annotation.Compress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Request;
import java.io.IOException;
import java.util.Map;

/**
 * Created by fornia on 16/10/11.
 */
@Compress
public class AuthRequestFilter implements ContainerRequestFilter {

    private static Logger logger = LoggerFactory.getLogger(AuthRequestFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Request request = requestContext.getRequest();
        System.out.println(requestContext.getUriInfo().getPath());
        System.out.println("this is request's method : "+request.getMethod());
        Map headers = requestContext.getHeaders();
        System.out.println(requestContext.getHeaders().toString());
        System.out.println("==========");
        logger.info("filter worked");
    }
}
