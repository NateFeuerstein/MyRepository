package com.mydemo.dao;

import com.mydemo.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
