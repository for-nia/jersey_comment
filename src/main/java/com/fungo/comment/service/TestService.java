package com.fungo.comment.service;

import com.fungo.comment.mapper.Test;
import com.google.inject.Inject;

import java.util.List;
import java.util.Map;

/**
 * Created by fornia on 16/10/14.
 */
public class TestService {
    @Inject
    Test test;
    public List<Map> getAll(){
        return test.getAll();
    }
}
