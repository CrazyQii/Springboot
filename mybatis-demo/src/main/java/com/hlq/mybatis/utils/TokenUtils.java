package com.hlq.mybatis.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用token验证用户登录
 */
@Component
public class TokenUtils {
    // 设置过期时间
    private static final long EXPIRE_TIME = 1000 * 60;

    // 设置密钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";

    /**
     * 生成 token
     * @param id
     * @return
     */
    public String token (Long id) {
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
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public Long verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("id").asLong();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
