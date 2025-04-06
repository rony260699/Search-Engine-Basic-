package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    static Connection connection = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if(connection != null) return connection;
        String userName = "root";
        String pswrd = "26JUN2001";
        String db = "SearchEngine";

        return getConnection(userName, pswrd, db);
    }

    private static Connection getConnection(String userName, String pswrd, String db) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+db+"?user="+userName+"&password="+pswrd);
            return connection;
    }
}
