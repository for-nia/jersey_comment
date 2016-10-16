package com.fungo.comment.guice;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by fornia on 16/10/11.
 */
public class AuthRequestFilter implements ContainerRequestFilter {

    private static Logger logger = LoggerFactory.getLogger(AuthRequestFilter.class);

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        System.out.println("I am filter");
        logger.info("I am filter");
        return null;
    }
}
