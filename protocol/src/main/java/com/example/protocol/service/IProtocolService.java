package com.example.protocol.service;

import com.example.entity.io.response.DownloadMessageCarrier;

import java.util.List;

/**
 *
 */
public interface IProtocolService {

    /**
     *
     */
    String handleBipCommonProtocol(String message);

    /**
     *
     */
    List<DownloadMessageCarrier> handleLuCommonProtocol(String sharedImsi, String mcc);

    /**
     *
     */
    String handleUssdCommonProtocol(String message);

    /**
     *
     */
    String handleAutoapnCommonProtocol(String message);

}
