package com.example.protocol.service;

import com.example.entity.io.response.DownloadMessageCarrier;

import java.util.List;

/**
 *
 */
public interface IOldProtocolService {

    String handleBipOldProtocolBusiness(String message);

    List<DownloadMessageCarrier> handleLuOldProtocolBusiness(String sharedImsi, String mcc);

    String handleUssdOldProtocolBusiness(String message);

    String handleAutoapnOldProtocolBusiness(String message);
}
