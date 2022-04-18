package com.hlq.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseUtilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HbaseUtilTest.class);

    @Autowired
    private HbaseUtil hbaseUtil;

    @Test
    public void createTable() {
        try {
            String tableName = "Students";
            String[] cols = new String[]{"col1", "col2"};
            hbaseUtil.createTable(tableName, cols);
        } catch (Exception e) {
            LOGGER.error("测试失败，ERROR | {}", e.getMessage());
        }
    }

    @Test
    public void scanTable() {
        try {
            String tableName = "Student";
            hbaseUtil.scanTable(tableName);
        } catch (Exception e) {
            LOGGER.error("扫描全表失败，ERROR | {}", e.getMessage());
        }
    }

    @Test
    public void scanRow() {
        try {
            String tableName = "Student";
            String rowKey = "0002";
            hbaseUtil.scanRow(tableName, rowKey);
        } catch (Exception e) {
            LOGGER.error("扫描Hbase行失败，ERROR | {}", e.getMessage());
        }
    }

    @Test
    public void insertData() {
        try {
            String tableName = "Student";
            String rowKey = "0002";
            String columnFamily = "StuInfo";
            String[] column = new String[]{"Name"};
            String[] data = new String[] {"hlq"};
            hbaseUtil.insertRowData(tableName, rowKey, columnFamily, column, data);
        } catch (Exception e) {
            LOGGER.error("Hbase插入数据失败，ERROR | {}", e.getMessage());
        }
    }

    @Test
    public void dropTable() {
        try {
            String tableName = "Students";
            hbaseUtil.dropTable(tableName);
        } catch (Exception e) {
            LOGGER.error("Hbase删除表失败, ERROR | {}", e.getMessage());
        }
    }

    @Test
    public void deleteRowData() {
        try {
            String tableName = "Student";
            String rowKey = "0002";
            hbaseUtil.deleteRowData(tableName, rowKey);
        } catch (Exception e) {
            LOGGER.error("Hbase删除行数据失败， ERROR | {}", e.getMessage());
        }
    }

    @Test
    public void deleteColData() {
        try {
            String tableName = "Student";
            String rowKey = "0002";
            String columnFamily = "StuInfo";
            String column = "Age";
            hbaseUtil.deleteColData(tableName, rowKey, columnFamily, column);
        } catch (Exception e) {
            LOGGER.error("删除列数据失败， ERROR | {}", e.getMessage());
        }
    }
}