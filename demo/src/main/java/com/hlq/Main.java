package com.hlq;

/**
 * @program: Main
 * @description: 启动类
 * @author: hanLinQi
 * @create: 2021-12-08 17:58
 **/

public class Main {

    public static void main(String[] args) {
        String str = "abd";
        if (str.lastIndexOf('.') != -1) {
            String result = str.substring(0, str.lastIndexOf("."));
            System.out.println(result);
        }
//        System.out.println(str.lastIndexOf('.'));
//        String result = str.substring(0, str.lastIndexOf("."));
//        System.out.println(result);
    }
}
