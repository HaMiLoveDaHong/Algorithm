package com.zhw.algorithm.basics;

/**
 * 切面条：
 * 一根高筋拉面，中间切一刀，可以得到2根面条。
 * 如果先对折1次，中间切一刀，可以得到3根面条。
 * 如果连续对折2次，中间切一刀，可以得到5根面条。
 * 那么，连续对折10次，中间切一刀，会得到多少面条呢？
 * @author zhanghongwei
 * @sice 2022/6/29
 **/
public class CutNoodles {


    /**
     * 由描述中得出：
     * 不对折，切：2=2
     * 对折1次，切：3=2+2^0
     * 对折2次，切：5=2+2^0+2^1
     * 对折3次，切：9=2+2^0+2^1+2^2
     * 由此所得：
     * 对折9次，切等于=2+2^0+2^1+2^2+...+2^8
     */
    public static int cutNoodlesByTimes(Integer times){
        Integer result=2,cutParam=1;
        for (int i=0;i<times;i++){
            result +=cutParam;
            cutParam = 2 * cutParam;
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(cutNoodlesByTimes(1));
        System.out.println(cutNoodlesByTimes(2));
        System.out.println(cutNoodlesByTimes(3));
        System.out.println(cutNoodlesByTimes(4));
        System.out.println(cutNoodlesByTimes(5));
        System.out.println(cutNoodlesByTimes(9));
        System.out.println(cutNoodlesByTimes(10));
    }
}
