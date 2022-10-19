package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId("0");
        user.setName("seohyeon");
        user.setPassword("0000");
        userDao.add(user);

        User result = userDao.get("0");
        Assertions.assertEquals("0", result.getId());
    }
}