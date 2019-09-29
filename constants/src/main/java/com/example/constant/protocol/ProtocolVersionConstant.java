package com.example.constant.protocol;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 协议相关的常数
 * @author lushusheng
 * @date 2019-09-18
 * @description 协议常数
 */
@Data
@Slf4j
public class ProtocolVersionConstant {

    public static final Integer PROTOCOL_VERSION_START = 1;

    public static final Integer PROTOCOL_VERSION_END = 3;

    public static final String NEW_PROTOCOL_VERSION = "3.0.1";

    public static final String OLD_PROTOCOL_VERSION = "2.1.1";
}
