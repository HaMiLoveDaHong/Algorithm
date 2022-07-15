package com.zhw.algorithm.designPtternts.okhttp.impl;

import com.zhw.algorithm.designPtternts.okhttp.Interceptor;
import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;
import com.zhw.algorithm.util.StringUtilsDefine;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class CallServerInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
        System.out.println("CallServerInterceptor: " + request.toString());
        // 如果请求头，请求类型，请求体都不为空，则发起网络请求，返回结果
        if (!StringUtilsDefine.isEmpty(request.getHeader()) && !StringUtilsDefine.isEmpty(request.getMediaType())
                && !StringUtilsDefine.isEmpty(request.getBody())) {
            // 发起网络请求，返回结果
            Response response = new Response();
            response.setCallServerInterceptor("CallServerInterceptor");
            return response;
        }
        return null;
    }
}
