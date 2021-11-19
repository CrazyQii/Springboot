package com.hlq.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author HanLq
 */
@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
}
