package com.fungo.comment.guice;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by fornia on 16/10/16.
 */
public class MyGuiceFilter extends GuiceFilter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filter(servletRequest,servletResponse,filterChain);
        super.doFilter(servletRequest,servletResponse,filterChain);
    }

    private void filter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        HttpServletRequest s = (HttpServletRequest)servletRequest;
        System.out.println(servletRequest.getParameterMap().toString());
        System.out.println(servletRequest.getLocalAddr());
        System.out.println(servletRequest.getRemoteAddr());
        System.out.println(s.getRequestURI());
        System.out.println("I'am Guice Filter");
    }
}
