package com.zhw.algorithm.designPtternts.handler.impl;

import com.zhw.algorithm.designPtternts.handler.EventHandler;
import com.zhw.algorithm.designPtternts.handler.vo.Event;

/**
 * 经理业务：经理可以审批小于10天的假期
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class ManagerEventHandler extends EventHandler {

    public ManagerEventHandler() {
    }

    public ManagerEventHandler(EventHandler eventHandler) {
        super(eventHandler);
    }

    @Override
    public void proceed(Event event) {
        if (event.getDate()>3&&event.getDate()<10){
            System.out.println("经理审批通过!");
        }else {
            System.out.println("经理权限不够,转到上级领导审批");
            this.getEventHandler().proceed(event);
        }
    }
}
