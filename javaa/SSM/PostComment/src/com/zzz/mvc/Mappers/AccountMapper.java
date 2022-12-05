package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.Account;
import com.zzz.mvc.exceptions.CanNotAddAccountException;
import com.zzz.mvc.exceptions.CanNotDeleteAccountException;
import com.zzz.mvc.exceptions.CanNotEditAccountException;
import com.zzz.mvc.exceptions.CanNotQueryAccountException;

import java.util.List;

public interface AccountMapper {
    void addOneAccount(Account newAccount) throws CanNotAddAccountException;

    void deleteOneAccountByEmail(String Account_Email) throws CanNotDeleteAccountException;

    void editAccountInfo(Account newUser) throws CanNotEditAccountException;

    Account queryAccountInfoByEmail(String Account_email) throws CanNotQueryAccountException;

    Account queryAccountInfoById(Integer Account_id) throws CanNotQueryAccountException;

    List<Account> queryAccountsBySearcher(String ss);
}
