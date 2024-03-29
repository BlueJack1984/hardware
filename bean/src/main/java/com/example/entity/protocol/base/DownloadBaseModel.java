package com.example.entity.protocol.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 上行消息的通用实体头部
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DownloadBaseModel implements Serializable {
    /**
     *
     */
    private String businessType;
    /**
     *
     */
    private String keyIndex;
    /**
     *
     */
    private String checkNumber;
    /**
     *
     */
    private String mac;
}
