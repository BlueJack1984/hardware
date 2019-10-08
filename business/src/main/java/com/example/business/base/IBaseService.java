package com.example.business.base;

/**
 * 最基础服务
 * @author lushusheng
 * @date 2019-09-25
 * @description
 */
public interface IBaseService {

    /**
     * 基础服务，bip，ussd，lu都会用到
     */
    String getMccByLocationInformation(String locationInformation);

    /**
     * 获取当次流水号
     */
    String getOtaTradeNumber();
    /**
     * 校验位置上报的mcc参数是否符合要求
     */
    Boolean checkPositionUpdateMccIsFFF(String mcc);
}
