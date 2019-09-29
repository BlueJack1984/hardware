package com.example.constant.protocol;

import lombok.Data;

/**
 * 协议相关的常数
 * @author lushusheng
 * @date 2019-09-18
 * @description 协议常数
 */
@Data
public class NewProtocolCommandTypeConstant {

    /**
     *
     */
    public static final String POSITION_UPDATE_TYPE = "0";
    /**
     *
     */
    public static final String DOWNLOAD_LOCAL_DATA_TYPE = "1";
    /**
     *
     */
    public static final String DOWNLOAD_GLOBAL_DATA_TYPE = "2";
    /**
     *
     */
    public static final String PUSH_COMMAND_TYPE = "3";
    /**
     *
     */
    public static final String RECEIVE_DATA_POR_TYPE = "9";
    /**
     *
     */
    public static final String POSITION_UPDATE_BUSINESS_VALUE = "30";
    /**
     *
     */
    public static final String DOWNLOAD_LOCAL_DATA_BUSINESS_VALUE = "31";
    /**
     *
     */
    public static final String DOWNLOAD_GLOBAL_DATA_BUSINESS_VALUE = "32";
    /**
     *
     */
    public static final String PUSH_COMMAND_BUSINESS_VALUE = "33";
    /**
     *
     */
    public static final String RECEIVE_DATA_POR_BUSINESS_VALUE = "39";
}
