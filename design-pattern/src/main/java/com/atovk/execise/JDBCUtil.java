package com.atovk.execise;

import java.sql.*;

public class JDBCUtil {

    private static Connection getConn(String driverName, String url, String userName, String passwd) {
        Connection conn = null;
        try {
            Class.forName(driverName); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, userName, passwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void executeQuery(Connection conn, String sql) {


    }

    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtil.getConn("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/psc", "root", "");

        conn.getClientInfo();

        Statement statement = conn.createStatement();

        ResultSet show_databases = statement.executeQuery("select * from test.cpp_area limit 10");

        ResultSetMetaData metaData = show_databases.getMetaData();

        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnClassName(i) + " ");
        }
        System.out.println();
        while (show_databases.next()) {


            for (int i = 1; i <= columnCount; i++) {
                Object object = show_databases.getObject(metaData.getColumnLabel(i));
                System.out.print(object + " ");
            }
            System.out.println();

        }


    }


}
