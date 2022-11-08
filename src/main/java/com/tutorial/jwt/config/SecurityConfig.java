package com.tutorial.jwt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정한다.
                .antMatchers("/api/hello").permitAll()
                .anyRequest().authenticated(); // permitAll이 아닌 나머지 요청들은 모두 인증되어야 한다.

        return httpSecurity.build();
    }

}
