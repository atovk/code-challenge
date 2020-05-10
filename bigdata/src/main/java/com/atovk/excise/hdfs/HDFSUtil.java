package com.atovk.excise.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class HDFSUtil {

/*
    private static Configuration conf = new Configuration();


    static {
        conf.addResource("/hdfs.xml");
        conf.addResource("");


    }
*/


    private static FileSystem instance(Configuration conf) {

        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystem.newInstance(conf);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileSystem != null) fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileSystem;
    }


    public static boolean connectable(String HDFSUrl) {
        Configuration conf = new Configuration();
        conf.set("ipc.client.connect.timeout", "3000");
        conf.set("ipc.client.connect.max.retries.on.timeouts", "1");
        conf.set("fs.defaultFS", HDFSUrl);
        boolean exists = false;
        FileSystem fs = instance(setConfig());
        try {
            exists = instance(conf).exists(new Path("/"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exists;
    }


    public static Configuration setConfig() {
        Configuration conf = new Configuration();

        //设置配置相关的信息，分别对应hdfs-site.xml core-site.xml
        conf.set("fs.defaultFS", "hdfs://nameservice1");
        conf.set("dfs.nameservices", "nameservice1");
        conf.set("dfs.ha.namenodes.nameservice1", "namenode86,namenode145");
        conf.set("dfs.namenode.rpc-address.nameservice1.namenode86", "hadoop01-dev.bigdata.cn:8020");
        conf.set("dfs.namenode.rpc-address.nameservice1.namenode145", "hadoop02-dev.bigdata.cn:8020");
        conf.set("dfs.client.failover.proxy.provider.nameservice1", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");

        //设置实现类，因为会出现类覆盖的问题
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());
        return conf;
    }

    public static Configuration loadConfig() {
        Configuration conf = new Configuration();
        conf.addResource("/src/*");

        return conf;
    }


















    public static void main(String[] args) throws IOException {

        Configuration conf = new Configuration();
       // FileSystem fileSystem1 = FileSystem.get(URI.create("hdfs://192.168.1.103:9000"), conf);
        conf.set("ipc.client.connect.timeout", "3000");
        conf.set("ipc.client.connect.max.retries.on.timeouts", "1");


        FileSystem.get(loadConfig()).listFiles(new Path("/"), false);

        System.out.println();

    }

}
