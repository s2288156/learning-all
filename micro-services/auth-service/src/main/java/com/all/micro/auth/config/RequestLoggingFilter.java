package com.all.micro.auth.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE) // 确保最先执行
public class RequestLoggingFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 只记录 API 请求（可选）
        if (!request.getRequestURI().startsWith("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        CachedBodyHttpServletRequest cachedRequest = new CachedBodyHttpServletRequest(request);

        StringBuilder sb = new StringBuilder();
        sb.append("\n=== REQUEST DEBUG INFO ===\n");
        sb.append("Method: ").append(request.getMethod()).append("\n");
        sb.append("URI: ").append(request.getRequestURI()).append("\n");
        sb.append("Query: ").append(request.getQueryString() == null ? "none" : request.getQueryString()).append("\n");

        sb.append("Headers:\n");
        request.getHeaderNames().asIterator().forEachRemaining(name -> {
            String value = "authorization".equalsIgnoreCase(name) ? "*****" : request.getHeader(name);
            sb.append("  ").append(name).append(": ").append(value).append("\n");
        });

        String body = new String(cachedRequest.getCachedBody(), StandardCharsets.UTF_8).trim();
        sb.append("Body: ").append(body.isEmpty() ? "(empty)" : body).append("\n");
        sb.append("=== END REQUEST ===\n");

        log.info(sb.toString());

        filterChain.doFilter(cachedRequest, response);
    }
}
