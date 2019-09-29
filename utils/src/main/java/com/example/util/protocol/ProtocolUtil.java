package com.example.util.protocol;

import com.example.constant.protocol.ProtocolVersionConstant;
import lombok.extern.slf4j.Slf4j;

/**
 * 集合了一些有关协议的处理方法
 * @author lushusheng
 * @date 2019-09-18
 * @description 有关协议处理的工具类
 */
@Slf4j
public class ProtocolUtil {

    /**
     * 获取协议版本号
     * @param message
     * @return
     */
    public static String getProtocolVersion(String message) {

        Integer protocolVersionStart = ProtocolVersionConstant.PROTOCOL_VERSION_START;
        Integer protocolVersionEnd = ProtocolVersionConstant.PROTOCOL_VERSION_END;
        String protocolVersion = message.substring(protocolVersionStart, protocolVersionEnd);
        return protocolVersion;
    }

    /**
     * 处理传输数据中定义的转义字符
     * @param source
     * @param sourcePosition
     * @param destiny
     * @param destinyPosition
     * @param length
     * @return
     */
    public static void handleEscapeCharacters(byte[] source, int sourcePosition, byte[] destiny, int destinyPosition, int length) {

    }
}
