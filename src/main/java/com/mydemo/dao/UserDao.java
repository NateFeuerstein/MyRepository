package com.mydemo.dao;

import com.mydemo.domain.QueryVo;
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

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户id查找用户
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 模糊查询
     * @param name
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 通过QueryVo查
     * @param vo
     */
    List<User> findByVo(QueryVo vo);
}
