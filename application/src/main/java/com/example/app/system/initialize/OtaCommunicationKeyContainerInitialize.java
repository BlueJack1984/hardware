package com.example.app.system.initialize;

import com.example.entity.container.OtaCommunicationKeyContainer;
import com.example.entity.table.PlmnIndex;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lushusheng
 * @date 2019-10-10
 * @description 系统初始化准备数据
 */
@Component
@Order(1)
public class OtaCommunicationKeyContainerInitialize implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, String[]> otaCommunicationKeysMap = OtaCommunicationKeyContainer.COMMUNICATION_KEY_MAP;
        Map<String, String[]> mccBitMap = OtaCommunicationKeyContainer.MCC_BIT_MAP;
        Map<String, PlmnIndex> plmnIndexMap = OtaCommunicationKeyContainer.PLMN_INDEX_MAP;
        Map<String, String[]> persDataKeyMap = OtaCommunicationKeyContainer.PERS_DATA_KEY_MAP;
    }
}
