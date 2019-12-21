package com.atovk.execise.jdbc;

import java.sql.*;
import java.util.Properties;

public class JDBCMateTest {


    public static Connection getConn(String driverName, String url, String username, String passwd) {
        Connection conn = null;
        try {
            Class.forName(driverName); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (ClassNotFoundException | SQLException e) {
            //throw new RuntimeException(String.format("Driver: %s ; Url: %s ; userName: %s ;", driverName, url, username), e);
            e.printStackTrace();
        }
        return conn;
    }


    public static void main(String[] args) throws SQLException {

        Properties info =new Properties();

        // !!! Oracle 如果想要获取元数据 REMARKS 信息,需要加此参数
        info.put("remarksReporting","true");
        // !!! MySQL 标志位, 获取TABLE元数据 REMARKS 信息
        info.put("useInformationSchema","true");


        Connection conn = getConn("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "");

        conn.setClientInfo(info);


        String databases = conn.getCatalog();

        //Connection conn = getConn("com.sap.db.jdbc.Driver", "jdbc:sap://10.0.30.109:30015/SAPECC", "hadoop", "HaDooPload2018");


        DatabaseMetaData metaData = conn.getMetaData();

        metaData.getDatabaseProductName();

        //ResultSet cpp_area = metaData.getProcedureColumns(null, "cpp_area", null, null);



        ResultSet tables = metaData.getTables(databases, null, null, new String[]{"TABLE", "VIEW"});

        printReault(tables);

        ResultSet cpp_area_columns = metaData.getColumns(null, null, "cpp_area", null);

        printReault(cpp_area_columns);
        System.out.println();


    }

    public static void printReault(ResultSet resultSet) throws SQLException {

        // print meta
        ResultSetMetaData metaData = resultSet.getMetaData();
        int size = metaData.getColumnCount();
        for (int i = 1; i < size; i++) {
            System.out.print(metaData.getColumnName(i)+"/" + metaData.getColumnTypeName(i) + "/" + metaData.getColumnType(i) + "  ");
        }
        System.out.println();

        // print data
        while (resultSet.next()) {
            for (int i = 1; i < size; i++) {
                String line = resultSet.getString(i) + "  ";
                System.out.print(line);
            }
            System.out.println();
        }

    }


    public static void dbMeta(Connection connection) throws SQLException {

        DatabaseMetaData metaData = connection.getMetaData();

    }

    public static void tableMeta(Connection conn) throws SQLException {

        DatabaseMetaData metaData = conn.getMetaData();

    }



}
