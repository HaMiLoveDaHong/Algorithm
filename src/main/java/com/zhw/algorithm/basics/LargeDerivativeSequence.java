package com.zhw.algorithm.basics;

/**
 * 大衍数列
 * 中国古代文献中，曾记载过“大衍数列”, 主要用于解释中国传统文化中的太极衍生原理。
 * 它的前几项是：0、2、4、8、12、18、24、32、40、50 …
 * 其规律是：
 * 对偶数项，是序号平方再除2，
 * 奇数项，是序号平方减1再除2。
 * 以下的代码打印出了大衍数列的前 100 项。
 * @author zhanghongwei
 * @sice 2022/6/29
 **/
public class LargeDerivativeSequence {


    public static int largeDerivativeSequenceMethod(Integer index){
        Double result=0d;
        //对偶数项，是序号平方再除2
        if (index%2==0){
            result = (Math.pow(index,2))/2;
        }else {
            result = ((Math.pow(index,2))-1)/2;
        }
        return result.intValue();
    }


    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("");
        for (int i=1;i<=100;i++){
            sb.append(largeDerivativeSequenceMethod(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
