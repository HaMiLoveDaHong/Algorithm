package com.zhw.algorithm.http.impl;

import com.zhw.algorithm.http.handler.impl.TomcatHandlerServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public class TomcatHttpServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new TomcatHandlerServlet().proceed(req,resp);
    }
}
