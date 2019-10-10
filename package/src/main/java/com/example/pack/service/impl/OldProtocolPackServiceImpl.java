package com.example.pack.service.impl;

import com.example.constant.protocol.command.OldProtocolCommandTypeConstant;
import com.example.constant.protocol.decode.OldProtocolPositionConstant;
import com.example.entity.pack.OldProtocolPackSubject;
import com.example.entity.pack.OldProtocolUnpackSubject;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.entity.protocol.carry.base.CommandParameterContainer;
import com.example.entity.protocol.download.OldProtocolDownloadModel;
import com.example.entity.protocol.upload.old.OldProtocolUploadPorModel;
import com.example.entity.protocol.upload.old.OldProtocolUploadPositionModel;
import com.example.pack.service.ICommonPackService;
import com.example.pack.service.IOldProtocolPackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OldProtocolPackServiceImpl implements IOldProtocolPackService {

    private final ICommonPackService commonPackService;

    @Override
    public UploadBaseModel unpack(String message) {

        log.info("进入旧协议解码程序模块！解码信息为：" + message);
        message = commonPackService.handleMessageReadable(message);
        //将可读的字符串数据转换为实体
        UploadBaseModel uploadBaseModel = changeMessageToModel(message);
        return uploadBaseModel;
    }

    public UploadBaseModel changeMessageToModel(String message) {

        String commandType = message.substring(OldProtocolPositionConstant.COMMAND_TYPE_INDEX_START,
                OldProtocolPositionConstant.COMMAND_TYPE_INDEX_END);
        UploadBaseModel uploadBaseModel = null;
        if(OldProtocolCommandTypeConstant.POSITION_UPDATE_TYPE.equals(commandType)) {
            //旧协议位置上报
            log.info("进入旧协议位置上报模块！");
            uploadBaseModel = changeMessageToPositionModel(message);
        }else if(OldProtocolCommandTypeConstant.DOWNLOAD_LOCAL_DATA_TYPE.equals(commandType) ||
                OldProtocolCommandTypeConstant.LOCK_CARD_TYPE.equals(commandType) ||
                OldProtocolCommandTypeConstant.UPDATE_PRIMARY_ICCID_TYPE.equals(commandType) ||
                OldProtocolCommandTypeConstant.UPDATE_PRIMARY_PLMN_TYPE.equals(commandType) ||
                OldProtocolCommandTypeConstant.UPDATE_LOCAL_APN_AND_SCA_TYPE.equals(commandType) ||
                OldProtocolCommandTypeConstant.DOWNLOAD_TELECOM_DATA_TYPE.equals(commandType)) {
            //POR上报
            log.info("进入旧协议POR上报模块！");
            uploadBaseModel = changeMessageToPorModel(message);
        }else {
            log.info("根据指令类型参数commandType无法解析出上行实体！commandType为：" + commandType);
        }
        return uploadBaseModel;
    }

    public UploadBaseModel changeMessageToPositionModel(String message) {
        log.info("进入旧协议字符串数据转换为位置上报实体函数！");
        OldProtocolUploadPositionModel positionModel = new OldProtocolUploadPositionModel();
        //获取header属性内容
        //OldProtocolUploadHeader header = getHeader(message);
        //uploadModel.setHeader(header);
        //获取body

        return positionModel;
    }

    public void loadSharedProperties(String message) {
        //获取header属性内容
        //OldProtocolUploadHeader header = new OldProtocolUploadHeader();
        //UploadHeader commonHeader = commonPackService.obtainHeaderProperty(message);
        //BeanUtils.copyProperties(commonHeader, header);
        //此处可以对就协议header的自有属性进行处理
        return;
    }

    public UploadBaseModel changeMessageToPorModel(String message) {
        log.info("进入旧协议字符串数据转换为位置上报实体函数！");
        OldProtocolUploadPorModel porModel = new OldProtocolUploadPorModel();
        //获取header属性内容
        //OldProtocolUploadHeader header = getHeader(message);
        //uploadModel.setHeader(header);
        //获取body
        return porModel;
    }

    @Override
    public String pack(DownloadBaseModel downloadBaseModel) {

        StringBuffer downMessage = new StringBuffer("");
        OldProtocolDownloadModel model= (OldProtocolDownloadModel)downloadBaseModel;
        String businessType;
        String keyIndex;
        String checkNumber;
        String mac;
        //类型转换
        CommandParameterContainer commandParameterContainer = model.getCommandParameterContainer();

        return downMessage.toString();
    }

    @Override
    public OldProtocolUnpackSubject unpackService(String message) {

        UploadBaseModel uploadBaseModel = unpack(message);
        OldProtocolUnpackSubject oldProtocolUnpackSubject = null;
        return oldProtocolUnpackSubject;
    }

    @Override
    public String packService(OldProtocolPackSubject oldProtocolPackSubject) {
        //类型转换
        DownloadBaseModel downloadBaseModel = null;
        String downMessage = pack(downloadBaseModel);
        return downMessage;
    }
}
