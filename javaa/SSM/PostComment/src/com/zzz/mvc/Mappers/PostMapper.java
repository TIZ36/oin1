package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.Post;

import java.util.List;

public interface PostMapper {
    void addANewPost(Post post);
    List<Post> showAllPosts();

}
