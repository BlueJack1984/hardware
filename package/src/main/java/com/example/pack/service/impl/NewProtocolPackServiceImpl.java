package com.example.pack.service.impl;

import com.example.constant.protocol.command.NewProtocolCommandTypeConstant;
import com.example.constant.protocol.decode.NewProtocolPorIndexConstant;
import com.example.constant.protocol.decode.NewProtocolPositionIndexConstant;
import com.example.constant.protocol.decode.NewProtocolReceiveDataPorIndexConstant;
import com.example.constant.protocol.decode.ProtocolIndexConstant;
import com.example.entity.container.OtaCommunicationKeyContainer;
import com.example.entity.pack.NewProtocolPackSubject;
import com.example.entity.pack.NewProtocolUnpackSubject;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.entity.protocol.carry.base.CommandParameterContainer;
import com.example.entity.protocol.download.NewProtocolDownloadModel;
import com.example.entity.protocol.upload.NewProtocolUploadPorModel;
import com.example.entity.protocol.upload.NewProtocolUploadPositionModel;
import com.example.entity.protocol.upload.NewProtocolUploadReceiveDataPorModel;
import com.example.pack.service.ICommonPackService;
import com.example.pack.service.INewProtocolPackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新协议的打包功能
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class NewProtocolPackServiceImpl implements INewProtocolPackService {

    private final ICommonPackService commonPackService;

    @Override
    public UploadBaseModel unpack(String message) {
        log.info("进入新协议解码程序模块！解码信息为：" + message);
        //处理转义字符
        message = commonPackService.handleMessageReadable(message);
        //将可处理的字符串数据转变为实体
        UploadBaseModel uploadBaseModel = changeMessageToModel(message);
        return uploadBaseModel;
    }

    public UploadBaseModel changeMessageToModel(String message) {

        String commandType = message.substring(NewProtocolPositionIndexConstant.COMMAND_TYPE_INDEX_START,
                NewProtocolPositionIndexConstant.COMMAND_TYPE_INDEX_END);
        UploadBaseModel uploadBaseModel = null;
        if(NewProtocolCommandTypeConstant.POSITION_UPDATE_TYPE.equals(commandType)) {
            //新协议位置上报
            log.info("进入新协议位置上报模块！");
            uploadBaseModel = changeMessageToPositionModel(message);
        }else if(NewProtocolCommandTypeConstant.DOWNLOAD_LOCAL_DATA_TYPE.equals(commandType) ||
                NewProtocolCommandTypeConstant.DOWNLOAD_GLOBAL_DATA_TYPE.equals(commandType) ||
                NewProtocolCommandTypeConstant.PUSH_COMMAND_TYPE.equals(commandType)) {
            //POR上报，包含三种情况:下载副号，下载主号以及push command
            log.info("进入新协议POR模块,下载副号，下载主号以及push command！");
            uploadBaseModel = changeMessageToPorModel(message);
        }else if(NewProtocolCommandTypeConstant.RECEIVE_DATA_POR_TYPE.equals(commandType)) {
            //RECEIVE DATA POR模块
            log.info("进入新协议RECEIVE DATA POR模块！");
            uploadBaseModel = changeMessageToReceiveDataPorModel(message);
        }else {
            log.info("解析得到的命令类型不满足解析条件，参数错误");
        }
        return uploadBaseModel;
    }

    public UploadBaseModel changeMessageToPositionModel(String message) {
        //这里转换为位置上报实体
        NewProtocolUploadPositionModel positionModel = new NewProtocolUploadPositionModel();
        //获取公共属性
        commonPackService.obtainSharedProperties(positionModel, message);
        //获取特有属性
        obtainPositionModelUniqueProperties(positionModel, message);
        return positionModel;
    }

    private void obtainPositionModelUniqueProperties(NewProtocolUploadPositionModel positionModel, String message) {
        log.info("进入位置上报解码特有属性模块！");
        String manufacturerFlag = message.substring(ProtocolIndexConstant.MANUFACTURER_FLAG_INDEX_START,
                ProtocolIndexConstant.MANUFACTURER_FLAG_INDEX_END);
        String[] keys = OtaCommunicationKeyContainer.COMMUNICATION_KEY_MAP.get(manufacturerFlag);
        String decodedText = "";
        if(true) {
            decodedText = null;
        }else if(false) {
            decodedText = null;
        }else {
            decodedText = null;
        }
        positionModel.setCheckNumber(decodedText.substring(NewProtocolPositionIndexConstant.CHECK_NUMBER_INDEX_START,
                NewProtocolPositionIndexConstant.CHECK_NUMBER_INDEX_END));
        positionModel.setLocationInformation(decodedText.substring(NewProtocolPositionIndexConstant.LOCATION_INFORMATION_INDEX_START,
                NewProtocolPositionIndexConstant.LOCATION_INFORMATION_INDEX_END));
        positionModel.setPrimaryIccid(decodedText.substring(NewProtocolPositionIndexConstant.PRIMARY_ICCID_INDEX_START,
                NewProtocolPositionIndexConstant.PRIMARY_ICCID_INDEX_END));
        positionModel.setCarryingCapacity(decodedText.substring(NewProtocolPositionIndexConstant.CARRYING_CAPACITY_INDEX_START,
                NewProtocolPositionIndexConstant.CARRYING_CAPACITY_INDEX_END));
        positionModel.setImei(decodedText.substring(NewProtocolPositionIndexConstant.IMEI_INDEX_START,
                NewProtocolPositionIndexConstant.IMEI_INDEX_END));
        positionModel.setImsi(decodedText.substring(NewProtocolPositionIndexConstant.IMSI_INDEX_START,
                NewProtocolPositionIndexConstant.IMSI_INDEX_END));
        positionModel.setBipImsi(decodedText.substring(NewProtocolPositionIndexConstant.BIP_IMSI_INDEX_START,
                NewProtocolPositionIndexConstant.BIP_IMSI_INDEX_END));
        positionModel.setCellId(decodedText.substring(NewProtocolPositionIndexConstant.BIP_CELLID_INDEX_START,
                NewProtocolPositionIndexConstant.BIP_CELLID_INDEX_END));
        positionModel.setLatestOtaTradeNumber(decodedText.substring(NewProtocolPositionIndexConstant.LATEST_OTA_TRADE_NUMBER_INDEX_START,
                NewProtocolPositionIndexConstant.LATEST_OTA_TRADE_NUMBER_INDEX_END));
    }

    public UploadBaseModel changeMessageToPorModel(String message) {
        //这里转换为POR实体
        NewProtocolUploadPorModel porModel = new NewProtocolUploadPorModel();
        //获取公共属性
        commonPackService.obtainSharedProperties(porModel, message);
        //获取特有属性
        String otaTradeNumber = message.substring(NewProtocolPorIndexConstant.OTA_TRADE_NUMBER_INDEX_START,
                NewProtocolPorIndexConstant.OTA_TRADE_NUMBER_INDEX_END);
        porModel.setOtaTradeNumber(otaTradeNumber);
        String imei = message.substring(NewProtocolPorIndexConstant.IMEI_INDEX_START,
                NewProtocolPorIndexConstant.IMEI_INDEX_END);
        porModel.setImei(imei);
        //obtainPorModelUniqueProperties(porModel, message);
        return porModel;
    }

    public UploadBaseModel changeMessageToReceiveDataPorModel(String message) {
        //这里转换为Receive data por实体
        NewProtocolUploadReceiveDataPorModel receiveDataPorModel = new NewProtocolUploadReceiveDataPorModel();
        //获取公共属性
        commonPackService.obtainSharedProperties(receiveDataPorModel, message);
        //获取特有属性
        String iccid = message.substring(NewProtocolReceiveDataPorIndexConstant.ICCID_INDEX_START,
                NewProtocolReceiveDataPorIndexConstant.ICCID_INDEX_END);
        receiveDataPorModel.setIccid(iccid);
        String imei = message.substring(NewProtocolReceiveDataPorIndexConstant.IMEI_INDEX_START,
                NewProtocolReceiveDataPorIndexConstant.IMEI_INDEX_END);
        receiveDataPorModel.setImei(imei);
        String batchNumber = message.substring(NewProtocolReceiveDataPorIndexConstant.BATCH_NUMBER_INDEX_START,
                NewProtocolReceiveDataPorIndexConstant.BATCH_NUMBER_INDEX_END);
        receiveDataPorModel.setBatchNumber(batchNumber);
        String requestMessageBitMap = message.substring(NewProtocolReceiveDataPorIndexConstant.REQUEST_MESSAGE_BIT_MAP_INDEX_START,
                NewProtocolReceiveDataPorIndexConstant.REQUEST_MESSAGE_BIT_MAP_INDEX_END);
        receiveDataPorModel.setRequestMessageBitMap(requestMessageBitMap);
        //obtainReceiveDataPorModelUniqueProperties(receiveDataPorModel, message);
        return receiveDataPorModel;
    }

    @Override
    public String pack(DownloadBaseModel downloadBaseModel) {

        StringBuffer downMessage = new StringBuffer("");
        NewProtocolDownloadModel model = (NewProtocolDownloadModel)downloadBaseModel;
        //这里判断命令类型
        String batchNumber;
        String messageTotalNumber;
        String currentMessageIndex;
        String userDataLength;
        String businessType;
        String keyIndex;
        String checkNumber;
        String mac;
        //处理数据队列
        List<CommandParameterContainer> commandParameterContainerList = model.getCommandParameterContainerList();
        handleTailAnd(commandParameterContainerList);
        return downMessage.toString();
    }

    private void handleTailAnd(List<CommandParameterContainer> commandParameterContainerList) {

    }
    @Override
    public NewProtocolUnpackSubject unpackService(String message) {

        UploadBaseModel uploadBaseModel = unpack(message);
        //将uploadModel转换为通用实体
        NewProtocolUnpackSubject newProtocolUnpackSubject = null;
        //拷贝属性
        BeanUtils.copyProperties(newProtocolUnpackSubject, uploadBaseModel);
        return newProtocolUnpackSubject;
    }

    @Override
    public String packService(NewProtocolPackSubject newProtocolPackSubject) {

        //将通用实体转换为downModel
        DownloadBaseModel downloadBaseModel = null;
        String downMessage = pack(downloadBaseModel);
        return downMessage;
    }
}
