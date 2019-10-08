package com.atovk.execise.adapter;

import com.atovk.execise.domain.DataLinkSource;
import com.atovk.execise.domain.DataLinkSourceTable;
import com.atovk.execise.domain.DataLinkSourceTableColumn;

import java.sql.SQLException;
import java.util.List;

public interface DataLinkSourceUtility {

    List<DataLinkSourceTable> getTables(DataLinkSource dls) throws SQLException;

    List<DataLinkSourceTable> getTableName(DataLinkSource dls, String tableName);

    List<DataLinkSourceTableColumn> getColumns(DataLinkSource dls, String tableName);

    boolean checkConnect(DataLinkSource dls);

}
