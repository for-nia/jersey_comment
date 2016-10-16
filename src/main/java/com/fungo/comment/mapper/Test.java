package com.fungo.comment.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by fornia on 16/10/13.
 */
public interface Test {

    @Select("select * from comment")
    @Options(timeout = 2)
    List<Map> getAll();
}
