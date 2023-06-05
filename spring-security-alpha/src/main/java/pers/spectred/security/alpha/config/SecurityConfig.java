package pers.spectred.security.alpha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                // 开启Basic认证
                // .httpBasic(Customizer.withDefaults())
                // 开启表单认证
                .formLogin(formLogin -> {
                    formLogin.loginPage("/login.html").loginProcessingUrl("/login");
                })
                // 所有请求都需要认证
                // .authorizeHttpRequests(authorizeHttpRequest -> authorizeHttpRequest.anyRequest().authenticated())
                // 放行登录页面
                .authorizeHttpRequests(authorizeHttpRequest -> authorizeHttpRequest.requestMatchers("/login.html").permitAll());
        return http.build();
    }
}
