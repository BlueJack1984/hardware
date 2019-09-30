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
public class OldProtocolUploadPositionModel extends OldProtocolUploadBaseModel {

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
    private String imei;
    /**
     *
     */
    private String imsi;

}
