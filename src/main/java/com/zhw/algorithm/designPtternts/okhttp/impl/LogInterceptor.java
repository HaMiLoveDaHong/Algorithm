package com.zhw.algorithm.designPtternts.okhttp.impl;

import com.zhw.algorithm.designPtternts.okhttp.Interceptor;
import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;
import com.zhw.algorithm.util.StringUtilsDefine;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
        // 在该拦截器中设置请求体
        if (StringUtilsDefine.isEmpty(request.getBody())) {
            request.setBody("LogInterceptor");
        }
        // 处理响应结果
        Response response = chain.proceed(request);
        // 给响应结果设置值
        if (StringUtilsDefine.isEmpty(response.getLogInterceptor())) {
            response.setLogInterceptor("LogInterceptor");
        }
        return response;
    }
}
