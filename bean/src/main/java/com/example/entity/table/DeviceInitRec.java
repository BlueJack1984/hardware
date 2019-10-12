package com.example.entity.table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 设备订单实体
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DeviceInitRec implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     *
     */
    private String businessId;
    /**
     *
     */
    private String imei;
    /**
     *
     */
    private String deviceType;
    /**
     *
     */
    private String softsimType;
    /**
     *
     */
    private String iccid;
    /**
     *
     */
    private String imsi;
    /**
     *
     */
    private String supplierCode;
    /**
     *
     */
    private String supplierName;
    /**
     *
     */
    private String operatorCode;
    /**
     *
     */
    private String operatorName;
    /**
     *
     */
    private String seedIccid;
    /**
     *
     */
    private String seedImsi;
    /**
     *
     */
    private String seedSupplierCode;
    /**
     *
     */
    private String seedSupplierName;
    /**
     *
     */
    private String seedOperatorCode;
    /**
     *
     */
    private String seedOperatorName;
    /**
     *
     */
    private String status;
    /**
     *
     */
    private Long repeatReportRate;
    /**
     *
     */
    private Long retryCount;
    /**
     *
     */
    private Long reportRegularlyRate;
    /**
     *
     */
    private String bipIp;
    /**
     *
     */
    private String bipPort;
    /**
     *
     */
    private String createTime;
    /**
     *
     */
    private String executeStartTime;
    /**
     *
     */
    private String executeEndTime;
    /**
     *
     */
    private Long repeatCount;
    /**
     * 分散因子
     */
    private String numberIccid;
}
