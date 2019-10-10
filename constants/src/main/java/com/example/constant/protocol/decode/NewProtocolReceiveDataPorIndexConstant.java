package com.example.constant.protocol.decode;

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
public class NewProtocolReceiveDataPorIndexConstant extends NewProtocolIndexConstant {
    /**
     *
     */
    public static final Integer ICCID_INDEX_START = 15;
    public static final Integer ICCID_INDEX_END = 16;
    /**
     *
     */
    public static final Integer BATCH_NUMBER_INDEX_START = 15;
    public static final Integer BATCH_NUMBER_INDEX_END = 16;
    /**
     *
     */
    public static final Integer REQUEST_MESSAGE_BIT_MAP_INDEX_START = 15;
    public static final Integer REQUEST_MESSAGE_BIT_MAP_INDEX_END = 16;
}
