package com.atovk.execise;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.PooledConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DruidConnect {

    public static void main(String[] args) throws SQLException {

        DruidDataSource druidSource = new DruidDataSource();
        druidSource.setUrl("jdbc:mysql://localhost:3306/");
        druidSource.setUsername("root");
        PooledConnection pooledConnection = druidSource.getPooledConnection();

        PreparedStatement show_databases = pooledConnection.getConnection().prepareStatement("show databases");

        ResultSet resultSet = show_databases.executeQuery();
        ResultSetMetaData metaData = show_databases.getMetaData();
        while (resultSet.next()) {

            System.out.println(resultSet.getObject(1));

        }

    }
}


