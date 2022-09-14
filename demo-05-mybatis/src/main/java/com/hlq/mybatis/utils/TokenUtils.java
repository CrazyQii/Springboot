package com.hlq.mybatis.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hlq.mybatis.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用token验证用户登录
 */
@Component
public class TokenUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtils.class);

    // 设置过期时间
    private static final long EXPIRE_TIME = 1000 * 60 * 24;

    // 设置密钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";

    public static void main(String[] args) {
        Long id = 20L;
        User user = new User();
        user.setCode("123");
        user.setUsername("hlq");
        String stringUser = JSON.toJSONString(user);
//        String token = createToken(id);
        String token = createToken(id, stringUser);
        System.out.println(verify(token));
    }

    /**
     * 生成Token
     * @param id 用户id
     * @param subject 用户Json对象
     * @return token值
     */
    public static String createToken (Long id, String subject) {
        String token = "";
        try {
            // 过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("type", "JWT");
            header.put("alg", "HS256");
            // 生成签名
            token = JWT
                    .create()
                    .withHeader(header)
                    .withClaim("id", id)
                    .withSubject(subject)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            LOGGER.error("生成token失败, id:{} String:{} ERROR | {}", id, subject, e.getMessage());
        }
        return token;
    }

    /**
     * 生成 token
     * @param id 用户id
     * @return token值
     */
    public static String createToken (Long id) {
        String token = "";
        try {
            // 过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("type", "JWT");
            header.put("alg", "HS256");
            // 生成签名
            token = JWT
                    .create()
                    .withHeader(header)
                    .withClaim("id", id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            LOGGER.error("生成token失败, id:{} ,ERROR | {}", id, e.getMessage());
        }
        return token;
    }

    /**
     * 校验token
     * @param token 校验码
     * @return 解析的值，其中key包括（id或者sub）
     */
    public static Map<String, Claim> verify(String token) {
        Map<String, Claim> map = new HashMap<>(2);
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            map = new HashMap<>(jwt.getClaims());
        } catch (Exception e) {
            LOGGER.error("解析token失败, token {}, ERROR | {}", token, e.getMessage());
        }
        return map;
    }
}
