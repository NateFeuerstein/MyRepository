import com.mydemo.dao.UserDao;
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
        sqlSession = factory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();
        is.close();
        sqlSession.close();
    }

    @Test
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("mybatis");
        user.setAddress("湖北省武汉市");
        user.setSex("男");
        user.setBirthday(new Date());

        //执行保存方法
        userDao.saveUser(user);

    }
}
