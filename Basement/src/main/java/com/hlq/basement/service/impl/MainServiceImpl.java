package com.hlq.basement.service.impl;

import com.hlq.basement.config.ApplicationConfig;
import com.hlq.basement.service.MainService;
import com.hlq.basement.utils.MainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MainServiceImpl implements MainService, ApplicationRunner {

    @Autowired
    private MainUtils mainUtils;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mainUtils.run();
    }
}
