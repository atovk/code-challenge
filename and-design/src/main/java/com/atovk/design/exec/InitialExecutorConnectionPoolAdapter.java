package com.atovk.design.exec;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang.ClassUtils;

import javax.sql.DataSource;
import java.util.Map;

public class InitialExecutorConnectionPoolAdapter<T> {

    private Class<?> cpType;

    InitialExecutorConnectionPoolAdapter(String className) {
        this.exClass(className);
    }

    private void exClass(String className) {
        try {
            cpType = ClassUtils.getClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static InitialExecutorConnectionPoolAdapter<?> create() {
        return new InitialExecutorConnectionPoolAdapter<>("com.alibaba.druid.pool.DruidDataSource");
    }

    public T instance(String className, Map<String, String> maps) {

        Object instance = null;
        try {
            instance = cpType.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T) instance;
    }


    public static void main(String[] args) throws Exception {

        InitialExecutorConnectionPoolAdapter<?> poolAdapter = InitialExecutorConnectionPoolAdapter.create();

        DataSource instance =(DataSource) poolAdapter.instance("", null);

        DruidDataSource instance1 = (DruidDataSource) instance;

        System.out.println("");

    }

}
