package com.zzz.mvc.entities;

public class Comment {
    private String Comment_id;
    private String Post_id;
    private String Comment_by;
    private String Comment_time;
    private String Comment_content;

    public String getComment_id() {
        return Comment_id;
    }

    public void setComment_id(String comment_id) {
        Comment_id = comment_id;
    }

    public String getPost_id() {
        return Post_id;
    }

    public void setPost_id(String post_id) {
        Post_id = post_id;
    }

    public String getComment_by() {
        return Comment_by;
    }

    public void setComment_by(String comment_by) {
        Comment_by = comment_by;
    }

    public String getComment_time() {
        return Comment_time;
    }

    public void setComment_time(String comment_time) {
        Comment_time = comment_time;
    }

    public String getComment_content() {
        return Comment_content;
    }

    public void setComment_content(String comment_content) {
        Comment_content = comment_content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Comment_id='" + Comment_id + '\'' +
                ", Post_id='" + Post_id + '\'' +
                ", Comment_by='" + Comment_by + '\'' +
                ", Comment_time='" + Comment_time + '\'' +
                ", Comment_content='" + Comment_content + '\'' +
                '}';
    }
}
