import com.mydemo.dao.UserDao;
import com.mydemo.domain.QueryVo;
import com.mydemo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream is;
    private SqlSession  sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession(true);

        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        //提交事务
        //sqlSession.commit();
        is.close();
        sqlSession.close();
    }

    /**
     * 查询
     */
    @Test
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 新增
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("mybatis last insertid");
        user.setAddress("湖北省武汉市");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存");
        //执行保存方法
        userDao.saveUser(user);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(52);
        user.setUsername("mybatis update");
        user.setAddress("湖北省武汉市");
        user.setSex("男");
        user.setBirthday(new Date());
        //执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 删除
     */
    @Test
    public void deleteUser(){
        userDao.deleteUser(53);
    }

    /**
     * 根据id查用户
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(52);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询用户数
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 通过QueryVo查
     */
    @Test
    public void testFindByVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> users = userDao.findByVo(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}
