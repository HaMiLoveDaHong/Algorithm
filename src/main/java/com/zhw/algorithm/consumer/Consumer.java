package com.zhw.algorithm.consumer;

import com.zhw.algorithm.framework.Invocation;
import com.zhw.algorithm.framework.protocol.http.HttpClient;
import com.zhw.algorithm.http.url.ProxyInfo;
import com.zhw.algorithm.provicer.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;

import java.io.*;


/**
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public class Consumer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Invocation invocation = new Invocation(UserService.class.getName(),"say",new Object[]{"zhangfei"},new Class[]{String.class});
        HttpClient httpClient = new HttpClient();
        httpClient.send("localhost",8888,invocation);
    }
}
