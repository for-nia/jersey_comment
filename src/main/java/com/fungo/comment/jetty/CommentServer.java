package com.fungo.comment.jetty;


import com.fungo.comment.guice.MyBatisConfig;
import com.fungo.comment.guice.MyGuiceFilter;
import com.fungo.comment.guice.MyServletModule;
import com.google.inject.Module;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


/**
 * Created by fornia on 16/10/10.
 */
public class CommentServer {
    public static void main(String[] args){

        Manager.init();
        Server server = getServer(8021);
        try {
            server.start();
            server.join();
            System.out.println("start...in 8021");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static Server getServer(int port){
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addFilter(MyGuiceFilter.class, "/*", EnumSet.<javax.servlet.DispatcherType>of(javax.servlet.DispatcherType.REQUEST, javax.servlet.DispatcherType.ASYNC));
        context.setContextPath("/");
        context.addServlet(DefaultServlet.class, "/*");


        return server;
    }
}
