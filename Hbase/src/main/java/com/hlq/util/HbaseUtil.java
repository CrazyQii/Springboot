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
    private Configuration configuration = null;

    /**
     * SQL连接
     */
    private Connection connection = null;

    /**
     * 创建数据库管理对象，负责管理数据库的表信息
     */
    private Admin admin = null;

    @PostConstruct
    public void init() {
        this.configuration = this.initConf();
        LOGGER.info(configuration.toString());
        this.connection = this.initConn();
        LOGGER.info(connection.toString());

        this.admin = this.initAdmin();
    }

    /**
     * 获取配置文件
     */
    private Configuration initConf() {
        Configuration configuration = null;
        try {
            configuration = HBaseConfiguration.create();
            System.out.println(new Path("hbase-site.xml"));
            configuration.addResource(new Path("hbase-site.xml"));
//            configuration.addResource(new Path("/hadoop/etc/hadoop/core-site.xml"));
        } catch (Exception e) {
            LOGGER.error("获取配置文件失败，ERROR | {}", e.getMessage());
        }
        return configuration;
    }

    /**
     * 创建SQL连接
     */
    public Connection initConn() {
        Connection connection = null;
        if (this.configuration != null) {
            try {
                connection = ConnectionFactory.createConnection(this.configuration);
            } catch (IOException e) {
                LOGGER.error("创建SQL连接失败，ERROR | {}", e.getMessage());
            }
        }
        return connection;
    }

    /**
     * 关闭连接
     */
    @PreDestroy
    public void closeConn() {
        try {
            if (this.admin != null) {
                this.admin.close();
            }
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (Exception e) {
            LOGGER.error("关闭Hbase连接失败，ERROR | {}", e.getMessage());
        }
    }

    /**
     * 创建Hbase管理对象
     */
    public Admin initAdmin() {
        Admin admin = null;
        if (this.connection != null) {
            try {
                admin = this.connection.getAdmin();
            } catch (Exception e) {
                LOGGER.error("创建Hbase admin管理失败，ERROR | {}", e.getMessage());
            }
        }
        return admin;
    }

    public void createTable(String newTableName, String[] colFamily) {
        TableName tableName = TableName.valueOf(newTableName);
        try {
            if (this.admin.tableExists(tableName)) {
                throw new Exception(newTableName + "已经存在");
            }
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            for (String str: colFamily) {
                HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(str);
                hTableDescriptor.addFamily(hColumnDescriptor);
            }
            this.admin.createTable(hTableDescriptor);
        } catch (Exception e) {
            LOGGER.error("创建Hbase table失败，ERROR | {}", e.getMessage());
        }
    }
}
