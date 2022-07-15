package com.zhw.algorithm.designPtternts.datadeal.service;

import com.zhw.algorithm.designPtternts.datadeal.vo.DataAfterVo;
import com.zhw.algorithm.designPtternts.datadeal.vo.DataBeforeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghongwei
 * @sice 2022/7/5
 **/
public class DataDeal {
    /**
     * 处理业务
     */
    private List<DataDealService> dealServices = new ArrayList<>();

    public DataDeal(List<DataDealService> dealServices) {
        this.dealServices = dealServices;
    }

    public List<DataDealService> getDealServices() {
        return dealServices;
    }

    public void setDealServices(List<DataDealService> dealServices) {
        this.dealServices = dealServices;
    }

    public DataAfterVo execToDo(DataBeforeVo beforeVo){
        return new DataDealExec(beforeVo,this).exec();
    }

    public static class Builder{
        private List<DataDealService> dealServices = new ArrayList<>();

        public Builder addDataDealService(DataDealService dataDealService){
            this.dealServices.add(dataDealService);
            return this;
        }

        public DataDeal build(){
            return new DataDeal(this.dealServices);
        }
    }
}
