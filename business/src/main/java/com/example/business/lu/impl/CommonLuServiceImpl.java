package com.example.business.lu.impl;

import com.example.business.base.BaseServiceImpl;
import com.example.business.lu.ICommonLuService;
import com.example.constant.lu.LuManualInstructionConstant;
import com.example.core.service.IAssetSoftsimUsageService;
import com.example.core.service.ILuManualInstructionService;
import com.example.entity.io.response.DownloadMessageCarrier;
import com.example.entity.table.AssetSoftsimUsage;
import com.example.entity.table.LuManualInstruction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CommonLuServiceImpl extends BaseServiceImpl implements ICommonLuService {

    private final ILuManualInstructionService luManualInstructionService;
    private final IAssetSoftsimUsageService assetSoftsimUsageService;


    @Override
    public Map<String, Object> handleLuManualInstructionBusiness(String sharedImsi, String mcc) {

        Map<String, Object> map = new HashMap<>();
        List<DownloadMessageCarrier> downloadMessageCarrierList = new ArrayList<>();
        List<LuManualInstruction> instructionList = luManualInstructionService.getListAllActive();

        map.put(LuManualInstructionConstant.OPERATION_STATUS_KEY, true);
        map.put(LuManualInstructionConstant.OPERATION_RESULT_KEY, downloadMessageCarrierList);
        return map;
    }

    @Override
    public Set<String> getIccidSetBySharedImsi(String sharedImsi) {

        Set<String> iccidSet = new HashSet<>();
        List<AssetSoftsimUsage> usageList = assetSoftsimUsageService.getListByImsi(sharedImsi);
        if(null == usageList || usageList.size() < 1) {
            log.info("");
            return iccidSet;
        }
        log.info("查询到的设备码号使用信息不为空，可以进行后续操作！");
        for(AssetSoftsimUsage assetSoftsimUsage: usageList) {
            String iccid = assetSoftsimUsage.getAssetId();
            if(StringUtils.isEmpty(iccid)) {
                continue;
            }
            iccidSet.add(iccid);
        }
        return iccidSet;
    }
}
