package com.atovk.design.exec;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.CannotProceedException;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建对应的 执行对象保存在队列中
 * * 通过唯一key 找多 当前 factory中存在的实例对象执行相关操作
 * * 系统中只会存在一个数据源实例对象
 */
public class ExecutorFactory implements AbstractExecutorFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorFactory.class);
    private static final HashMap<String, Executor> execPool = new HashMap<>();

    public Executor instance(String hashKey) {
        if (StringUtils.isEmpty(hashKey)) {
            throw new IllegalArgumentException("传入执行器唯一hashKey不能为空！！！");
        }
        return execPool.get(hashKey);
    }

    /**
     * 新建执行实例（初始化key，和对应数据操作实例，保存到 执行池中）
     *
     * @param key
     * @param maps
     * @return
     */
    public Executor initSQLExecutor(String key, Map<String, String> maps) {
        LOGGER.debug("key: {}, maps: {}", key, JSONUtils.toJSONString(maps));
        SQLExecutor sqlExecutor = new SQLExecutor(key, maps);
        return execPool.put(key, sqlExecutor);
    }

    /**
     * 通过 key 获取 对应实例 执行相关数据操做（返回值返回）
     *
     * @param execKey
     * @return
     */
    public Executor pickExecutor(String execKey) {
        LOGGER.debug("获取key: {}", execKey);
        if (execKey == null || execKey.isEmpty()) {
            throw new IllegalArgumentException("获取的执行器索引不能为空！！");
        }
        return execPool.get(execKey);
    }

    // todo 通过 不同数据源间的 反射 实例化不同的连接池资源

    // todo 对于 ssh 类连接 加入执行完毕自动断开参数，保证服务器连接资源

    /**
     * 销毁连接实例
     *
     * @param key
     * @throws CannotProceedException
     */
    public void destory(String key) throws CannotProceedException {
        if (execPool == null || execPool.isEmpty() || execPool.get(key) == null) {
            LOGGER.error("传入的key存在异常: {}.", key);
            throw new CannotProceedException("未找到需要销毁的连接实例！");
        }
        LOGGER.debug("获取到当前执行器信息: {}.", key);
        Executor executor = execPool.get(key);
        executor.destroy();
    }


    public static void main(String[] args) {

        Executor adas = new ExecutorFactory().instance("adas");


    }


}
