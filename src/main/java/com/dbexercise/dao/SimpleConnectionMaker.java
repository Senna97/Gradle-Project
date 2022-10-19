package com.dbexercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class SimpleConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException {

        // 보안을 위해 설정한 환경변수 값들을 map 으로 가져오기
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        // jdbcDriver 로드
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        Class.forName(jdbcDriver);

        // DB 연결
        Connection con = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        return con;
    }
}
