package com.atovk.design.exec.test;

import com.alibaba.druid.pool.*;
import com.alibaba.druid.util.DruidDataSourceUtils;

import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidTestMain {

    public static void main(String[] args) throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        PooledConnection pooledConnection = druidDataSource.getPooledConnection();

        Connection connection1 = pooledConnection.getConnection();


        Connection connection = pooledConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * ");

        try {
            DruidPooledConnection druidPooledConnection = druidDataSource.getConnection();

            DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(null);

            DruidDataSource druidDataSource1 = new DruidDataSource();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
