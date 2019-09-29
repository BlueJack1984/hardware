package com.example.core.service.impl;

import com.example.core.dao.IAssetManageBusinessDao;
import com.example.core.service.IAssetManageBusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lushusheng
 * @date 2019-09-25
 * @description
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AssetManageBusinessServiceImpl implements IAssetManageBusinessService {

    private final IAssetManageBusinessDao assetManageBusinessDao;

    /**
     * 获取交易流水号，每次获取数据唯一
     * @return
     */
    @Override
    public String getOtaTradeNumber() {

        String tradeNumber = null;
        long currentValue = assetManageBusinessDao.hashCode();

        return tradeNumber;
    }
}
