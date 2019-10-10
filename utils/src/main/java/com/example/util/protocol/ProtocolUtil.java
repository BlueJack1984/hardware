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
                switch() {
                }
            }else {
                destination[destinationPosition] = source[sourcePosition];
                destinationPosition ++;
                sourcePosition ++;
            }
        }while(sourcePosition <= sourceOffsetEnd);

        short off_end = (short)(inoff+len),dst_start = outoff;
        do{
            if(src[inoff]==0x2A){
                inoff++;
                switch (src[(short)(inoff++)])
                {
                    case (byte) 0x30://A
                        dst[outoff++] = 0x41;
                        break;
                    case (byte) 0x31://B
                        dst[outoff++] = 0x42;
                        break;
                    case (byte) 0x32://C
                        dst[outoff++] = 0x43;
                        break;
                    case (byte) 0x33://D
                        dst[outoff++] = 0x44;
                        break;
                    case (byte) 0x34://E
                        dst[outoff++] = 0x45;
                        break;
                    case (byte) 0x35://F
                        dst[outoff++] = 0x46;
                        break;
                    case (byte) 0x36://
                        dst[outoff++] = 0x47;
                        break;
                    case (byte) 0x37://H
                        dst[outoff++] = 0x48;
                        break;
                    case (byte) 0x38://I
                        dst[outoff++] = 0x49;
                        break;
                    default:
                }

            }else{
                dst[outoff++] = src[(short)(inoff++)];
            }
        }while(inoff<=off_end);
        return len = (short)(outoff - dst_start);
    }
    }
}
