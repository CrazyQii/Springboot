package com.hlq;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.io.IOException;

/**
 * @program: HbaseApplication
 * @description: Hbase Java Api
 * @author: hanLinQi
 * @create: 2021-12-31 16:16
 **/
@SpringBootApplication(exclude = GsonAutoConfiguration.class)
public class HbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbaseApplication.class, args);
    }

}
