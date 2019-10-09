package com.example.entity.protocol.download;

import com.example.entity.carry.NewProtocolCommandParameter;
import com.example.entity.protocol.base.NewProtocolDownloadBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 上行消息的通用实体头部
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class NewProtocolDownloadPushCommandModel extends NewProtocolDownloadBaseModel {
    /**
     *
     */
    private String otaTradeNumber;
    /**
     *
     */
    private String controlFlag;
    /**
     * TLV结构
     */
    private List<String> commandParameterList;

    private class NewProtocolDownloadPushCommandCommandParameter extends NewProtocolCommandParameter {

    }
}
