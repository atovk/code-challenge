package com.atovk.execise.adapter;

import com.atovk.execise.domain.DataLinkSource;
import com.atovk.execise.domain.DataLinkSourceTable;
import com.atovk.execise.domain.DataLinkSourceTableColumn;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MySQLUtil extends RDBMSConnect implements DataLinkSourceUtility {


    @Override
    public List<DataLinkSourceTable> getTables(DataLinkSource dls) throws SQLException {
        List<Map<String, Object>> show_tables = RDBMSConnect.executeQuery(
                RDBMSConnect.getConn(
                        dls.getDataDriverClass(), dls.getDataUrl(), dls.getDataUserName(), dls.getDataUserPassword()),
                "SHOW TABLES");

        return null;
    }

    @Override
    public List<DataLinkSourceTable> getTableName(DataLinkSource dls, String tableName) {
        return null;
    }

    @Override
    public List<DataLinkSourceTableColumn> getColumns(DataLinkSource dls, String tableName) {
        return null;
    }

    @Override
    public boolean checkConnect(DataLinkSource dls) {
        return false;
    }

    @Override
    public List<Map<String, Object>> takeConnect(Object t, Object k) throws SQLException {
        return null;
    }
}
