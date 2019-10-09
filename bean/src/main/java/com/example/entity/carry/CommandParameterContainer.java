package com.example.entity.carry;

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
public class CommandParameterContainer implements Serializable {

    /**
     *
     */
    private String commandType;
    /**
     *
     */
    private String commandParameterLength;
    /**
     *
     */
    private CommandParameter commandParameter;
}
