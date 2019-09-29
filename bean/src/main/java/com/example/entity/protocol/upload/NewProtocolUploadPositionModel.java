package com.example.entity.protocol.upload;

import com.example.entity.protocol.base.NewProtocolUploadBaseModel;
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
public class NewProtocolUploadPositionModel extends NewProtocolUploadBaseModel {

    private String locationInformation;
}
