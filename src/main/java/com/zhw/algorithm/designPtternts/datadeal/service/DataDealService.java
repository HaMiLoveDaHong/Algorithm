package com.zhw.algorithm.designPtternts.datadeal.service;

import com.zhw.algorithm.designPtternts.datadeal.vo.DataAfterVo;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataBeforeVo;

/**
 * 数据处理服务
 * @author zhanghongwei
 * @sice 2022/7/4
 **/
public interface DataDealService {

    public DataAfterVo interceptor(DataDealChain chain);

    public interface DataDealChain{

        DataBeforeVo  beforeVo();

        DataAfterVo proceed(DataBeforeVo beforeVo);
    }
}
