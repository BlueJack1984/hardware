package com.example.entity.protocol.carry;

import com.example.entity.protocol.carry.base.NewProtocolCommandParameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 上行消息的通用实体头部
 * command parameter属性
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class NewProtocolDownloadProfileDataCommandParameter extends NewProtocolCommandParameter {
    /**
     *
     */
    private String oldIccid;
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
    /**
     * LV结构
     */
    private String expireTime;
    /**
     * LV结构
     */
    private String coverMcc;
    /**
     * LV结构
     */
    private String ussdPrefix;
    /**
     * LV结构
     */
    private String newIccid;
    /**
     * LV结构
     */
    private String apn;
    /**
     * LV结构
     */
    private String sca;
    /**
     * LV结构
     */
    private String telecomData;
    /**
     * LV结构
     */
    private String plmn;
    /**
     * LV结构
     */
    private String bipParameter;
    /**
     * LV结构
     */
    private String fplmn;
}
