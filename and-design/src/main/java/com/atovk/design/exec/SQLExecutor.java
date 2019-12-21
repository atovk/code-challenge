package com.atovk.design.exec;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.UUID;

public class SQLExecutor implements Executor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLExecutor.class);

    private final String ID;
    private String className;
    private DruidDataSource dataSource;

    SQLExecutor(Map<String, String> maps) {
        this(UUID.randomUUID().toString(), maps);
    }

    SQLExecutor(String key, Map<String, String> maps) {
        this.ID = key;
        this.dataSource = (DruidDataSource) DataSourceConfigurationAdapter.druidDataSource(maps);
        this.className = this.dataSource.getClass().toGenericString();
    }

    @Override
    public ResultSet exec(String sql) {
        ResultSet resultSet = null;
        try {
            DruidPooledConnection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            LOGGER.error("获取连接异常.");
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public boolean state() {
        return dataSource.isEnable();
    }

    @Override
    public int count() {
        return dataSource.getActiveCount();
    }

    @Override
    public String hashId() {
        return this.ID;
    }

    /**
     * 销毁当前执行器
     */
    @Override
    public void destroy() {
        dataSource.close();
    }
}
