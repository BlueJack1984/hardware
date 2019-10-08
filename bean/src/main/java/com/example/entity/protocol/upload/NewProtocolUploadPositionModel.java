package com.example.entity.protocol.upload;

import com.example.entity.protocol.base.NewProtocolUploadBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 上行消息的通用实体头部
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class NewProtocolUploadPositionModel extends NewProtocolUploadBaseModel {

    /**
     *
     */
    private String checkNumber;
    /**
     *
     */
    private String locationInformation;
    /**
     *
     */
    private String primaryIccid;
    /**
     *
     */
    private String carryingCapacity;
    /**
     *
     */
    private String imei;
    /**
     *
     */
    private String imsi;
    /**
     * bip时存在
     */
    private String bipImsi;
    /**
     * bip时存在
     */
    private String cellId;
    /**
     *
     */
    private String latestOtaTradeNumber;
}
