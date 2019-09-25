package com.atovk.execise.mutiple.pool;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class JDBCConnectPoolTest {


    public static void main(String[] args) throws Exception {

        Map<Object, Object> map = new HashMap<>();

        DataSource dataSource = DruidDataSourceFactory.createDataSource(map);

        Connection connection = dataSource.getConnection();

        DruidDataSource druidDataSource = new DruidDataSource();
        DruidPooledConnection druidPooledConnection = druidDataSource.getConnection();

        PreparedStatement tables = druidPooledConnection.prepareStatement("show tables");

        // 一个数据源配置 只能实例话出一个 connection 实例




    }


}
