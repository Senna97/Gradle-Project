package com.dbexercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makePreparedStatement(Connection con) throws SQLException {
        return con.prepareStatement("DELETE FROM `likelion-db`.users");
    }
}
