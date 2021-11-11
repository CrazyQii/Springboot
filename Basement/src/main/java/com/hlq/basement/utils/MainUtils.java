package com.hlq.basement.utils;

import com.hlq.basement.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainUtils {

    @Autowired
    private ApplicationConfig config;


    public void run() {
        System.out.println(config.getRoot());
        System.out.println(config.getTopic());
    }
}
