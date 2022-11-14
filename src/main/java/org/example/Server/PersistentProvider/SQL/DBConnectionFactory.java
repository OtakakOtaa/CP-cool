package org.example.Server.PersistentProvider.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    private static final String SQL_URL = "jdbc:mysql://localhost:3306/java_lab_5";
    private static final String USER = "root";
    private static final String PASSWORD = "12345qwerA";


    public Connection Create() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(SQL_URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(DBConnectionFactory.class.getName() + " / " + "dependencies error!");
        } catch (SQLException e) {
            throw new RuntimeException(DBConnectionFactory.class.getName() + " / " + "connection params incorrect!");
        }
    }
}
