package com.zhw.algorithm.designPtternts.okhttp;

import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;

/**
 *
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public interface Interceptor {

    // 拦截处理响应
    Response intercept(Chain chain);

    // OkHttp责任链中不仅处理Request请求也处理Response请求
    public interface Chain{

        Request request();

        Response proceed(Request request);
    }
}
