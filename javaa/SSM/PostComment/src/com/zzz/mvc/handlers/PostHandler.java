package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.CommentMapper;
import com.zzz.mvc.Mappers.PostMapper;
import com.zzz.mvc.entities.Comment;
import com.zzz.mvc.entities.Post;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping(value = "/PostText")
public class PostHandler {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml"
    );

    private PostMapper postMapper = applicationContext.getBean(PostMapper.class);
    private CommentMapper commentMapper = applicationContext.getBean(CommentMapper.class);

    @RequestMapping(value = "/initNewTopic")
    public String init(Post post,
                       Map<String, Object> map) {
//        generate timestamp for post_id
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        post.setPost_id(UUID.randomUUID().toString());
        post.setPost_time(timestamp.toString());
//        System.out.println("######################=====>#####################");
        System.out.println(post);
        postMapper.addANewPost(post);


        return "redirect:/PostText/showAllTopics";
    }

    @RequestMapping(value = "/showAllTopics")
    public String showAllPosts(Map<String, Object> map) {
        List<Post> allPosts = postMapper.showAllPosts();
        List<Map<Post, List>> PostAndComment = new ArrayList<>();
//        这里要写每个主题的所有评论们
        for (Post p : allPosts) {
            List<Comment> temp = commentMapper.queryAllCommentUponOnePostById(p.getPost_id());
            Map<Post, List> eachPair = new HashMap<>();
            eachPair.put(p, new ArrayList<>(temp));
            PostAndComment.add(eachPair);
        }

        map.put("PostAndComment", PostAndComment);

        return "/topics";
    }
}
