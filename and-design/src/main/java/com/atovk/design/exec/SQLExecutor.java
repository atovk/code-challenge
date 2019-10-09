package com.atovk.design.exec;

import java.sql.ResultSet;

public class SQLExecutor implements Executor {

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
}
