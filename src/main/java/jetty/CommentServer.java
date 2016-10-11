package jetty;

import api.AuthRequestFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Map;

/**
 * Created by fornia on 16/10/10.
 */
public class CommentServer {
    public static void main(String[] args){

        Server server = new Server(8021);

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(AuthRequestFilter.class);
        resourceConfig.packages(AuthRequestFilter.class.getPackage().getName());
        ServletContainer servletContainer = new ServletContainer(resourceConfig);
        ServletHolder servlet = new ServletHolder(servletContainer);
        //servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        //servlet.setInitParameter("com.sun.jersey.config.property.packages", "api");
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.addServlet(servlet, "/*");
        server.setHandler(handler);
        try {
            server.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("start...in 8021");
    }
}
