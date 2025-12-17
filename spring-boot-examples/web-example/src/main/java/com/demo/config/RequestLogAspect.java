package com.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu.Chunyang
 */
@Slf4j
@Aspect
@Component
public class RequestLogAspect {
    @Pointcut("execution(* com.demo.controller..*(..))")
    public void requestLogPointcut() {}

    // 在方法执行前打印入参
    @Before("requestLogPointcut()")
    public void logRequestParams(JoinPoint joinPoint) {
        // 获取当前请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        // 获取请求URL和方法
        String url = request.getRequestURI();
        String method = request.getMethod();

        // 获取方法参数名和值
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = signature.getParameterNames();
        Object[] paramValues = joinPoint.getArgs();

        // 组装参数Map
        Map<String, Object> params = new HashMap<>();
        if (paramNames != null && paramNames.length > 0) {
            for (int i = 0; i < paramNames.length; i++) {
                // 避免敏感参数泄露，可在此处过滤（如密码）
                if ("password".equals(paramNames[i])) {
                    params.put(paramNames[i], "***");
                } else {
                    params.put(paramNames[i], paramValues[i]);
                }
            }
        }

        // 打印日志
        log.info("api request - URL: {}, method: {}, requestBody: {}", url, method, params);
    }
}
