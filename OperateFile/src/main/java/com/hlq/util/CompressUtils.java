package com.hlq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @program: ZipCompress
 * @description: 文件压缩操作
 * @author: hanLinQi
 * @create: 2021-12-01 13:51
 **/
@Component
public class CompressUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompressUtils.class);

    /**
     * tar.Z格式压缩
     * @param sourPath 源文件夹所在路径(需要 '/' 结尾)
     * @param sourName 压缩的文件名称
     * @param tarName 生成压缩包名称
     */
    public void tarZCompress(String sourPath, String tarName, String sourName) {
        BufferedReader reader = null;
        Process process = null;
        try {
            // java 调用 shell 命令，执行压缩任务
            process = Runtime.getRuntime().exec(new String[]{"tar", "-Zvcf", tarName + ".tar.Z", sourName}, null, new File(sourPath));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
            LOGGER.info("tar.Z格式压缩成功：文件路径 " + sourPath + tarName);
        } catch (Exception e) {
            LOGGER.error("tar.Z格式压缩失败 ERROR | " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                LOGGER.error("tar.Z格式压缩失败，文件流关闭异常 | ERROR " + e);
            }
        }
    }

    /**
     * zip格式压缩文件夹（单个文件不能直接压缩）
     * @param sourPath 源文件夹路径
     * @param sourName 压缩的文件名称
     * @param tarName 生成压缩包名称
     */
    public void zipCompress(String sourPath, String tarName, String sourName) {
        ZipOutputStream zipOutputStream;
        FileOutputStream fileOutputStream;
        String tarPath, rootPath;
        try {
            // 判断源文件夹是否存在
            rootPath = sourPath + "\\" + sourName;
            tarPath = sourPath + "\\" + tarName;
            File sourDir = new File(rootPath);
            if (!sourDir.exists()) {
                throw new FileNotFoundException("文件夹不存在：" + rootPath);
            }
            // 输出流
            fileOutputStream = new FileOutputStream(tarPath + ".zip");
            // 压缩输出流
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            // 打包压缩文件
            generateFile(zipOutputStream, sourDir, "");
            zipOutputStream.close();
            fileOutputStream.close();
            LOGGER.info("压缩成功：源文件位置:" + rootPath + "，目标文件位置：" + tarPath);
        } catch (Exception e) {
            LOGGER.error("zip格式文件压缩失败 | ERROR " + e);
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
