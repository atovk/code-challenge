package com.atovk.execise.adapter;

import java.sql.*;
import java.util.*;

public abstract class RDBMSConnect  {

    public abstract List<Map<String, Object>> takeConnect(Object t, Object k) throws SQLException ;

    public static Connection getConn(String driverName, String url, String userName, String passwd) {
        Connection conn = null;
        try {
            Class.forName(driverName); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, userName, passwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static List<Map<String, Object>> executeQuery(Connection conn, String sql) throws SQLException {

        List<Map<String, Object>> result;

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            result = resultToList(resultSet);

        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        }
        return result;
    }

    private static List<Map<String, Object>> resultToList(ResultSet resultSet) throws SQLException {

        List<Map<String, Object>> result = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()) {
            HashMap<String, Object> row = new LinkedHashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                row.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            result.add(row);
        }
        return result;
    }
}
