package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.entities.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/Friend")
public class FriendHandler {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml");

    private AccountMapper accountMapper;

    @RequestMapping(value = "/friendSeePage/{Account_id}", method = RequestMethod.GET)
    public String goFriendSeePage(@PathVariable Integer Account_id,
                                  Map<String, String> map) {
        accountMapper = applicationContext.getBean(AccountMapper.class);

        Account friend = accountMapper.queryAccountInfoById(Account_id);
        map.put("name", friend.getAccount_name());
        map.put("email", friend.getAccount_email());

        return "friendSee/FriendSeePage";
    }
}
