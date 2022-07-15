package com.zhw.algorithm.designPtternts.handler.impl;

import com.zhw.algorithm.designPtternts.handler.EventHandler;
import com.zhw.algorithm.designPtternts.handler.vo.Event;

/**
 * 老板业务：老板审批小于10天的假期
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class BossEventHandler extends EventHandler {

    public BossEventHandler() {
    }

    public BossEventHandler(EventHandler eventHandler) {
        super(eventHandler);
    }

    @Override
    public void proceed(Event event) {
        if (event.getDate() > 10){
            System.out.println("老板审批通过");
        }else {
            System.out.println("老板审批不通过");
        }
    }
}
