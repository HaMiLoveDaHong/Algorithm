package com.zhw.algorithm.designPtternts.datadeal.service.impl;

import com.zhw.algorithm.designPtternts.datadeal.service.DataDealService;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataAfterVo;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataBeforeVo;

import java.util.List;

/**
 * @author zhanghongwei
 * @sice 2022/7/5
 **/
public class DataDealServiceChain implements DataDealService.DataDealChain {
    private int index;
    private DataBeforeVo beforeVo;
    private List<DataDealService>  dealServices;

    public DataDealServiceChain(int index,DataBeforeVo beforeVo, List<DataDealService> dealServices) {
        this.index = index;
        this.beforeVo = beforeVo;
        this.dealServices = dealServices;
    }

    @Override
    public DataBeforeVo beforeVo() {
        return this.beforeVo;
    }

    @Override
    public DataAfterVo proceed(DataBeforeVo beforeVo) {
        if (index >= this.dealServices.size()) throw new Error("当前索引与业务执行器长度不配");
        DataDealServiceChain chain = new DataDealServiceChain(index+1,beforeVo,this.dealServices);
        DataDealService dataDealService = this.dealServices.get(index);
        return dataDealService.interceptor(chain);
    }
}
