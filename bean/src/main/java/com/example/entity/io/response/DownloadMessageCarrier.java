package com.example.entity.io.response;

import com.example.entity.protocol.base.DownloadBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DownloadMessageCarrier implements Serializable {
    /**
     * 手机号
     */
    private String msisdn;
    /**
     * 企业编码
     */
    private String operatorCode;
    /**
     * 下行消息
     * 与下行实体数据相对应
     */
    private String downMessage;
    /**
     * 下行实体，用来加密的数据
     * 方便调试时备查
     */
    private DownloadBaseModel downloadBaseModel;
}
