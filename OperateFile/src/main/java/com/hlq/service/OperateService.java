package com.hlq.service;

import com.hlq.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: OperateService
 * @author: hanLinQi
 * @create: 2021-11-24 16:50
 **/
public interface OperateService {

    /**
     * 获取文件的Base64
     * @param path 文件路径
     * @return base64值
     */
    String convertFileToBase64(String path);


    /**
     * 将Base64转存为文件
     * @param fileInfo 文件信息
     * @param path 文件存储路径
     */
    void convertBase64ToFile(FileInfo fileInfo, String path);

    /**
     * 保存文件
     * @param multipartFiles 批量文件信息
     * @param path 文件存储路径
     */
    void saveFileByByte(MultipartFile[] multipartFiles, String path);

    /**
     * 保存文件
     * @param multipartFile 文件信息
     * @param path 文件存储路径
     */
    void saveFileByByte(MultipartFile multipartFile, String path);
}
