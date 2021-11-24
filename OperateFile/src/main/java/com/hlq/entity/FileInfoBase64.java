package com.hlq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @program: FileBase64
 * @description: base64格式的文件
 * @author: hanLinQi
 * @create: 2021-11-24 16:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoBase64 {
    private String fileName;
    private String fileContent;
}
