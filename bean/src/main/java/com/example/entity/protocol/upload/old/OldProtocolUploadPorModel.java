package com.example.entity.protocol.upload.old;

import com.example.entity.protocol.base.OldProtocolUploadBaseModel;
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
public class OldProtocolUploadPorModel extends OldProtocolUploadBaseModel {

    /**
     * 交易流水号
     */
    private String otaTradeNumber;
    /**
     * 设备唯一标识
     */
    private String imei;
}
