package com.hlq.service.impl;

import com.hlq.entity.FileInfoBase64;
import com.hlq.service.OperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @program: OperateServiceImpl
 * @description: 文件操作
 * @author: hanLinQi
 * @create: 2021-11-24 16:50
 **/
@Service
public class OperateServiceImpl implements OperateService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OperateServiceImpl.class);

    @Override
    public String saveFileToBase64(String path) {
        InputStream in = null;
        try {
            //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
            byte[] data = null;
            //读取图片字节数组
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            // 返回Base64编码过的字节数组字符串
            return encoder.encode(data);
        } catch (IOException e) {
            LOGGER.error("保存Base64文件失败，ERROR | ", e);
            return "";
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    LOGGER.error("保存Base64文件失败， 文件流关闭异常 ERROR | ", e);
                }
            }
        }
    }

    @Override
    public void readBase64File(FileInfoBase64 fileInfoBase64, String path) {
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            byte[] bytes = decoder.decodeBuffer(fileInfoBase64.getFileContent());
            for (int i = 0; i < bytes.length; ++i)
            {
                if (bytes[i] < 0)
                {
                    //调整异常数据
                    bytes[i] += 256;
                }
            }
            //生成文件
            out = new FileOutputStream(path + fileInfoBase64.getFileName());
            out.write(bytes);
        } catch (IOException e) {
            LOGGER.error("BASE64文件保存失败， ERROR | " + e);
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                LOGGER.error("BASE64文件保存失败，文件流关闭异常 | ERROR " + e);
            }
        }
    }
}
