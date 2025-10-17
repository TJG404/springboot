package com.springboot.shoppy_fullstack_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity // Spring Security 활성화, dependencies  추가
public class SecurityConfig {
    // 1. 비밀번호 암호화 설정 (PasswordEncoder)
    // Spring Security는 반드시 비밀번호를 암호화하여 저장하고 비교해야 함!!
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
