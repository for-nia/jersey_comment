package com.fungo.comment.mapper;

import com.fungo.comment.entity.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Created by fornia on 16/10/16.
 */
public interface CommentMapper {
    String fields = "id, content, approve_count, parent_id, origin_id, user_id, user_logo, user_nickname, machine_code, create_time, state";
    @Select({"select ",fields," from a8_comment"})
    List<Comment> getAll();
}
