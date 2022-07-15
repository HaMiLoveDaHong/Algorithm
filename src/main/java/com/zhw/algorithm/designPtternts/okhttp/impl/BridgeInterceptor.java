package com.zhw.algorithm.designPtternts.okhttp.impl;

import com.zhw.algorithm.designPtternts.okhttp.Interceptor;
import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;
import com.zhw.algorithm.util.StringUtilsDefine;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class BridgeInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) {
        // 处理请求
        Request request = chain.request();
        String mediaType = request.getMediaType();
        // 在该拦截器中设置MediaType
        if (StringUtilsDefine.isEmpty(mediaType)) {
            request.setMediaType("BridgeInterceptor");
        }
        // 处理响应结果
        Response response = chain.proceed(request);
        // 给响应结果设置值
        if (StringUtilsDefine.isEmpty(response.getBridgeInterceptor())) {
            response.setBridgeInterceptor("BridgeInterceptor");
        }
        return response;
    }
}
