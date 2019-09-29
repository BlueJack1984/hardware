package com.example.app.controller;

import com.example.entity.io.request.LuInformationInput;
import com.example.entity.io.response.DownloadMessageCarrier;
import com.example.protocol.service.IProtocolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lushusheng
 * @date 2019-09-18
 * @description bip通信通道
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lu")
public class LuController {

    private final IProtocolService protocolService;

    @PostMapping(value = "/handle")
    public List<DownloadMessageCarrier> handleLuBusiness(@RequestBody @Valid LuInformationInput luInformationInput) {

        log.info("LU服务接收到的实体信息：" + luInformationInput);
        String sharedImsi = luInformationInput.getImsi();
        String mcc = luInformationInput.getMccmnc().substring(0, 3);

        //分成两个业务，查询是否有下发要求
        List<DownloadMessageCarrier> downMsgCarrierList = protocolService.handleLuCommonProtocol(sharedImsi, mcc);
        return downMsgCarrierList;
    }
}
