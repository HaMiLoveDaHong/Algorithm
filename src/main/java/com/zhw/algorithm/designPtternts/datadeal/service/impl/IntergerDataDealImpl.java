package com.zhw.algorithm.designPtternts.datadeal.service.impl;

import com.zhw.algorithm.designPtternts.datadeal.service.DataDealService;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataAfterVo;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataBeforeVo;

/**
 * @author zhanghongwei
 * @sice 2022/7/5
 **/
public class IntergerDataDealImpl implements DataDealService {
    @Override
    public DataAfterVo interceptor(DataDealChain chain) {
        DataBeforeVo dataBeforeVo = chain.beforeVo();
        if (DataBeforeVo.StatusConst.ONE.equals(dataBeforeVo.getStatus())){
            System.out.println("执行 IntergerDataDealImpl 业务");
            return new DataAfterVo("执行 IntergerDataDealImpl 业务");
        }
        return chain.proceed(dataBeforeVo);
    }

}
