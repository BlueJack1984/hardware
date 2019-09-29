package com.example.business.lu;

import com.example.business.base.IBaseService;

import java.util.Map;
import java.util.Set;

public interface ICommonLuService extends IBaseService {

    Map<String, Object> handleLuManualInstructionBusiness(String sharedImsi, String mcc);

    /**
     * 获取LU的所有旅游卡的设备id（assetId或者iccid）
     */
    Set<String> getIccidSetBySharedImsi(String sharedImsi);
}