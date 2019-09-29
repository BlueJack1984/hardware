package com.example.protocol.service.impl;

import com.example.constant.protocol.ProtocolVersionConstant;
import com.example.entity.io.response.DownloadMessageCarrier;
import com.example.protocol.service.INewProtocolService;
import com.example.protocol.service.IOldProtocolService;
import com.example.protocol.service.IProtocolService;
import com.example.util.protocol.ProtocolUtil;
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
public class ProtocolServiceImpl implements IProtocolService {

    private final INewProtocolService newProtocolService;
    private final IOldProtocolService oldProtocolService;

    /**
     * BIP服务
     * @param message
     * @return
     */
    @Override
    public String handleBipCommonProtocol(String message) {

        String downMessage = "";
        String protocolVersion = ProtocolUtil.getProtocolVersion(message);
        if(ProtocolVersionConstant.NEW_PROTOCOL_VERSION.equals(protocolVersion)) {
            log.info("进入新协议bip上报处理模块！");
            downMessage = newProtocolService.handleBipNewProtocolBusiness(message);
        }else if(ProtocolVersionConstant.OLD_PROTOCOL_VERSION.equals(protocolVersion)) {
            log.info("进入旧协议bip上报处理模块！");
            downMessage = oldProtocolService.handleBipOldProtocolBusiness(message);
        }else {
            log.info("对上报信息进行解码，解码后得到的协议版本号参数错误，具体为：" + protocolVersion);
        }
        return downMessage;
    }

    /**
     * LU服务
     * @param sharedImsi
     * @param mcc
     * @return
     */
    @Override
    public List<DownloadMessageCarrier> handleLuCommonProtocol(String sharedImsi, String mcc) {

        //此处区分新旧版本协议
        Boolean isNewProtocolVersion = false;
        List<DownloadMessageCarrier> downloadMessageCarrierList = null;
        if(isNewProtocolVersion) {
            downloadMessageCarrierList = newProtocolService.handleLuNewProtocolBusiness(sharedImsi, mcc);
        }else {
            downloadMessageCarrierList = oldProtocolService.handleLuOldProtocolBusiness(sharedImsi, mcc);
        }
        return downloadMessageCarrierList;
    }

    /**
     * USSD服务
     * @param message
     * @return
     */
    @Override
    public String handleUssdCommonProtocol(String message) {

        String downMessage = "";
        String protocolVersion = ProtocolUtil.getProtocolVersion(message);
        if(ProtocolVersionConstant.NEW_PROTOCOL_VERSION.equals(protocolVersion)) {
            log.info("进入新协议ussd上报处理模块！");
            downMessage = newProtocolService.handleUssdNewProtocolBusiness(message);
        }else if(ProtocolVersionConstant.OLD_PROTOCOL_VERSION.equals(protocolVersion)) {
            log.info("进入旧协议ussd上报处理模块！");
            downMessage = oldProtocolService.handleUssdOldProtocolBusiness(message);
        }else {
            log.info("对上报信息进行解码，解码后得到的协议版本号参数错误，具体为：" + protocolVersion);
        }
        return downMessage;
    }

    /**
     * AUTOAPN服务
     * @param message
     * @return
     */
    @Override
    public String handleAutoapnCommonProtocol(String message) {

        //此处区分新旧版本协议
        Boolean isNewProtocolVersion = false;
        String downMessage = null;
        if(isNewProtocolVersion) {
            downMessage = newProtocolService.handleAutoapnNewProtocolBusiness(message);
        }else {
            downMessage = oldProtocolService.handleAutoapnOldProtocolBusiness(message);
        }
        return downMessage;
    }
}
