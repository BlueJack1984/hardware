package com.example.business.ussd.impl;

import com.example.business.ussd.ICommonUssdService;
import com.example.business.ussd.IOldProtocolUssdService;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OldProtocolUssdServiceImpl implements IOldProtocolUssdService {

    private final ICommonUssdService commonUssdService;

    @Override
    public DownloadBaseModel handleUssdDetailedBusiness(UploadBaseModel uploadBaseModel) {
        return null;
    }
}
