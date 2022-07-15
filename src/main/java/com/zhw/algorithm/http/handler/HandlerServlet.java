package com.zhw.algorithm.http.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public interface HandlerServlet {

    void proceed(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
