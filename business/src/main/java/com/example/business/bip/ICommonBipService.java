package com.example.business.bip;

import com.example.business.base.IBaseService;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.table.DeviceInitRec;

import java.util.List;

public interface ICommonBipService extends IBaseService {

    Boolean validateDeviceInitRecord(List<DeviceInitRec> deviceInitRecList);
    /**
     *
     */
    DownloadBaseModel pushCommandSwitchGlobalStatus(String imei);
}
