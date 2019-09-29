package com.example.protocol.service;

import com.example.entity.io.response.DownloadMessageCarrier;

import java.util.List;

/**
 *
 */
public interface INewProtocolService {

    String handleBipNewProtocolBusiness(String message);

    List<DownloadMessageCarrier> handleLuNewProtocolBusiness(String sharedImsi, String mcc);

    String handleUssdNewProtocolBusiness(String message);

    String handleAutoapnNewProtocolBusiness(String message);
}
