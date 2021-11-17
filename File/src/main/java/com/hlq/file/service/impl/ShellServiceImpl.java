package com.hlq.file.service.impl;

import com.hlq.file.service.ShellService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@Component
public class ShellServiceImpl implements ShellService, ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.compress();
    }

    @Override
    public void compress() {
        try {
            String path = System.getProperty("user.dir");
            path = path + "\\File\\src\\main\\resources\\";


            Process process = Runtime.getRuntime().exec(new String[]{"tar", "-Zvcf", "test.tar.Z", "火车票"}, null, new File(path));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
