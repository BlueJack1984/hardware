package com.example.business.base;

import com.example.core.service.IAssetManageBusinessService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lushusheng
 * @date 2019-09-25
 * @description 基础服务
 */
@Service
@Slf4j
//@RequiredArgsConstructor
public class BaseServiceImpl implements IBaseService{

    @Autowired
    private IAssetManageBusinessService assetManageBusinessService;

    /**
     * 从位置信息的多个数据中提取mcc参数
     * @param locationInformation
     * @return
     */
    @Override
    public String getMccByLocationInformation(String locationInformation) {

        if(StringUtils.isEmpty(locationInformation)) {
            log.info("需要处理的locationInformation参数为空，无法提取mcc参数！");
            return null;
        }
        String mcc = locationInformation.substring(0, 3);
        return mcc;
    }

    /**
     * 产生交易流水号，每次产生的号码均唯一
     * @return
     */
    @Override
    public String getOtaTradeNumber() {

        String tradeNumber = assetManageBusinessService.getOtaTradeNumber();
        return tradeNumber;
    }

    @Override
    public Boolean checkPositionUpdateMccIsFFF(String mcc) {
        return null;
    }

}
