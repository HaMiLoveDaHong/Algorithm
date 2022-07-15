package com.zhw.algorithm.designPtternts.datadeal.vo;

/**
 * @author zhanghongwei
 * @sice 2022/7/4
 **/
public class DataAfterVo {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataAfterVo(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DataAfterVo{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
