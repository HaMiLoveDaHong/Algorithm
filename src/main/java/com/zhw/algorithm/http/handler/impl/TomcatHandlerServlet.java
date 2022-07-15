package com.zhw.algorithm.http.handler.impl;

import com.sun.xml.internal.ws.util.StreamUtils;
import com.zhw.algorithm.http.handler.HandlerServlet;
import com.zhw.algorithm.http.url.ProxyInfo;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public class TomcatHandlerServlet implements HandlerServlet {

    @Override
    public void proceed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream servletInputStream = req.getInputStream();
        InputStream inputStream = StreamUtils.hasSomeData(servletInputStream);

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            Object o = objectInputStream.readObject();
            if (o instanceof ProxyInfo){
                ProxyInfo proxyInfo = (ProxyInfo)o;
                System.out.println("ProxyInfo 对象");
            }else {
                System.out.println("ProxyInfo 不是对象");
            }

            resp.getWriter().write("hello ,how are you!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
