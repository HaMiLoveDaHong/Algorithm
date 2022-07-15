package com.zhw.algorithm.designPtternts.okhttp;

import com.zhw.algorithm.designPtternts.okhttp.impl.RealInterceptorChain;
import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class RealCall {

    private OkClient okClient;

    private Request request;

    public RealCall(OkClient okClient, Request request) {
        this.okClient = okClient;
        this.request = request;
    }

    public Response getResponseWithInterceptorChain() {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.addAll(okClient.interceptors());
        Interceptor.Chain chain = new RealInterceptorChain(0, interceptors, this.request);
        return chain.proceed(request);
    }

    public Response execute(){
        Response response = this.getResponseWithInterceptorChain();
        return response;
    }
}
