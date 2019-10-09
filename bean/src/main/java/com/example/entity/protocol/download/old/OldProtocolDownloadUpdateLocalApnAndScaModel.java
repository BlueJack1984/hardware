package com.example.entity.protocol.download.old;

import com.example.entity.protocol.base.OldProtocolDownloadBaseModel;
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
public class OldProtocolDownloadUpdateLocalApnAndScaModel extends OldProtocolDownloadBaseModel {
    /**
     *
     */
    private String otaTradeNumber;
    /**
     *
     */
    private String apn;
    /**
     *
     */
    private String sca;
    /**
     *
     */
    private String plmn;
}
