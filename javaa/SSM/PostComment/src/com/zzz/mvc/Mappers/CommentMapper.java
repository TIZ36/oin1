package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.Comment;

import java.util.List;

public interface CommentMapper {
    void makeNewCommentToOnePostById(Comment comment);

    List<Comment> queryAllCommentUponOnePostById(String Post_id);
}
