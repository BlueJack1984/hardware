package com.example.core.service.impl;

import com.example.core.dao.IAssetSoftsimUsageDao;
import com.example.core.service.IAssetSoftsimUsageService;
import com.example.entity.table.AssetSoftsimUsage;
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
public class AssetSoftsimUsageServiceImpl implements IAssetSoftsimUsageService {

    private final IAssetSoftsimUsageDao assetSoftsimUsageDao;

    @Override
    public List<AssetSoftsimUsage> getListByImsi(String sharedImsi) {
        return null;
    }
}
