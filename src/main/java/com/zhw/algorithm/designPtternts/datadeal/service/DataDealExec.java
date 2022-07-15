package com.zhw.algorithm.designPtternts.datadeal.service;

import com.zhw.algorithm.designPtternts.datadeal.service.impl.DataDealServiceChain;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataAfterVo;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataBeforeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghongwei
 * @sice 2022/7/5
 **/
public class DataDealExec {

    private DataBeforeVo beforeVo;

    private DataDeal  dataDeal;


    public DataDealExec(DataBeforeVo beforeVo, DataDeal dataDeal) {
        this.beforeVo = beforeVo;
        this.dataDeal = dataDeal;
    }

    public DataAfterVo getDataAfterVoWithDoDataDealService(){
        List<DataDealService> dealServices = new ArrayList<>();
        dealServices.addAll(this.dataDeal.getDealServices());
        DataDealService.DataDealChain chain = new DataDealServiceChain(0,this.beforeVo,dealServices);
        return chain.proceed(this.beforeVo);
    }

    public DataAfterVo exec(){
        return this.getDataAfterVoWithDoDataDealService();
    }
}
