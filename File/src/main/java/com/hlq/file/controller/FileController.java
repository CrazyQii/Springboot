package com.hlq.file.controller;

import com.hlq.file.utils.ZipPress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * 文件上传Controller
 */
@RestController
public class FileController {

    private static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @PostMapping(value = "/file", consumes = {"multipart/form-data"}, produces = "application/json")
    public String upload(@RequestPart("files") MultipartFile[] files) {
        LOGGER.info("开始上传文件");
        Map<String, InputStream> map = new HashMap<>();
        try {
            // 获取服务器resource根路径
            String rootPath = System.getProperty("user.dir");
            // 文件夹路径
            long ts = (new Date()).getTime();
            String DirPath = "\\SpringbootFile\\src\\main\\resources\\火车票\\" + ts;

            // 文件解码
            for (MultipartFile file: files) {
                // 判断文件大小
                long size = file.getSize();
                if (size == 0L) continue;
                // 获取文件名称
                String fileName = file.getOriginalFilename();
                // 获取文件后缀名
//                String suffixName = file.getName().substring(fileName.lastIndexOf("."));
                // 创建文件保存路径
                String path = rootPath + DirPath + "\\" + fileName;
                File dest = new File(path);
                // 文件夹是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                file.transferTo(dest);
                LOGGER.info("文件上传成功：" + fileName);
            }

            // 当日数据传输结束，开始打包压缩文件
            LOGGER.info("开始打包压缩文件");
            ZipPress.zipCompress(rootPath + "\\SpringbootFile\\src\\main\\resources\\火车票", rootPath + "\\SpringbootFile\\src\\main\\resources\\火车票", "zip");
        } catch (Exception e) {
            LOGGER.error("上传文件错误：" + e);
        }
        return null;

    }
}
