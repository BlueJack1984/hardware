package com.example.business.bip.impl;

import com.example.business.bip.ICommonBipService;
import com.example.business.bip.INewProtocolBipService;
import com.example.constant.protocol.NewProtocolCommandTypeConstant;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.entity.protocol.upload.NewProtocolUploadPorModel;
import com.example.entity.protocol.upload.NewProtocolUploadPositionModel;
import com.example.entity.protocol.upload.NewProtocolUploadReceiveDataPorModel;
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
public class NewProtocolBipServiceImpl implements INewProtocolBipService {

    private final ICommonBipService bipCommonService;

    @Override
    public DownloadBaseModel handleDetailedBusinessByCommandType(UploadBaseModel uploadBaseModel) {

        String commandType = uploadBaseModel.getCommandType();

        //设置返回实体
        DownloadBaseModel downloadBaseModel = null;
        if(NewProtocolCommandTypeConstant.POSITION_UPDATE_BUSINESS_VALUE.equals(commandType)) {
            //位置上报业务
            log.info("新协议位置上报业务！");
            NewProtocolUploadPositionModel positionModel = (NewProtocolUploadPositionModel)uploadBaseModel;
            downloadBaseModel = handlePositionUpdateBusiness(positionModel);
        }else if(NewProtocolCommandTypeConstant.DOWNLOAD_LOCAL_DATA_BUSINESS_VALUE.equals(commandType) ||
                NewProtocolCommandTypeConstant.DOWNLOAD_GLOBAL_DATA_BUSINESS_VALUE.equals(commandType) ||
                NewProtocolCommandTypeConstant.PUSH_COMMAND_BUSINESS_VALUE.equals(commandType)) {
            log.info("新协议POR上报业务！");
            NewProtocolUploadPorModel porModel = (NewProtocolUploadPorModel)uploadBaseModel;
            //处理POR业务
            handlePorUploadBusiness(porModel);
        }else if(NewProtocolCommandTypeConstant.RECEIVE_DATA_POR_BUSINESS_VALUE.equals(commandType)) {
            log.info("进入receive data por 处理模块，命令参数值为39！");
            NewProtocolUploadReceiveDataPorModel receiveDataPorModel = (NewProtocolUploadReceiveDataPorModel)uploadBaseModel;
            //处理receive data por业务
            handleReceiveDataPorBusiness(receiveDataPorModel);
        }else {
            log.info("无法解析新协议的命令参数值，commandType参数值为：" + commandType);
        }
        return downloadBaseModel;
    }

    public DownloadBaseModel handlePositionUpdateBusiness(NewProtocolUploadPositionModel positionModel) {

        String mcc = bipCommonService.getMccByLocationInformation(positionModel.getLocationInformation());
        //验证mcc
        Boolean mccResult = commonProtocolService.checkPositionUpdateMcc(mcc);
        String imei = body.getImei();
        List<DeviceInitRec> deviceInitRecList = deviceInitRecService.getListByImei(imei);
        //验证设备初始化信息记录表
        Boolean deviceResult = commonProtocolService.validateDeviceInitRecord(deviceInitRecList);
        if(false == mccResult || false == deviceResult) {
            log.info("");
            return null;
        }
        log.info("");
        DeviceInitRec deviceInitRec = deviceInitRecList.get(0);
        commonProtocolService.pushCommandSwitchGlobalStatus(imei);
        String primaryIccid = body.getImei();
        if(primaryIccid.equals(deviceInitRec)) {
            //种子主号
            //handle
        }else if(primaryIccid.equals(deviceInitRec)) {
            //主号状态
            //handle()
        }else {
            //慧银处理种子主号下载主号
            log.info("");
        }
        return null;
    }
    public void handlePorUploadBusiness(NewProtocolUploadPorModel porModel) {

        String commandType = porModel.getCommandType();
        if(NewProtocolCommandTypeConstant.DOWNLOAD_LOCAL_DATA_BUSINESS_VALUE.equals(commandType)) {
            log.info("");

        }else if(NewProtocolCommandTypeConstant.DOWNLOAD_GLOBAL_DATA_BUSINESS_VALUE.equals(commandType)) {
            log.info("");
        }else if(NewProtocolCommandTypeConstant.PUSH_COMMAND_BUSINESS_VALUE.equals(commandType)) {
            log.info("");
        }
        log.info("");
    }
    public void handleReceiveDataPorBusiness(NewProtocolUploadReceiveDataPorModel receiveDataPorModel) {

        log.info("");
    }
}
