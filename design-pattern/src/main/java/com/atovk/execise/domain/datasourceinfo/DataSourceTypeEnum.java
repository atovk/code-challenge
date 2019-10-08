package com.atovk.execise.domain.datasourceinfo;

import com.google.common.collect.Lists;

import java.util.List;

public enum DataSourceTypeEnum {
    MYSQL, SQLSERVER, ORACLE, HDFS, HBASE, ELASTICSEARCH, SDDL, ZOOKEEPER, POSTGRESQL;

    public boolean isRdbms() {
        if (MYSQL.equals(this) || SQLSERVER.equals(this) || ORACLE.equals(this) || POSTGRESQL.equals(this)) {
            return true;
        }
        return false;
    }


    public static List<DataSourceTypeEnum> getAllSrcMediaSourceTypes() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HDFS, HBASE, ELASTICSEARCH, POSTGRESQL);
    }

    public static List<DataSourceTypeEnum> getTargetTypesForRDBMS() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HDFS, HBASE, ELASTICSEARCH, POSTGRESQL);
    }

    public static List<DataSourceTypeEnum> getTargetTypesForHDFS() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HDFS, HBASE, ELASTICSEARCH, POSTGRESQL);
    }

    public static List<DataSourceTypeEnum> getTargetTypesForHBASE() {
        return Lists.newArrayList(HDFS, HBASE, POSTGRESQL);
    }

    public static List<DataSourceTypeEnum> getTargetTypesForES() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HBASE, ELASTICSEARCH, POSTGRESQL);
    }
}
