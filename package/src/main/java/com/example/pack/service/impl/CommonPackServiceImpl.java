package com.example.pack.service.impl;

import com.example.constant.protocol.decode.NewProtocolPositionIndexConstant;
import com.example.constant.protocol.UploadDecodeConstant;
import com.example.constant.protocol.decode.ProtocolIndexConstant;
import com.example.entity.protocol.base.UploadBaseModel;
import com.example.pack.service.ICommonPackService;
import com.example.util.protocol.ProtocolUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommonPackServiceImpl implements ICommonPackService {

    @Override
    public String handleMessageReadable(String message) {

        byte[] messageBytes = message.getBytes();
        //创建解码容器
        byte[] container = new byte[UploadDecodeConstant.UPLOAD_DECODE_CONTAINER_SIZE];
        //将原数据的第一个字节拷贝到容器中
        System.arraycopy(messageBytes, 0, container, 0, 1);
        //最后一个字节不参与转义字符处理
        int length = messageBytes.length - 2;
        ProtocolUtil.handleEscapeCharacters(messageBytes, 1, container, 1, length);
        message = new String(container);
        return message;
    }

    @Override
    public void obtainSharedProperties(UploadBaseModel uploadBaseModel, String message) {

        //共同属性，位置相同，选择通用位置索引即可
        String prefix = message.substring(ProtocolIndexConstant.USSD_PREFIX_INDEX_START,
                ProtocolIndexConstant.USSD_PREFIX_INDEX_END);
        uploadBaseModel.setPrefix(prefix);
        String protocolVersion = message.substring(ProtocolIndexConstant.PROTOCOL_VERSION_INDEX_START,
                ProtocolIndexConstant.PROTOCOL_VERSION_INDEX_END);
        uploadBaseModel.setProtocolVersion(protocolVersion);
        String businessType = message.substring(ProtocolIndexConstant.BUSINESS_TYPE_INDEX_START,
                ProtocolIndexConstant.BUSINESS_TYPE_INDEX_END);
        uploadBaseModel.setBusinessType(businessType);
        String keyIndex = message.substring(ProtocolIndexConstant.KEY_INDEX_INDEX_START,
                ProtocolIndexConstant.KEY_INDEX_INDEX_END);
        uploadBaseModel.setKeyIndex(keyIndex);
        String manufacturerFlag = message.substring(ProtocolIndexConstant.MANUFACTURER_FLAG_INDEX_START,
                ProtocolIndexConstant.MANUFACTURER_FLAG_INDEX_END);
        uploadBaseModel.setManufacturerFlag(manufacturerFlag);
        String appletVersion = message.substring(ProtocolIndexConstant.APPLET_VERSION_INDEX_START,
                ProtocolIndexConstant.APPLET_VERSION_INDEX_END);
        uploadBaseModel.setAppletVersion(appletVersion);
        String commandType = message.substring(ProtocolIndexConstant.COMMAND_TYPE_INDEX_START,
                ProtocolIndexConstant.COMMAND_TYPE_INDEX_END);
        uploadBaseModel.setCommandType(commandType);
        //获取suffix，与其他属性不同
        Integer suffixStartIndex = message.length() - 1;
        Integer suffixEndIndex = message.length();
        String suffix = message.substring(suffixStartIndex, suffixEndIndex);
        uploadBaseModel.setSuffix(suffix);
    }

}
