package com.hlq.service;

import com.hlq.entity.FileInfoBase64;

/**
 * @program: OperateService
 * @author: hanLinQi
 * @create: 2021-11-24 16:50
 **/
public interface OperateService {

    /**
     * 用Base64格式保存文件信息
     * @param path 文件路径
     * @return base64值
     */
    String saveFileToBase64(String path);


    /**
     * 读取base64格式文件并保存到本地
     * @param fileInfoBase64 文件信息
     * @param path 文件存储路径
     */
    void readBase64File(FileInfoBase64 fileInfoBase64, String path);
}
