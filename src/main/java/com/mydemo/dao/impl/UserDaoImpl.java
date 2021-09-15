package com.mydemo.dao.impl;

import com.mydemo.dao.UserDao;
import com.mydemo.domain.QueryVo;
import com.mydemo.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.通过factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users = sqlSession.selectList("com.mydemo.dao.UserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String name) {
        return null;
    }

    public int findTotal() {
        return 0;
    }

    public List<User> findByVo(QueryVo vo) {
        return null;
    }

    public List<User> findUserByCondition(User user) {
        return null;
    }

    public List<User> findUserInIds(QueryVo Vo) {
        return null;
    }
}
