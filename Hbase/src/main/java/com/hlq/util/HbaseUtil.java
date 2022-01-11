package com.hlq.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
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

    @PreDestroy
    public void destroy() {
        try {
            if (this.admin != null) {
                this.admin.close();
            }
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (Exception e) {
            LOGGER.error("销毁Hbase失败，ERROR | {}", e.getMessage());
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
            throw new Exception("Hbase " + tableName + " 已经存在!");
        }
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        for (String col: columnFamilies) {
            HColumnDescriptor column = new HColumnDescriptor(col);
            table.addFamily(column);
        }
        admin.createTable(table);
        LOGGER.info("Hbase {} 创建成功!", tableName);
        admin.close();
    }

    /**
     * 扫描全表
     * @param tableName 表名称
     * @throws Exception
     */
    public void scanTable(String tableName) throws Exception {
        Scan scan = new Scan();
        Table table = conn.getTable(TableName.valueOf(tableName));
        ResultScanner rs = table.getScanner(scan);
        for (Result result : rs) {
            for (Cell cell : result.listCells()) {
                System.out.println(Bytes.toString(cell.getFamilyArray()));
            }
        }
        rs.close();
    }


    /**
     * 扫描行
     * @param tableName 表名
     * @param rowKey 主键
     * @throws IOException
     */
    public void scanRow(String tableName, String rowKey) throws IOException {
        Get get = new Get(Bytes.toBytes(rowKey));
        Table table = conn.getTable(TableName.valueOf(tableName));
        Result result = table.get(get);
        for (Cell cell: result.listCells()) {
            System.out.println(Bytes.toString(cell.getFamilyArray()));
        }
    }

    /**
     * 插入数据
     * @param tableName 表名
     * @param rowKey 主键
     * @param columnFamily 列族
     * @param columns 列
     * @param data 数据
     * @throws IOException
     */
    public void insertData(String tableName, String rowKey, String columnFamily, String[] columns,  String[] data) throws IOException {
        Table table = conn.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        for (int i = 0; i < columns.length; i++) {
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columns[i]), Bytes.toBytes(data[i]));
        }
        table.put(put);
        table.close();
    }
}
