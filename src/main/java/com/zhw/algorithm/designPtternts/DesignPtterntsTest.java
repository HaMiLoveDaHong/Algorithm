package com.zhw.algorithm.designPtternts;

import com.zhw.algorithm.designPtternts.datadeal.service.DataDeal;
import com.zhw.algorithm.designPtternts.datadeal.service.impl.IntergerDataDealImpl;
import com.zhw.algorithm.designPtternts.datadeal.service.impl.LongDataDealImpl;
import com.zhw.algorithm.designPtternts.datadeal.service.impl.StringDataDealImpl;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataAfterVo;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataBeforeVo;
import com.zhw.algorithm.designPtternts.handler.EventHandler;
import com.zhw.algorithm.designPtternts.handler.HandlerChain;
import com.zhw.algorithm.designPtternts.handler.impl.BossEventHandler;
import com.zhw.algorithm.designPtternts.handler.impl.GroupEventHandler;
import com.zhw.algorithm.designPtternts.handler.impl.ManagerEventHandler;
import com.zhw.algorithm.designPtternts.handler.vo.Event;
import com.zhw.algorithm.designPtternts.okhttp.OkClient;
import com.zhw.algorithm.designPtternts.okhttp.impl.BridgeInterceptor;
import com.zhw.algorithm.designPtternts.okhttp.impl.CallServerInterceptor;
import com.zhw.algorithm.designPtternts.okhttp.impl.LogInterceptor;
import com.zhw.algorithm.designPtternts.okhttp.impl.NetworkInterceptor;
import com.zhw.algorithm.designPtternts.okhttp.vo.Request;
import com.zhw.algorithm.designPtternts.okhttp.vo.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class DesignPtterntsTest {

    public static void main(String[] ages){
        DataDeal dataDeal =new DataDeal.Builder()
                .addDataDealService(new IntergerDataDealImpl())
                .addDataDealService(new LongDataDealImpl())
                .addDataDealService(new StringDataDealImpl())
                .build();
        DataBeforeVo dataBeforeVo =new DataBeforeVo();
        dataBeforeVo.setStatus(DataBeforeVo.StatusConst.ONE);
        DataBeforeVo dataBeforeVo1 =new DataBeforeVo();
        dataBeforeVo1.setStatus(DataBeforeVo.StatusConst.TWO);
        DataBeforeVo dataBeforeVo2 =new DataBeforeVo();
        dataBeforeVo2.setStatus(DataBeforeVo.StatusConst.THREE);
        List<DataBeforeVo> dataBeforeVos = new ArrayList<>();
        dataBeforeVos.add(dataBeforeVo);
        dataBeforeVos.add(dataBeforeVo1);
        dataBeforeVos.add(dataBeforeVo2);

        for (DataBeforeVo before:dataBeforeVos){
            DataAfterVo dataAfterVo = dataDeal.execToDo(before);
        }



//        Event event = new Event(8);
//        EventHandler eventHandler =new HandlerChain.Builder()
//                .addEventHandler(new GroupEventHandler())
//                .addEventHandler(new ManagerEventHandler())
//                .addEventHandler(new BossEventHandler()).build();
//        eventHandler.proceed(event);
//
//
//        //okHttp
//        // 通过构造者模式来初始化OkHttpClient
//        OkClient client = new OkClient.Builder()
//                .addInterceptor(new BridgeInterceptor())
//                .addInterceptor(new NetworkInterceptor())
//                .addInterceptor(new LogInterceptor())
//                .addInterceptor(new CallServerInterceptor())
//                .build();
//        // 通过构造者模式来创建请求
//        Request request = new Request.Builder()
//                .url("http:123.com")
//                .build();
//        // 发起请求后得到执行结果
//        Response response = client.newCall(request).execute();
//        // 输出执行结果
//        System.out.println(response.toString());






    }
}
