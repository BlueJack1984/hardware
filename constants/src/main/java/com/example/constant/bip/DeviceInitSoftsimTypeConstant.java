package com.example.constant.bip;

import lombok.Data;

import java.io.Serializable;

/**
 * 协议相关的常数
 * @author lushusheng
 * @date 2019-09-18
 * @description 协议常数
 */
@Data
public class DeviceInitSoftsimTypeConstant implements Serializable {
    /**
     *
     */
    public static final String DOWNLOAD_PRIMARY_NUMBER_TYPE = "1";
    /**
     *
     */
    public static final String DOWNLOAD_LOCAL_NUMBER_TYPE = "2";
    /**
     *
     */
    public static final String DOWNLOAD_SHARED_PRIMARY_NUMBER_TYPE = "3";
    /**
     *
     */
    public static final String DOWNLOAD_PRIMARY_AND_LOCAL_NUMBER_TYPE = "4";
    /**
     *
     */
    public static final String DOWNLOAD_SHARED_PRIMARY_AND_LOCAL_NUMBER_TYPE = "5";
}
