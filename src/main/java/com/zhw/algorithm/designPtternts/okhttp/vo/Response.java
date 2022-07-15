package com.zhw.algorithm.designPtternts.okhttp.vo;

/**
 * Response类比较简单，返回所需要的打印信息
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class Response {
    private String bridgeInterceptor;
    private String logInterceptor;
    private String networkInterceptor;
    private String callServerInterceptor;

    public String getBridgeInterceptor() {
        return bridgeInterceptor;
    }

    public void setBridgeInterceptor(String bridgeInterceptor) {
        this.bridgeInterceptor = bridgeInterceptor;
    }

    public String getLogInterceptor() {
        return logInterceptor;
    }

    public void setLogInterceptor(String logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    public String getNetworkInterceptor() {
        return networkInterceptor;
    }

    public void setNetworkInterceptor(String networkInterceptor) {
        this.networkInterceptor = networkInterceptor;
    }

    public String getCallServerInterceptor() {
        return callServerInterceptor;
    }

    public void setCallServerInterceptor(String callServerInterceptor) {
        this.callServerInterceptor = callServerInterceptor;
    }

    @Override
    public String toString() {
        return "Response{" +
                "bridgeInterceptor='" + bridgeInterceptor + '\'' +
                ", logInterceptor='" + logInterceptor + '\'' +
                ", networkInterceptor='" + networkInterceptor + '\'' +
                ", callServerInterceptor='" + callServerInterceptor + '\'' +
                '}';
    }
}
