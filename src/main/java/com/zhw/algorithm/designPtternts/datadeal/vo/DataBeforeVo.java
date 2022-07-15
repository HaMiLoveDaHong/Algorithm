package com.zhw.algorithm.designPtternts.datadeal.vo;

/**
 * @author zhanghongwei
 * @sice 2022/7/5
 **/
public class DataBeforeVo {

    public static class StatusConst{
        public static final String ONE ="1";
        public static final String TWO = "2";
        public static final String THREE = "3";
    }

    /**
     * 状态字段：1（Interger） 2(String) 3(Long)
     */
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
