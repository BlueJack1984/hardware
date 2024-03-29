package com.example.business.bip.impl;

import com.example.business.base.BaseServiceImpl;
import com.example.business.bip.ICommonBipService;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.carry.base.CommandParameter;
import com.example.entity.table.DeviceInitRec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CommonBipServiceImpl extends BaseServiceImpl implements ICommonBipService {


    @Override
    public Boolean validateDeviceInitRecord(List<DeviceInitRec> deviceInitRecList) {
        return null;
    }

    @Override
    public DownloadBaseModel pushCommandSwitchGlobalStatus(String imei) {
        return null;
    }

    @Override
    public CommandParameter getPrimaryNumberInformation(String imei) {
        return null;
    }

    @Override
    public CommandParameter getSharedPrimaryNumberInformation(String imei) {
        return null;
    }

    @Override
    public CommandParameter getLocalNumberInformation(String imei) {
        return null;
    }
}
