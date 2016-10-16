package com.fungo.comment.controller;

import com.fungo.comment.entity.Comment;
import com.fungo.comment.jetty.CommentServer;
import com.fungo.comment.service.CommentService;
import com.google.gson.Gson;
import com.google.inject.Inject;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by fornia on 16/10/17.
 */
@Path("comment")
public class CommentController {

    @Inject
    CommentService commentService;

    @GET
    //@Path("/comments")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll(){
        List<Comment> comments = commentService.getAll();
        return new Gson().toJson(comments,List.class);
    }
}
