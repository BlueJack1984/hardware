package com.example.util.protocol;

import com.example.constant.protocol.ProtocolVersionConstant;
import com.example.constant.protocol.decode.ProtocolIndexConstant;
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

        Integer protocolVersionStart = ProtocolIndexConstant.PROTOCOL_VERSION_INDEX_START;
        Integer protocolVersionEnd = ProtocolIndexConstant.PROTOCOL_VERSION_INDEX_END;
        String protocolVersion = message.substring(protocolVersionStart, protocolVersionEnd);
        return protocolVersion;
    }

    /**
     * 处理传输数据中定义的转义字符
     * @param source
     * @param sourcePosition
     * @param destination
     * @param destinationPosition
     * @param length
     * @return
     */
    public static void handleEscapeCharacters(byte[] source, int sourcePosition, byte[] destination, int destinationPosition, int length) {

        int sourceOffsetEnd = sourcePosition + length;
        int destinationStartIndex = destinationPosition;
        do {
            //0x2a表示字符*号
            if(0x2a == source[sourcePosition]) {
                sourcePosition ++;
                switch((char)source[sourcePosition]) {
                    //字符A
                    case '0':
                        destination[destinationPosition] = 0x41;
                        break;
                    //字符B
                    case '1':
                        destination[destinationPosition] = 0x42;
                        break;
                    //字符C
                    case '2':
                        destination[destinationPosition] = 0x43;
                        break;
                    //字符D
                    case '3':
                        destination[destinationPosition] = 0x44;
                        break;
                    //字符E
                    case '4':
                        destination[destinationPosition] = 0x45;
                        break;
                    //字符F
                    case '5':
                        destination[destinationPosition] = 0x46;
                        break;
                    //字符G
                    case '6':
                        destination[destinationPosition] = 0x47;
                        break;
                    //字符H
                    case '7':
                        destination[destinationPosition] = 0x48;
                        break;
                    //字符I
                    case '8':
                        destination[destinationPosition] = 0x49;
                        break;
                    default:
                        log.info("位置上报的字符串转义过程中出现非法字符，无法转码！");
                        break;
                }
            }else {
                destination[destinationPosition] = source[sourcePosition];
            }
            destinationPosition ++;
            sourcePosition ++;
        }while(sourcePosition <= sourceOffsetEnd);
    }
}
