package com.atovk.design.exec.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.hibernate.HikariConfigurationUtil;

import javax.sql.DataSource;
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

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDataSource(null);


        HikariConfig hikariConfig = HikariConfigurationUtil.loadConfiguration(null);



    }



}
