package org.example.course.core.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
@Slf4j
public class RequestLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StringBuilder logMessage = new StringBuilder("\n");
        logMessage.append("=========================== Incoming Request ===========================\n");
        logMessage.append("DateTime: ").append(LocalDateTime.now()).append("\n");
        logMessage.append("Method: ").append(request.getMethod()).append("\n");
        logMessage.append("URI: ").append(request.getRequestURI()).append("\n");
        logMessage.append("Query Parameters: ").append(request.getQueryString()).append("\n");
        logMessage.append("Headers: \n");

        Collections.list(request.getHeaderNames()).forEach(headerName ->
                logMessage.append("\t").append(headerName).append(": ")
                        .append(request.getHeader(headerName)).append("\n")
        );

        log.info(logMessage.toString());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        StringBuilder logMessage = new StringBuilder("\n");
        logMessage.append("=========================== Outgoing Response ===========================\n");
        logMessage.append("DateTime: ").append(LocalDateTime.now()).append("\n");
        logMessage.append("Status: ").append(response.getStatus()).append("\n");

        Long startTime = (Long) request.getAttribute("startTime");
        long executionTime = System.currentTimeMillis() - startTime;
        logMessage.append("Execution Time: ").append(executionTime).append("ms\n");

        log.info(logMessage.toString());
    }
}