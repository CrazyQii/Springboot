package com.hlq.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompressUtilsTest {

    private final String rootPath = System.getProperty("user.dir") + "\\src\\main\\resources";

    @Autowired
    private CompressUtils compressUtils;

    @Test
    public void tarZCompress() {
        compressUtils.tarZCompress(rootPath, "test","Kafka常见问题.md");
    }

    @Test
    public void zipCompress() {
        compressUtils.zipCompress(rootPath, "test", "Kafka");
    }
}