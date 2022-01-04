package com.hlq.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseUtilTest {

    @Autowired
    private HbaseUtil hbaseUtil;

    @Test
    public void start() {
        String tableName = "sss";
        String[] colFamily = {"c1", "c2"};
        hbaseUtil.createTable(tableName, colFamily);
    }
}