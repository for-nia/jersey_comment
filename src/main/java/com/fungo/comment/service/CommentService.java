package com.fungo.comment.service;

import com.fungo.comment.entity.Comment;
import com.fungo.comment.mapper.CommentMapper;
import com.google.inject.Inject;
import java.util.List;

/**
 * Created by fornia on 16/10/17.
 */
public class CommentService {
    @Inject
    private CommentMapper commentMapper;

    public List<Comment>  getAll(){
        List<Comment> comments = commentMapper.getAll();
        return comments;
    }
}
