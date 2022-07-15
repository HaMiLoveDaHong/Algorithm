package com.zhw.algorithm.util;

import java.util.Objects;

/**
 * @author zhanghongwei
 * @sice 2022/7/1
 **/
public class StringUtilsDefine {


    public static boolean isEmpty(String str){
        if (Objects.isNull(str) || str.length()<=0){
            return true;
        }
        return false;
    }
}
