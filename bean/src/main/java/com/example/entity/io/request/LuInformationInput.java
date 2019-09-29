package com.example.entity.io.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 设备信息实体
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class LuInformationInput implements Serializable {
    /**
     *
     */
    @NotBlank(message = "currVLR参数不能为空")
    private String currVLR;
    /**
     *
     */
    @NotBlank(message = "imsi参数不能为空")
    private String imsi;
    /**
     *
     */
    @NotBlank(message = "luTime参数不能为空")
    private String luTime;
    /**
     *
     */
    @NotBlank(message = "mccmnc参数不能为空")
    private String mccmnc;
    /**
     *
     */
    @NotBlank(message = "referenceId参数不能为空")
    private String referenceId;
    /**
     *
     */
    @NotBlank(message = "msisdn参数不能为空")
    private String msisdn;
    /**
     *
     */
    @NotBlank(message = "networkType参数不能为空")
    private String networkType;
    /**
     *
     */
    @NotBlank(message = "luResult参数不能为空")
    private String luResult;
    /**
     *
     */
    @NotBlank(message = "failCode参数不能为空")
    private String failCode;
}
