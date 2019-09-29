package com.example.protocol.service.impl;

import com.example.business.autoapn.INewProtocolAutoapnService;
import com.example.business.bip.INewProtocolBipService;
import com.example.business.lu.INewProtocolLuService;
import com.example.business.ussd.INewProtocolUssdService;
import com.example.core.service.IDeviceInitRecService;
import com.example.entity.io.response.DownloadMessageCarrier;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.pack.service.INewProtocolPackService;
import com.example.protocol.service.INewProtocolService;
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
public class NewProtocolServiceImpl implements INewProtocolService {

    private final INewProtocolPackService newProtocolPackService;
    private final INewProtocolBipService newProtocolBipService;
    private final INewProtocolLuService newProtocolLuService;
    private final INewProtocolAutoapnService newProtocolAutoapnService;
    private final INewProtocolUssdService newProtocolUssdService;

    @Override
    public String handleBipNewProtocolBusiness(String message) {

        UploadBaseModel uploadBaseModel = newProtocolPackService.unpack(message);
        //进行相应的业务处理
        DownloadBaseModel downloadBaseModel = newProtocolBipService.handleDetailedBusinessByCommandType(uploadBaseModel);
        if(null == downloadBaseModel) {
            log.info("有可能是POR或者下载副号为空!");
            return null;
        }
        log.info("对数据进行打包");
        //将下行报文实体进行打包
        String downMessage = newProtocolPackService.pack(downloadBaseModel);
        return downMessage;
    }


    @Override
    public List<DownloadMessageCarrier> handleLuNewProtocolBusiness(String sharedImsi, String mcc) {
        return null;
    }

    @Override
    public String handleUssdNewProtocolBusiness(String message) {
        return null;
    }

    @Override
    public String handleAutoapnNewProtocolBusiness(String message) {
        return null;
    }

}
