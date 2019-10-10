package com.example.entity.protocol.carry;

import com.example.entity.protocol.carry.base.NewProtocolCommandParameter;
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
public class NewProtocolDownloadPushCommandCommandParameter extends NewProtocolCommandParameter {
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
}
