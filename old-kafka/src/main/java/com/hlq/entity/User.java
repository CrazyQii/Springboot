package com.hlq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: User
 * @description: 用户对象
 * @author: hanLinQi
 * @create: 2021-11-29 18:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}
