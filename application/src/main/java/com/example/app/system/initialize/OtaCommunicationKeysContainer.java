package com.example.app.system.initialize;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lushusheng
 * @date 2019-10-10
 * @description 系统初始化准备数据
 */
@Component
@Order(1)
public class OtaCommunicationKeysContainer implements ApplicationRunner {

    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, String[]> OTA_COMM_KEY_MAP = new HashMap<>();
    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, String[]> OTA_COMM_KEY_MAP = new HashMap<>();
    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, String[]> OTA_COMM_KEY_MAP = new HashMap<>();
    /**
     * 多组通信密钥，配置成一个map
     */
    public static Map<String, String[]> OTA_COMM_KEY_MAP = new HashMap<>();


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
