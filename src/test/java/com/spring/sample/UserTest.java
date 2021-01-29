package com.spring.sample;

import com.spring.sample.dao.impl.UserDaoImpl;
import com.spring.sample.domain.User;
import com.spring.sample.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {

    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService1 = ac.getBean("userService", IUserService.class);

        List<User> users = userService1.findAll();

        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testPrototype() {

        // 测试单例
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserDaoImpl userDao1 = ac.getBean("userDao", UserDaoImpl.class);
        UserDaoImpl userDao2 = ac.getBean("userDao", UserDaoImpl.class);

        System.out.println(userDao1.getQueryRunner() == userDao2.getQueryRunner());
    }
}
