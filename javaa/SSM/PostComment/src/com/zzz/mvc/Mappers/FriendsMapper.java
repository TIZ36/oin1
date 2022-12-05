package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.Account;

import java.util.List;

public interface FriendsMapper {

    List<Account> selectAllFriendsById(Integer Master_id);
}
