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
    public void start() {
        try {
            String tableName = "Students";
            String[] cols = new String[]{"col1", "col2"};
            hbaseUtil.createTable(tableName, cols);
        } catch (Exception e) {
            LOGGER.error("测试失败，ERROR | {}", e.getMessage());
        }
    }
}