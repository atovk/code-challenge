package com.atovk.design.exec;

/**
 * 根据传入的实例化信息（db/ssh连接信息）生成对应的执行起操作
 *
 * @author hongdong
 * @date 20191009
 */
public interface Executor<T> {

    /**
     * 执行 SQL 语句
     * @param execStr
     * @return
     */
    T exec(String execStr);

    /**
     * 获取运行状态 （true：正在执行脚本，false：无任务执行）
     * @return
     */
    boolean state();

    /**
     * 获取当前执行器中执行的任务数
     * @return
     */
    int count();

    /**
     * 获取但前执行器唯一 ID
     * @return
     */
    String hashId();

    /**
     * 销毁当前执行器
     */
    void destroy();

}
