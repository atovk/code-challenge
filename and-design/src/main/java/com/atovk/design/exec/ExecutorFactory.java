package com.atovk.design.exec;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

/**
 * 创建对应的 执行对象保存在队列中
 * 通过唯一key 找多 当前 factory中存在的实例对象执行相关操作
 */
public class ExecutorFactory implements AbstractExecutorFactory {

    private HashMap<String, Executor> execPool = new HashMap<>();

    public Executor instance(String hashKey){
        if (StringUtils.isEmpty(hashKey)) {
            throw new IllegalArgumentException("传入执行器唯一hashKey不能为空！！！");
        }
        return execPool.get(hashKey);
    }


    public static void main(String[] args) {
        ExecutorFactory executorFactory = new ExecutorFactory();
        Executor instance = executorFactory.instance(null);
    }

}
