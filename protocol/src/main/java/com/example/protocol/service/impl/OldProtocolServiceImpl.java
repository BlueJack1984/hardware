package com.example.protocol.service.impl;

import com.example.business.autoapn.IOldProtocolAutoapnService;
import com.example.business.bip.IOldProtocolBipService;
import com.example.business.lu.IOldProtocolLuService;
import com.example.business.ussd.IOldProtocolUssdService;
import com.example.entity.io.response.DownloadMessageCarrier;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.pack.service.IOldProtocolPackService;
import com.example.protocol.service.IOldProtocolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OldProtocolServiceImpl implements IOldProtocolService {

    private final IOldProtocolPackService oldProtocolPackService;
    private final IOldProtocolBipService oldProtocolBipService;
    private final IOldProtocolLuService oldProtocolLuService;
    private final IOldProtocolUssdService oldProtocolUssdService;
    private final IOldProtocolAutoapnService oldProtocolAutoapnService;

    @Override
    public String handleBipOldProtocolBusiness(String message) {

        UploadBaseModel uploadBaseModel = oldProtocolPackService.unpack(message);
        //进行业务处理
        DownloadBaseModel downloadBaseModel = oldProtocolBipService.handleBipDetailedBusiness(uploadBaseModel);
        if(null == downloadBaseModel) {
            log.info("bip旧协议业务处理后得到的下行实体数据为：null，无法进行数据打包下发！");
            return null;
        }
        //下行数据实体打包
        String downMessage = oldProtocolPackService.pack(downloadBaseModel);
        return downMessage;
    }

    @Override
    public List<DownloadMessageCarrier> handleLuOldProtocolBusiness(String sharedImsi, String mcc) {
        //进行业务处理
        List<DownloadMessageCarrier> carrierList = oldProtocolLuService.handleLuDetailedBusiness(sharedImsi, mcc);
        if(null == carrierList || carrierList.size() < 1) {
            log.info("lu旧协议业务处理后得到的下行实体数据为：null，无法进行数据打包下发！");
            return null;
        }
        //下行数据实体打包
        for(int i = 0; i < carrierList.size(); i ++) {
            DownloadMessageCarrier carrier = carrierList.get(i);
            //打包加密
            String downMessage = oldProtocolPackService.pack(carrier.getDownloadBaseModel());
            carrier.setDownMessage(downMessage);
            carrier.setDownloadBaseModel(null);
        }
        //此处可以对返回的下行消息进行处理，或者存放到消息队列之中
        return carrierList;
    }

    @Override
    public String handleUssdOldProtocolBusiness(String message) {

        UploadBaseModel uploadBaseModel = oldProtocolPackService.unpack(message);
        //进行业务处理
        DownloadBaseModel downloadBaseModel = oldProtocolUssdService.handleUssdDetailedBusiness(uploadBaseModel);
        //下行数据实体打包
        String downMessage = oldProtocolPackService.pack(downloadBaseModel);
        return downMessage;
    }

    @Override
    public String handleAutoapnOldProtocolBusiness(String message) {

        //进行业务处理
        String downMessage = oldProtocolAutoapnService.handleUssdDetailedBusiness(message);
        return downMessage;
    }
}
