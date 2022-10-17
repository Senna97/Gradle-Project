package com.dbexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao.add();
    }
}