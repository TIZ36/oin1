package com.zzz.mvc.entities;

public class Post {
    private String Post_id;
    private String Post_content;
    private String Post_by;
    private String Post_time;

    public String getPost_id() {
        return Post_id;
    }

    public void setPost_id(String post_id) {
        Post_id = post_id;
    }

    public String getPost_content() {
        return Post_content;
    }

    public void setPost_content(String post_content) {
        Post_content = post_content;
    }

    public String getPost_by() {
        return Post_by;
    }

    public void setPost_by(String post_by) {
        Post_by = post_by;
    }

    public String getPost_time() {
        return Post_time;
    }

    public void setPost_time(String post_time) {
        Post_time = post_time;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Post_id='" + Post_id + '\'' +
                ", Post_content='" + Post_content + '\'' +
                ", Post_by='" + Post_by + '\'' +
                ", Post_time='" + Post_time + '\'' +
                '}';
    }
}
