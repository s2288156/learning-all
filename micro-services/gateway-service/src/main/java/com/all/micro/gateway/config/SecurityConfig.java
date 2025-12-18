package com.all.micro.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Wu.Chunyang
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                // 关闭CSRF（API网关不需要CSRF保护）
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                // 配置请求授权规则
                .authorizeExchange(exchanges -> exchanges
                        // /api/**的请求需要认证（校验JWT Token有效）
                        .pathMatchers("/api/**").authenticated()
                        // 其他请求允许匿名访问
                        .anyExchange().permitAll()
                )
                // 启用OAuth2资源服务器，使用JWT校验
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {
                        }) // 采用默认的JWT校验逻辑
                );
        return http.build();
    }
}
