package com.mydemo.dao;

import com.mydemo.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
