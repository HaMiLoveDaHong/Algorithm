package com.zhw.algorithm.provicer;

import com.zhw.algorithm.framework.register.LocalRegister;
import com.zhw.algorithm.http.HttpServer;
import com.zhw.algorithm.provicer.service.UserService;
import com.zhw.algorithm.provicer.service.impl.UserServiceImpl;

/**
 * 手写 dobble 实现：生产者
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public class Provicer {

    public static void main(String[] args){
        //本地注册
        LocalRegister.register(UserService.class.getName(), UserServiceImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("provicer","","localhost",8888);

    }
}
