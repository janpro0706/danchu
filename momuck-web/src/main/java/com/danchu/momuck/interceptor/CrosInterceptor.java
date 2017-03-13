package com.danchu.momuck.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by geine on 2017. 3. 13..
 */
public class CrosInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(CrosInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        res.setHeader("Access-Control-Allow-Origin", "*");

        return super.preHandle(req, res, handler);

    }
}
