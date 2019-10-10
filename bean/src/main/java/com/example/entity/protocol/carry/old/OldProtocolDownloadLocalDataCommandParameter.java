package com.example.entity.protocol.carry.old;

import com.example.entity.protocol.carry.base.OldProtocolCommandParameter;
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
public class OldProtocolDownloadLocalDataCommandParameter extends OldProtocolCommandParameter {
    /**
     *
     */
    private String primaryIccidSuffix;
    /**
     *
     */
    private String callControlFlag;
    /**
     *
     */
    private String expireTime;
    /**
     *
     */
    private String otaTradeNumber;
    /**
     *
     */
    private String coverMcc;
    /**
     *
     */
    private String plmn;
    /**
     *
     */
    private String imsi;
    /**
     *
     */
    private String algorithmFlag;
    /**
     *
     */
    private String dataKeyIndex;
    /**
     *
     */
    private String keyData;
}
