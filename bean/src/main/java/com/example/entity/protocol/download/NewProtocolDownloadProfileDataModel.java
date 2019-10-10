package com.example.entity.protocol.download;

import com.example.entity.protocol.carry.NewProtocolCommandParameter;
import com.example.entity.protocol.base.NewProtocolDownloadBaseModel;
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
public class NewProtocolDownloadProfileDataModel extends NewProtocolDownloadBaseModel {
    /**
     * command parameter属性
      */
    private class NewProtocolDownloadProfileDataCommandParameter extends NewProtocolCommandParameter {

    }
}
