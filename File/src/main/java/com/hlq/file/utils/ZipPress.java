package com.hlq.file.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author HanLq
 */
@Component
public class ZipPress {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipPress.class);

    /**
     * 压缩文件接口
     * @param sourPath 源文件夹路径
     * @param tarPath 生成路径
     * @param format 压缩格式
     */
    public static void zipCompress(String sourPath, String tarPath, String format) {
        ZipOutputStream zipOutputStream;
        FileOutputStream fileOutputStream;
        try {
            // 判断源文件夹是否存在
            File sourDir = new File(sourPath);
            if (!sourDir.exists()) {
                LOGGER.error("文件夹不存在：" + sourPath);
                throw new FileNotFoundException();
            }
            // 输出流
            fileOutputStream = new FileOutputStream(tarPath + "." + format);
            // 压缩输出流
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            // 打包压缩文件
            generateFile(zipOutputStream, sourDir, "");
            zipOutputStream.close();
            fileOutputStream.close();
            LOGGER.info("源文件位置:" + sourPath + "，目标文件位置：" + tarPath);
        } catch (Exception e) {
            LOGGER.error("文件压缩失败：" + sourPath);
        }
    }

    /**
     * 压缩文件
     * @param out  输出流
     * @param file 目标文件
     * @param dir  文件夹
     */
    private static void generateFile(ZipOutputStream out, File file, String dir) throws Exception {
        // 当前的是文件夹，则进行一步处理
        if (file.isDirectory()) {
            //得到文件列表信息
            File[] files = file.listFiles();
            if (files == null) {
                throw new Exception();
            }
            //将文件夹添加到下一级打包目录
            dir = dir.length() == 0 ? "" : dir + "/";
            //循环将文件夹中的文件打包
            for (File value : files) {
                generateFile(out, value, dir + value.getName());
            }
        } else { // 当前是文件
            // 输入流
            FileInputStream inputStream = new FileInputStream(file);
            // 标记要打包的条目
            out.putNextEntry(new ZipEntry(dir));
            // 进行写操作
            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            // 关闭输入流
            inputStream.close();
        }
    }


}
