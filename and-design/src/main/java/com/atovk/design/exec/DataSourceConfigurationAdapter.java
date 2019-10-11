package com.atovk.design.exec;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * 配置完成后 获取到dataSource抽象接口
 *
 * 在具体执行中保存 连接池信息，数据库驱动类型等信息
 */
public class DataSourceConfigurationAdapter {

    /**
     *  新建 Druid 连接池数据源
     * @param sourceClass
     * @param maps
     * @return
     */
    public static DataSource druidDataSource(Map<String, String> maps) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(setDruidConfig(maps));
        return druidDataSource;
    }

    private static Properties setDruidConfig(Map<String, String> maps) {
        Properties properties = new Properties();
        for (Map.Entry<String, String> map : maps.entrySet()) {
            properties.setProperty("druid." + map.getKey(), map.getValue());
        }
        return properties;
    }
}
