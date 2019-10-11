package com.example.entity.container;

import com.example.entity.table.PlmnIndex;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 设备信息实体
 * @author lushusheng
 * @date 2019-09-19
 * @description
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class OtaCommunicationKeyContainer implements Serializable {

    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, String[]> COMMUNICATION_KEY_MAP = new HashMap<>();
    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, String[]> MCC_BIT_MAP = new HashMap<>();
    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, PlmnIndex> PLMN_INDEX_MAP = new HashMap<>();
    /**
     * 多组数据密钥，配置成一个map
     */
    public static Map<String, String[]> PERS_DATA_KEY_MAP = new HashMap<>();

}
