package com.hlq.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * @Program: HbaseUtil
 * @Description: Hbase工具类
 * @Author: HanLinqi
 * @Date: 2022/01/02 16:23:50
 */
@Component
public class HbaseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HbaseUtil.class);

    /**
     * 配置文件
     */
    private Configuration conf = null;

    /**
     * SQL连接
     */
    private Connection conn = null;

    /**
     * 创建数据库管理对象，负责管理数据库的表信息
     */
    private Admin admin = null;

    /**
     * 显示配置
     */
    public void initPub() {
        conf = HBaseConfiguration.create();
        // zookeeper配置
        conf.set("hbase.zookeeper.quorum","121.41.169.208");
        conf.set("hbase.zookeeper.property.clientPort","2181");
        // Hbase master 连接
        conf.set("hbase.master", "121.41.169.208:16000");
        conf.setInt("hbase.regionserver.port", 16201);
        conf.setInt("hbase.rpc.timeout",200);
        conf.setInt("hbase.client.operation.timeout",300);
        conf.setInt("hbase.client.scanner.timeout.period",200);

        try {
            conn = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            LOGGER.error("创建Hbase连接错误, ERROR | {}", e.getMessage());
        }

    }

    /**
     * 初始化连接
     */
    @PostConstruct
    public void init() {
        try {
            conf = HBaseConfiguration.create();
            conf.addResource(new Path("hbase-site.xml"));
            conn = ConnectionFactory.createConnection(conf);
        } catch (Exception e) {
            LOGGER.error("创建Hbase连接失败，ERROR | {}", e.getMessage());
        }
    }

    /**
     * 创建表
     * @param tableName 表名称
     * @param columnFamilies 列族
     * @throws Exception
     */
    public void createTable(String tableName, String[] columnFamilies) throws Exception {
        admin = conn.getAdmin();
        if (admin.tableExists(TableName.valueOf(tableName))) {
            throw new Exception(tableName + " 已经存在");
        }
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        for (String col: columnFamilies) {
            HColumnDescriptor column = new HColumnDescriptor(col);
            table.addFamily(column);
        }
        admin.createTable(table);
        LOGGER.info(tableName + " 创建成功!");
        admin.close();
    }
}
