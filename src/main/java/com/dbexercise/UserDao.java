package com.dbexercise;

import com.dbexercise.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {
    public void add() throws ClassNotFoundException, SQLException {

        // 보안을 위해 설정한 환경변수 값들을 map 으로 가져오기
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        // jdbcDriver 로드
        Class.forName(jdbcDriver);

        // DB 연결
        Connection con = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        // 쿼리 작성
        PreparedStatement ps = con.prepareStatement("INSERT INTO users(id, name, password) values(?,?,?)");
        ps.setString(1, "3");
        ps.setString(2, "장서현");
        ps.setString(3, "1919");

        // 쿼리 실행
        int status = ps.executeUpdate();
        System.out.println(status);

        // 자원 반납
        ps.close();
        con.close();

        System.out.println("DB Insert Complete");
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        PreparedStatement ps = con.prepareStatement("SELECT id, name, password FROM `likelion-db`.users WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

        // 열었던 순서 역순으로 닫기
        rs.close();
        ps.close();
        con.close();

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
//        userDao.add();

        User user = userDao.get("1");
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}