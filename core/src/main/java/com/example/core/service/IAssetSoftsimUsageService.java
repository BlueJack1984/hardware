package com.example.core.service;

import com.example.entity.table.AssetSoftsimUsage;

import java.util.List;

public interface IAssetSoftsimUsageService {

    List<AssetSoftsimUsage> getListByImsi(String sharedImsi);
}
