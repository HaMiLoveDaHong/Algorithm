package com.zhw.algorithm.provicer.service.impl;

import com.zhw.algorithm.provicer.service.UserService;

/**
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public class UserServiceImpl implements UserService {

    @Override
    public String say(String userName) {
        return "hello,"+userName;
    }
}
