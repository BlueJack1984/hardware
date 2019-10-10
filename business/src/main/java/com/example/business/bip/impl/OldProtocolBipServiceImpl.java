package com.example.business.bip.impl;

import com.example.business.bip.ICommonBipService;
import com.example.business.bip.IOldProtocolBipService;
import com.example.constant.protocol.command.OldProtocolCommandTypeConstant;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.entity.protocol.carry.old.OldProtocolDownloadLocalDataCommandParameter;
import com.example.entity.protocol.upload.old.OldProtocolUploadPorModel;
import com.example.entity.protocol.upload.old.OldProtocolUploadPositionModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OldProtocolBipServiceImpl implements IOldProtocolBipService {

    private final ICommonBipService commonBipService;

    @Override
    public DownloadBaseModel handleBipDetailedBusiness(UploadBaseModel uploadBaseModel) {

        String commandType = uploadBaseModel.getCommandType();

        DownloadBaseModel downloadBaseModel = null;
        if(OldProtocolCommandTypeConstant.POSITION_UPDATE_BUSINESS_VALUE.equals(commandType)) {
            //旧协议位置上报
            log.info("进入旧协议位置上报业务处理模块！");
            OldProtocolUploadPositionModel positionModel = (OldProtocolUploadPositionModel)uploadBaseModel;
            downloadBaseModel = handlePositionUpdateBusiness(positionModel);
        }else if(OldProtocolCommandTypeConstant.DOWNLOAD_LOCAL_DATA_BUSINESS_VALUE.equals(commandType) ||
                OldProtocolCommandTypeConstant.LOCK_CARD_BUSINESS_VALUE.equals(commandType) ||
                OldProtocolCommandTypeConstant.UPDATE_PRIMARY_ICCID_BUSINESS_VALUE.equals(commandType) ||
                OldProtocolCommandTypeConstant.UPDATE_PRIMARY_PLMN_BUSINESS_VALUE.equals(commandType) ||
                OldProtocolCommandTypeConstant.UPDATE_LOCAL_APN_AND_SCA_BUSINESS_VALUE.equals(commandType) ||
                OldProtocolCommandTypeConstant.DOWNLOAD_TELECOM_DATA_BUSINESS_VALUE.equals(commandType)) {
            log.info("进入旧协议POR上报业务模块！");
            OldProtocolUploadPorModel porModel = (OldProtocolUploadPorModel)uploadBaseModel;
            handlePorUploadBusiness(porModel);
        }else if(OldProtocolCommandTypeConstant.PUSH_COMMAND_BUSINESS_VALUE.equals(commandType)) {
            log.info("进入旧协议push command业务模块！");
            //OldProtocolUploadPushCommandModel pushCommandModel = (OldProtocolUploadPushCommandModel)uploadBaseModel;
            //downloadBaseModel = handlePushCommandBusiness(pushCommandModel);
        }else if(OldProtocolCommandTypeConstant.PUSH_COMMAND_NEW_BUSINESS_VALUE.equals(commandType)) {
            log.info("进入旧协议push command new业务模块！");
            //OldProtocolUploadPushCommandNewModel pushCommandNewModel = (OldProtocolUploadPushCommandNewModel)uploadBaseModel;
            //downloadBaseModel = handlePushCommandNewBusiness(pushCommandNewModel);
        }else if(OldProtocolCommandTypeConstant.DOWNLOAD_GLOBAL_TELECOM_DATA_BUSINESS_VALUE.equals(commandType)) {
            log.info("进入旧协议download global telecom data业务模块！");
            //OldProtocolUploadGlobalTelecomDataModel globalTelecomDataModel = (OldProtocolUploadGlobalTelecomDataModel)uploadBaseModel;
            //downloadBaseModel = handleDownloadGlobalTelecomDataBusiness(globalTelecomDataModel);
        }else {
            log.info("旧协议解析的命令参数无法匹配，参数错误，值为：" + commandType);
        }
        return downloadBaseModel;
    }

    public DownloadBaseModel handlePositionUpdateBusiness(OldProtocolUploadPositionModel positionModel) {

        OldProtocolDownloadLocalDataCommandParameter oldProtocolDownloadModel = new OldProtocolDownloadLocalDataCommandParameter();

        return oldProtocolDownloadModel;
    }
    public void handlePorUploadBusiness(OldProtocolUploadPorModel porModel) {

    }
    public DownloadBaseModel handlePushCommandBusiness(OldProtocolUploadPushCommandModel pushCommandModel) {
        OldProtocolDownloadLocalDataCommandParameter oldProtocolDownloadModel = new OldProtocolDownloadLocalDataCommandParameter();
        return oldProtocolDownloadModel;
    }
    public DownloadBaseModel handlePushCommandNewBusiness(OldProtocolUploadPushCommandNewModel pushCommandNewModel) {
        OldProtocolDownloadLocalDataCommandParameter oldProtocolDownloadModel = new OldProtocolDownloadLocalDataCommandParameter();
        return oldProtocolDownloadModel;
    }
    public DownloadBaseModel handleDownloadGlobalTelecomDataBusiness(OldProtocolUploadGlobalTelecomDataModel globalTelecomDataModel) {
        OldProtocolDownloadLocalDataCommandParameter oldProtocolDownloadModel = new OldProtocolDownloadLocalDataCommandParameter();
        return oldProtocolDownloadModel;
    }

}
