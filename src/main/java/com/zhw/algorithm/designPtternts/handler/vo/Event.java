package com.zhw.algorithm.designPtternts.handler.vo;

/**
 * 模式：责任链模式
 * 业务背景：
 * 需求描述：使用责任链模式实现员工假期审批流程，组长可以审批小于3天的假期，经理可以审批小于10天的假期，老板可以审批10天以上的假期。
 * 分析：使用面向对象的方式，在需求中假期是需要处理的业务，组长、经理和老板属于责任链中的处理节点。
 * 每个节点处理的时候如果满足要求则返回处理结果，如果不满足要求则转到下一个节点处理。
 *
 * 请假类Vo(Event)
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class Event {

    /**
     * 假期时间
     */
    private Integer date;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Event(Integer date) {
        this.date = date;
    }


}
