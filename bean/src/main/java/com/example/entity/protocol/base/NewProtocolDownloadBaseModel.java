package com.example.entity.protocol.base;

import com.example.entity.protocol.carry.CommandParameterContainer;
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
public class NewProtocolDownloadBaseModel extends DownloadBaseModel {
    /**
     *
     */
    private String batchNumber;
    /**
     *
     */
    private String messageTotalNumber;
    /**
     *
     */
    private String currentMessageIndex;
    /**
     *
     */
    private String userDataLength;
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
    private List<CommandParameterContainer> commandParameterContainerList;
    /**
     *
     */
    private String mac;
}
