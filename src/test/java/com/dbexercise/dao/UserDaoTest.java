package com.dbexercise.dao;

import com.dbexercise.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)

class UserDaoTest {
    UserDao userDao;
    User user1;
    User user2;
    User user3;

    @Autowired
    ApplicationContext context;
    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        this.userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        this.user1 = new User("1", "seohyeon", "1111");
        this.user2 = new User("2", "seohyeon", "2222");
        this.user3 = new User("3", "seohyeon", "3333");
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        userDao.add(user1);

        User result = userDao.get("1");
        assertEquals("1", result.getId());
    }

    @Test
    public void addAndDeleteAll() throws SQLException, ClassNotFoundException {
        userDao.add(user2);
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        userDao.add(user1);
        assertEquals(1, userDao.getCount());
        userDao.add(user2);
        assertEquals(2, userDao.getCount());
        userDao.add(user3);
        assertEquals(3, userDao.getCount());
    }

    @Test
    public void get() {
        assertThrows(EmptyResultDataAccessException.class, () -> {
            userDao.get("30");
        });
    }
}