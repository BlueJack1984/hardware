package com.example.entity.io.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 设备信息实体
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DownloadImsiInformation implements Serializable {

    /**
     * 手机号
     */
    private String msisdn;
    /**
     * 企业编码
     */
    private String operatorCode;
}
