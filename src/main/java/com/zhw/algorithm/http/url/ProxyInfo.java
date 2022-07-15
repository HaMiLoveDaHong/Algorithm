package com.zhw.algorithm.http.url;

import java.io.Serializable;

/**
 * @author zhanghongwei
 * @sice 2022/7/6
 **/
public class ProxyInfo implements Serializable {

    /**
     * 类名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数值
     */
    private String[] paramValues;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(String[] paramValues) {
        this.paramValues = paramValues;
    }
}
