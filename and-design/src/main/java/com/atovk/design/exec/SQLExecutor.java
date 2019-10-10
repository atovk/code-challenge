package com.atovk.design.exec;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.Map;
import java.util.UUID;

public class SQLExecutor implements Executor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLExecutor.class);

    private String ID = null;
    private

    SQLExecutor() {}

    SQLExecutor(Map<String, String> maps){
        this.ID = UUID.randomUUID().toString();

    }

    SQLExecutor(String key, Map<String, String> maps) {
        this.ID = key;

    }

    @Override
    public ResultSet exec(String sql) {

        return null;
    }

    @Override
    public boolean state() {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String hashId() {
        return null;
    }

    /**
     * 销毁当前执行器
     */
    @Override
    public void destroy() {

    }
}
