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

    /**
     * 根据传入参数查询
     * @param user 查询的条件有可能有性别有可能有用户名，地址等等。。
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据ID集合查询
     * @param Vo
     * @return
     */
    List<User> findUserInIds(QueryVo Vo);
}
