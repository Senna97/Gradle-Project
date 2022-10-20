package com.dbexercise.dao;

import com.dbexercise.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);

        User user = new User("0", "seohyeon", "0000");
        userDao.add(user);
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());

        User user1 = new User("1", "seohyeon", "0000");
        userDao.add(user1);
        assertEquals(1, userDao.getCount());

        User result = userDao.get("1");
        assertEquals("1", result.getId());
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        User user2 = new User("2", "seohyeon", "0000");
        User user3 = new User("3", "seohyeon", "0000");
        User user4 = new User("4", "seohyeon", "0000");

        UserDao userDao = context.getBean("awsUserDao", UserDao.class);

        userDao.deleteAll();
        assertEquals(0, userDao.getCount());

        userDao.add(user2);
        assertEquals(1, userDao.getCount());
        userDao.add(user3);
        assertEquals(2, userDao.getCount());
        userDao.add(user4);
        assertEquals(3, userDao.getCount());
    }
}