package com.hlq.controller;

import com.hlq.service.OperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: FileController
 * @description: 文件Controller层
 * @author: hanLinQi
 * @create: 2021-12-01 16:47
 **/
@RestController
public class FileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private OperateService operateService;

    private final String root = System.getProperty("user.dir");

    /**
     * 上传文件
     * @param file 文件
     * @return 上传结果
     */
    @PostMapping(value = "/upload", consumes = "multipart/form-data", produces = "application/json")
    public boolean upload(@RequestPart(value = "file") MultipartFile file) {
        try {
            operateService.saveFileByByte(file, root+"\\src\\main\\resources");
            return true;
        } catch (Exception e) {
            LOGGER.error("单个文件落地失败 | ERROR " + e);
            return false;
        }
    }
}
