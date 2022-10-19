package com.dbexercise.dao;

import com.dbexercise.domain.User;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(AWSConnectionMaker awsConnectionMaker) {
        connectionMaker = new AWSConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection con = connectionMaker.makeConnection();

        // 쿼리 작성
        PreparedStatement ps = con.prepareStatement("INSERT INTO users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // 쿼리 실행
        ps.executeUpdate();

        // 자원 반납
        ps.close();
        con.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection con = connectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM `likelion-db`.users WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        // 열었던 순서 역순으로 닫기
        rs.close();
        ps.close();
        con.close();

        return user;
    }
}