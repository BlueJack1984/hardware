package com.example.core.service.impl;

import com.example.core.service.IDeviceInitRecService;
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
public class DeviceInitRecServiceImpl implements IDeviceInitRecService {


    @Override
    public List<DeviceInitRec> getListByImei(String imei) {
        return null;
    }
}
