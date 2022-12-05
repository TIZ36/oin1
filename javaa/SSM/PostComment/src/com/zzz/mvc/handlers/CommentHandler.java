package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.CommentMapper;
import com.zzz.mvc.entities.Comment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.UUID;

@Controller
@RequestMapping(value = "/Comment")
public class CommentHandler {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml"
    );

    private CommentMapper commentMapper = applicationContext.getBean(CommentMapper.class);

    @RequestMapping(value = "/makeNewComment", method = RequestMethod.POST)
    public String putNewComment(Comment comment) {
        comment.setComment_id(UUID.randomUUID().toString());
        comment.setComment_time((new Timestamp(System.currentTimeMillis())).toString());
        commentMapper.makeNewCommentToOnePostById(comment);
        return "redirect:/PostText/showAllTopics";
    }
}
