package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(AWSConnectionMaker awsConnectionMaker) {
        connectionMaker = new AWSConnectionMaker();
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        Connection con = connectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("DELETE FROM `likelion-db`.users");

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public int getCount() throws SQLException, ClassNotFoundException {
        Connection con = connectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM `likelion-db`.users");

        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        con.close();

        return count;
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
        User user = null;

        if (rs.next()) {
            user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
        }

        // 열었던 순서 역순으로 닫기
        rs.close();
        ps.close();
        con.close();

        if (user == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return user;
    }
}