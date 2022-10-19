package com.dbexercise.dao;

public class UserDaoFactory {

    // 조립을 해준다.
    public UserDao awsUserDao() {
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao(awsConnectionMaker);
        return userDao;
    }
}
