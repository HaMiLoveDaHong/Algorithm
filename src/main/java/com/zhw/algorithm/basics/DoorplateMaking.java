package com.zhw.algorithm.basics;

/**
 * 门牌制作
 * 小蓝要为一条街的住户制作门牌号。
 * 这条街一共有 2020 位住户，门牌号从 1 到 2020 编号。
 * 小蓝制作门牌的方法是先制作 0 到 9 这几个数字字符，最后根据需要将字符粘贴到门牌上，
 * 例如门牌 1017 需要依次粘贴字符 1、0、1、7，即需要 1 个字符 0，2 个字符 1，1 个字符 7
 * 请问要制作所有的 1 到 2020 号门牌，总共需要多少个字符 2？
 * @author zhanghongwei
 * @sice 2022/6/29
 **/
public class DoorplateMaking {

    public static int doorplateMakingCount(int index){
        int result=0;
        int exec=index;
        while (!(exec==0)){
            if (exec %10==2) result+=1;
            exec=exec/10;
        }
        return result;
    }

    public static int doorplateMakingCount2(int index){
        int result=0;
        String indexStr = String.valueOf(index);
        char[] chars = indexStr.toCharArray();
        char c2='2';
        for (char c:chars){
            if (c==c2){
                result+=1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int result =0;
        for (int i=1;i<=2020;i++){
            result =result+ doorplateMakingCount(i);
        }
        System.out.println(result);


        int result2 = 0;
        for (int i=1;i<=2020;i++){
            result2 =result2+ doorplateMakingCount2(i);
        }
        System.out.println(result2);

    }
}
