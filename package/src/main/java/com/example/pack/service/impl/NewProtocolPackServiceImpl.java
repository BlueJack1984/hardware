package com.example.pack.service.impl;

import com.example.constant.protocol.NewProtocolCommandTypeConstant;
import com.example.constant.protocol.NewProtocolParameterPositionConstant;
import com.example.entity.pack.NewProtocolPackSubject;
import com.example.entity.pack.NewProtocolUnpackSubject;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.entity.protocol.upload.NewProtocolUploadPorModel;
import com.example.entity.protocol.upload.NewProtocolUploadPositionModel;
import com.example.entity.protocol.upload.NewProtocolUploadReceiveDataPorModel;
import com.example.pack.service.ICommonPackService;
import com.example.pack.service.INewProtocolPackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

        String commandType = message.substring(NewProtocolParameterPositionConstant.COMMAND_TYPE_INDEX_START,
                NewProtocolParameterPositionConstant.COMMAND_TYPE_INDEX_END);
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
        //获取body
        NewProtocolUploadPositionModel positionModel = new NewProtocolUploadPositionModel();
        //获取公共属性
        commonPackService.obtainSharedProperties(positionModel, message);
        //获取特有属性

        return positionModel;
    }

    public UploadBaseModel changeMessageToPorModel(String message) {
        //获取body属性
        NewProtocolUploadPorModel porModel = new NewProtocolUploadPorModel();
        //获取公共属性
        commonPackService.obtainSharedProperties(porModel, message);
        //获取特有属性
        return porModel;
    }

    public UploadBaseModel changeMessageToReceiveDataPorModel(String message) {
        //获取body属性
        NewProtocolUploadReceiveDataPorModel receiveDataPorModel = new NewProtocolUploadReceiveDataPorModel();
        //获取公共属性
        commonPackService.obtainSharedProperties(receiveDataPorModel, message);
        //获取特有属性
        return receiveDataPorModel;
    }

    @Override
    public String pack(DownloadBaseModel downloadBaseModel) {
        //这里判断命令类型
        return null;
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
