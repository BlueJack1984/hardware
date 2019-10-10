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
public class OldProtocolPositionIndexConstant extends OldProtocolIndexConstant {

    /**
     *
     */
    public static final Integer CHECK_NUMBER_INDEX_START = 15;
    public static final Integer CHECK_NUMBER_INDEX_END = 16;
    /**
     *
     */
    public static final Integer LOCATION_INFORMATION_INDEX_START = 15;
    public static final Integer LOCATION_INFORMATION_INDEX_END = 16;
    /**
     *
     */
    public static final Integer PRIMARY_ICCID_INDEX_START = 15;
    public static final Integer PRIMARY_ICCID_INDEX_END = 16;
    /**
     *
     */
    public static final Integer IMSI_INDEX_START = 15;
    public static final Integer IMSI_INDEX_END = 16;
}
