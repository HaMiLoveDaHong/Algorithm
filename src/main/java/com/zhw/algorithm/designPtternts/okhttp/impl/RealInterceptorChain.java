package com.zhw.algorithm.designPtternts.okhttp.impl;

import com.zhw.algorithm.designPtternts.okhttp.Interceptor;
import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;

import java.util.List;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class RealInterceptorChain implements Interceptor.Chain {
    private int index;
    private List<Interceptor> interceptors;
    private Request request;

    public RealInterceptorChain(int index, List<Interceptor> interceptors, Request request) {
        this.index = index;
        this.interceptors = interceptors;
        this.request = request;
    }

    @Override
    public Request request() {
        return this.request;
    }

    @Override
    public Response proceed(Request request) {
        if (index >= interceptors.size()) throw  new Error("当前索引和拦截器长度不配");
        //得到下一个责任拦截器，将index+1
        RealInterceptorChain next = new RealInterceptorChain(index+1,interceptors,request);
        //获取当前拦截器
        Interceptor interceptor = interceptors.get(index);
        //执行拦截方法，并把下一个拦截器传递
        Response response = interceptor.intercept(next);
        return response;
    }
}
