package com.example.business.bip.impl;

import com.example.business.bip.ICommonBipService;
import com.example.business.bip.INewProtocolBipService;
import com.example.constant.protocol.command.NewProtocolCommandTypeConstant;
import com.example.core.service.IDeviceInitRecService;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.entity.protocol.upload.NewProtocolUploadPorModel;
import com.example.entity.protocol.upload.NewProtocolUploadPositionModel;
import com.example.entity.protocol.upload.NewProtocolUploadReceiveDataPorModel;
import com.example.entity.table.DeviceInitRec;
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
    private final IDeviceInitRecService deviceInitRecService;

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
        //首先判断设备的初始化数据
        String imei = positionModel.getImei();
        List<DeviceInitRec> deviceInitRecList = deviceInitRecService.getListByImei(imei);
        //验证设备初始化信息记录表
        Boolean deviceResult = bipCommonService.validateDeviceInitRecord(deviceInitRecList);
        if(false == deviceResult) {
            log.info("");
            return null;
        }
        String mcc = bipCommonService.getMccByLocationInformation(positionModel.getLocationInformation());
        Boolean mccResult = bipCommonService.checkPositionUpdateMccIsFFF(mcc);
        if(true == mccResult) {
            //这里的mcc判断为FFF，处理时间同步事件
            log.info("位置上报的mcc参数为FFF，此时进行同步时间参数功能处理！");
            handleUploadMccParameterFFFBusiness(positionModel);
            return null;
        }
        log.info("设备初始化数据和mcc参数均满足要求！");
        DeviceInitRec deviceInitRec = deviceInitRecList.get(0);
        if(true) {
            log.info("");
            DownloadBaseModel downloadBaseModel = bipCommonService.pushCommandSwitchGlobalStatus(imei);
            return downloadBaseModel;
        }

        String primaryIccid = positionModel.getPrimaryIccid();
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

    void handleUploadMccParameterFFFBusiness(NewProtocolUploadPositionModel positionModel) {

    }
}
