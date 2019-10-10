package com.example.constant.protocol.decode;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 上行消息的通用实体头部
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ProtocolIndexConstant implements Serializable {

    /**
     * 协议前缀部分
     */
    public static final Integer USSD_PREFIX_INDEX_START = 0;
    public static final Integer USSD_PREFIX_INDEX_END = 7;
    /**
     * 协议版本号
     */
    public static final Integer PROTOCOL_VERSION_INDEX_START = 7;
    public static final Integer PROTOCOL_VERSION_INDEX_END = 8;
    /**
     * 业务类型
     */
    public static final Integer BUSINESS_TYPE_INDEX_START = 8;
    public static final Integer BUSINESS_TYPE_INDEX_END = 9;
    /**
     * 秘钥索引序号
     */
    public static final Integer KEY_INDEX_INDEX_START = 9;
    public static final Integer KEY_INDEX_INDEX_END = 10;
    /**
     * 制造商标识
     */
    public static final Integer MANUFACTURER_FLAG_INDEX_START = 10;
    public static final Integer MANUFACTURER_FLAG_INDEX_END = 15;
    /**
     * applet版本号
     */
    public static final Integer APPLET_VERSION_INDEX_START = 15;
    public static final Integer APPLET_VERSION_INDEX_END = 16;
    /**
     * 命令类型
     */
    public static final Integer COMMAND_TYPE_INDEX_START = 16;
    public static final Integer COMMAND_TYPE_INDEX_END = 17;
}
