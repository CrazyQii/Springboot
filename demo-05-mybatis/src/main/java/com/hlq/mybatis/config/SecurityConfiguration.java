package com.hlq.mybatis.config;

import com.hlq.mybatis.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @program: SecurityConfiguration
 * @description:
 * @author: hanLinQi
 * @create: 2022-08-21 15:43
 **/
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationTokenFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        //关闭csrf
        .csrf().disable()
        //不通过Session获取SecurityContext
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        // 对于登录接口 允许匿名访问
        .antMatchers("/user/login").anonymous().antMatchers("/test").permitAll();
//        // 除上面外的所有请求全部需要鉴权认证
//        .anyRequest().authenticated();

        // 把token校验过滤器添加到过滤链中
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
