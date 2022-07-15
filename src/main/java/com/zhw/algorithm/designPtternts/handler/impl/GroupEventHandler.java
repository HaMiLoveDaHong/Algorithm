package com.zhw.algorithm.designPtternts.handler.impl;

import com.zhw.algorithm.designPtternts.handler.EventHandler;
import com.zhw.algorithm.designPtternts.handler.vo.Event;

/**
 * 组长处理假期业务:组长可以审批小于3天的假期
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class GroupEventHandler extends EventHandler {

    public GroupEventHandler() {
    }

    public GroupEventHandler(EventHandler eventHandler) {
        super(eventHandler);
    }

    @Override
    public void proceed(Event event) {
        if (event.getDate()>3){
            System.out.println("组长权限不够，转到上级领导审批");
            this.getEventHandler().proceed(event);
        }else {
            System.out.println("组长审批通过!");
        }
    }
}
