package com.example.entity.table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备订单实体
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class LuPartnerAdmission implements Serializable {

    private Long id;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String partnerCode;

    private String partnerName;
}
