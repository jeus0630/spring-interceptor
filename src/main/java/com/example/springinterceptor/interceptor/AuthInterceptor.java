package com.example.springinterceptor.interceptor;

import com.example.springinterceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).build().toUri();

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        return false;
    }

    private boolean checkAnnotation(Object handler, Class clazz){

        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(handlerMethod.getMethodAnnotation(clazz) != null || handlerMethod.getBeanType().getAnnotation(clazz) != null){
            return true;
        }

        return false;
    }
}
