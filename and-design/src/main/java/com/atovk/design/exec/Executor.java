package com.atovk.design.exec;

/**
 * 根据传入的实例化信息（db/ssh连接信息）生成对应的执行起操作
 *
 * @author hongdong
 * @date 20191009
 */
public interface Executor<T> {

    T exec(String execStr);

    boolean state();

    int count();

}
