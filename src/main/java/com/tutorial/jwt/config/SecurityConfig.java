package com.tutorial.jwt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * jwt패키지에서 만들었던 5개의 클래스를 SecurityConfig에 추가할예정.
 *
 */
@EnableWebSecurity
public class SecurityConfig {

    /**
     * /h2-console/ 하위의 모든 요청과 파비콘, /error 에 관한 것은 모두 무시하는 것으로 설정.
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**"
                , "/favicon.ico"
                , "/error");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정한다.
                .antMatchers("/api/hello").permitAll()
                .anyRequest().authenticated(); // permitAll이 아닌 나머지 요청들은 모두 인증되어야 한다.

        return httpSecurity.build();
    }

}
