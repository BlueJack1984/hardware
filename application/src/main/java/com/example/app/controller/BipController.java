package com.example.app.controller;

import com.example.protocol.service.IProtocolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lushusheng
 * @date 2019-09-18
 * @description bip通信通道
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/bip")
public class BipController {

    private final IProtocolService protocolService;

    @PostMapping(value = "/handle")
    public String handleBipBusiness(@RequestBody String message) {

        if(StringUtils.isEmpty(message)) {
            log.info("bip通道传递的位置上报信息为空，无法处理！");
            return null;
        }
        log.info("bip通道接收到的上行报文为：" + message);
        String downMessage = protocolService.handleBipCommonProtocol(message);
        log.info("***********下行报文************--》：" + downMessage);
        return downMessage;
    }
}