package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.Mappers.FriendsMapper;
import com.zzz.mvc.entities.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Account")
@SessionAttributes(value = {"current_Account_id"}, types = {})
public class AccountHandler {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml");

    private AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);
    private FriendsMapper friendsMapper = applicationContext.getBean(FriendsMapper.class);


    @RequestMapping(value = "/searchAccounts", method = RequestMethod.POST)
    public String searchAccounts(String s,
                                 Map<String, Object> map){
        System.out.println(s);
        String ss = "%" + s + "%";
        List<Account> accounts = accountMapper.queryAccountsBySearcher(ss);
        map.put("accounts", accounts);
        return "showAccounts";
    }
    @RequestMapping(value = "/editAccountInfo", method = RequestMethod.POST)
    public String editInfo(@Valid Account newAccountInfo,
                           BindingResult bindingResult,
                           Map<String, Object> map) {

        if(bindingResult.getErrorCount() > 1){
            return "editAccountPage";
        }

        accountMapper.editAccountInfo(newAccountInfo);
        map.put("name", newAccountInfo.getAccount_name());
        map.put("email", newAccountInfo.getAccount_email());
        return "personalPage";
    }


    @RequestMapping(value = "/editAccountInfo", method = RequestMethod.GET)
    public String goToEditAccountInfo() {
        return "editAccountPage";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String register(@Valid Account account, BindingResult bindingResult,
                           Map<String, Object> map) {
        if (bindingResult.getErrorCount() > 0) {

            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            map.put("newAccount", new Account());
            return "signUpPage";
        }

        accountMapper.addOneAccount(account);
        return "redirect:/Account/zzz";
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String goForSignUp(Map<String, Object> map) {
        map.put("newAccount", new Account());
        return "signUpPage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Account account,
                         Map<String, Object> map) {
        String account_Email = account.getAccount_email();
        try {
            Account real = accountMapper.queryAccountInfoByEmail(account_Email);
            if (real.getAccount_password().equals(account.getAccount_password())) {

                Account current_Account = real;
                System.out.println(current_Account);
                List<Account> allFriends = friendsMapper.selectAllFriendsById(real.getAccount_id());
                map.put("name", real.getAccount_name());
                map.put("email", real.getAccount_email());
                map.put("current_Account_id", real.getAccount_id());
                map.put("current_Account", current_Account);
                map.put("friends", allFriends);

                return "personalPage";
            } else {
                return "redirect:/Account/zzz";
            }
        } catch (NullPointerException npe) {
            return "redirect:/Account/zzz";
        }
    }

    @RequestMapping("zzz")
    public String start(Map<String, Object> map) {
        map.put("Account", new Account());
        return "signInPage";
    }
}
