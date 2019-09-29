package com.example.business.lu;

import com.example.entity.io.response.DownloadMessageCarrier;

import java.util.List;

public interface IOldProtocolLuService {

    List<DownloadMessageCarrier> handleLuDetailedBusiness(String sharedImsi, String mcc);
}
