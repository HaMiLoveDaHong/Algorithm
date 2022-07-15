package com.zhw.algorithm.designPtternts.okhttp;

import com.zhw.algorithm.designPtternts.okhttp.vo.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class OkClient {
    //创建一个集合来存储拦截器
    private ArrayList<Interceptor> interceptors = new ArrayList<>();

    public OkClient (Builder builder){
        this.interceptors = builder.interceptors;
    }

    public List<Interceptor> interceptors(){
        return this.interceptors;
    }

    //创建发起请求方法
    public RealCall newCall(Request request){
        return new RealCall(this,request);
    }

    public static class Builder{

        private ArrayList<Interceptor> interceptors = new ArrayList<>();

        public Builder addInterceptor(Interceptor interceptor){
            interceptors.add(interceptor);
            return this;
        }

        public OkClient build(){
            return new OkClient(this);
        }
    }
}
