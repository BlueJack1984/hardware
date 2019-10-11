package com.example.app.system.initialize;

import com.example.core.service.IManufacturerKeyService;
import com.example.core.service.IMccBitMapService;
import com.example.core.service.IPlmnIndexSerivce;
import com.example.entity.container.OtaCommunicationKeyContainer;
import com.example.entity.table.PlmnIndex;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class OtaCommunicationKeyContainerInitialize implements ApplicationRunner {

    private final IManufacturerKeyService manufacturerKeyService;
    private final IMccBitMapService mccBitMapService;
    private final IPlmnIndexSerivce plmnIndexSerivce;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Map<String, String[]> otaCommunicationKeyMap = OtaCommunicationKeyContainer.COMMUNICATION_KEY_MAP;
        loadOtaCommunicationKeyMap(otaCommunicationKeyMap);

        Map<String, String[]> mccBitMap = OtaCommunicationKeyContainer.MCC_BIT_MAP;
        loadMccBitMap(mccBitMap);

        Map<String, PlmnIndex> plmnIndexMap = OtaCommunicationKeyContainer.PLMN_INDEX_MAP;
        loadPlmnIndexMap(plmnIndexMap);

        Map<String, String[]> persDataKeyMap = OtaCommunicationKeyContainer.PERS_DATA_KEY_MAP;
        loadPersDataKeyMap(persDataKeyMap);
    }

    private void loadOtaCommunicationKeyMap(Map<String, String[]> otaCommunicationKeyMap) {

    }
    private void loadMccBitMap(Map<String, String[]> mccBitMap) {

    }
    private void loadPlmnIndexMap(Map<String, PlmnIndex> plmnIndexMap) {

    }
    private void loadPersDataKeyMap(Map<String, String[]> persDataKeyMap) {

    }
}
