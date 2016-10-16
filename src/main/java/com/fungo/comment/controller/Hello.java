package com.fungo.comment.controller;

import com.fungo.comment.mapper.Test;
import com.fungo.comment.service.CommentService;
import com.fungo.comment.service.TestService;
import com.google.gson.Gson;
import com.google.inject.Inject;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by fornia on 16/10/10.
 */
@Path("hello")
public class Hello {

    @Inject
    private TestService testService;
    @Inject
    CommentService commentService;

    private static Logger logger = LoggerFactory.getLogger(Hello.class);
    @GET
    //@Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        List comments = commentService.getAll();
        List a = testService.getAll();
        logger.info("execute hello method");

        String s = new Gson().toJson(a,List.class);
        return s;
    }
}
