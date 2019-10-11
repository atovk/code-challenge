package com.atovk.design.exec.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.hibernate.HikariConfigurationUtil;
import com.zaxxer.hikari.pool.HikariPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class HikariTestMain {

    public static void main(String[] args) throws Exception {

        DruidDataSource druidDataSource = new DruidDataSource();

        DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(new Properties());
        PreparedStatement prepareStatement = dataSource.getConnection().prepareStatement("select * from test");
        ResultSet resultSet = prepareStatement.executeQuery();

        HikariDataSource hikariDataSource = new HikariDataSource(new HikariConfig());

        HikariDataSource hikariDataSource10 = new HikariDataSource();
        hikariDataSource10.setDataSource(null);
        hikariDataSource10.setDataSourceProperties(new Properties());

        DruidPooledConnection connection2 = dataSource.getConnection();
        connection2.close();


        Connection connection1 = hikariDataSource.getConnection();
        ResultSet resultSet2 = connection1.prepareStatement("select * from ccs").executeQuery();

        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setProperties(new Properties());


        HikariConfig hikariConfig1 = new HikariConfig();

        HikariPool hikariPool = new HikariPool(hikariConfig1);
        Connection connection = hikariPool.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from ccs");
        ResultSet resultSet1 = statement.executeQuery();


        HikariConfig hikariConfig = HikariConfigurationUtil.loadConfiguration(null);

    }



}
