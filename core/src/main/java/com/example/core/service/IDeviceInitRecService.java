package com.example.core.service;

import com.example.entity.table.DeviceInitRec;

import java.util.List;

public interface IDeviceInitRecService {

    List<DeviceInitRec> getListByImei(String imei);
}
