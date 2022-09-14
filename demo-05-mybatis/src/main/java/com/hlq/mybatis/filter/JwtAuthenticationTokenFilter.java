package com.hlq.mybatis.filter;

import com.auth0.jwt.interfaces.Claim;
import com.hlq.mybatis.dto.res.LoginUser;
import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.mapper.UserMapper;
import com.hlq.mybatis.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @program: JwtAuthenticationTokenFilter
 * @description:
 * @author: hanLinQi
 * @create: 2022-09-05 14:38
 **/
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Resource
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 解析userId
        Long userId = -1L;
        try {
            Map<String, Claim> map = TokenUtils.verify(token);
            userId = map.get("id").asLong();
        } catch (Exception e) {
            LOGGER.error("token异常, EEROR | {}", e.getMessage());
        }

        // 从数据库中查找对应的用户信息（此处可以修改为从Redis缓存中查找对应的用户信息）
        User user = userMapper.findUserById(userId);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户登录过期");
        }
//        LoginUser loginUser = new LoginUser(user);
        // 将用户信息封装到Authenticate中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null);
        // 存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
