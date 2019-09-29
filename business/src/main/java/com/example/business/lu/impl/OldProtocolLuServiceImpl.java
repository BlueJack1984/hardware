package com.example.business.lu.impl;

import com.alibaba.fastjson.JSON;
import com.example.business.lu.ICommonLuService;
import com.example.business.lu.IOldProtocolLuService;
import com.example.constant.lu.LuManualInstructionConstant;
import com.example.entity.io.response.DownloadImsiInformation;
import com.example.entity.io.response.DownloadMessageCarrier;
import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.util.http.HttpRequestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 处理LU服务的旧协议相关业务
 * @author lushusheng
 * @date 2019-09-25
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OldProtocolLuServiceImpl implements IOldProtocolLuService {

    @Value("${}")
    private String orderSystemDownloadImsiUrl;
    private final ICommonLuService commonLuService;

    @Override
    public List<DownloadMessageCarrier> handleLuDetailedBusiness(String sharedImsi, String mcc) {

        //查询是否有能满足条件的下发要求
        Map<String, Object> instructionBusinessResult = commonLuService.handleLuManualInstructionBusiness(sharedImsi, mcc);
        Boolean successFlag = (Boolean) instructionBusinessResult.get(LuManualInstructionConstant.OPERATION_STATUS_KEY);
        if(successFlag) {
            log.info("manual instruction操作成功，直接下发数据，不需要进行后面操作！");
            return (List<DownloadMessageCarrier>)instructionBusinessResult.get(LuManualInstructionConstant.OPERATION_RESULT_KEY);
        }
        log.info("manual instruction操作不成功，执行后面逻辑下发数据！");
        Set<String> iccidSet = commonLuService.getIccidSetBySharedImsi(sharedImsi);
        if(null == iccidSet || iccidSet.size() < 1) {
            log.info("根据共享imsi查询不到相关设备id，返回为空！");
            return null;
        }
        log.info("根据共享imsi获取的设备集合为：" + iccidSet);
        //这里需要调用订单接口，完成相关功能，返回副号信息
        String parameters = JSON.toJSONString(iccidSet);
        String response = HttpRequestUtil.doPostJson(orderSystemDownloadImsiUrl, parameters);
        //对从订单接口获取的数据进行处理，有可能有状态位判断，后面详细分析
        List<DownloadImsiInformation> imsiInformationList = JSON.parseArray(response, DownloadImsiInformation.class);
        if(null == imsiInformationList || imsiInformationList.size() < 1) {
            log.info("");
            return null;
        }
        //对获取的相关数据进行实体封装
        List<DownloadMessageCarrier> downloadMessageCarrierList = new ArrayList<>();
        changeDownloadInformationToModel(downloadMessageCarrierList, imsiInformationList);

        return downloadMessageCarrierList;
    }

    private void changeDownloadInformationToModel(List<DownloadMessageCarrier> carrierList, List<DownloadImsiInformation> informationList) {

        //这里有两种方案实现msisdn和operatorCode属性的获取
        //第一种方案是通过订单接口获取，由订单接口功能实现
//        for(DownloadImsiInformation information : informationList) {
//            //将共同属性进行拷贝
//            DownloadMessageModel messageModel = new DownloadMessageModel();
//            messageModel.setMsisdn(information.getMsisdn());
//            messageModel.setOperatorCode(information.getOperatorCode());
//            OldProtocolDownloadModel downloadModel = new OldProtocolDownloadModel();
//            BeanUtils.copyProperties(information, downloadModel);
//            //赋值
//            messageModel.setDownloadBaseModel(downloadModel);
//            modelList.add(messageModel);
//        }
        //第二种方案是自己查询获取
        for(DownloadImsiInformation information : informationList) {

            DownloadMessageCarrier messageModel = new DownloadMessageCarrier();
            //获取msisdn和operatorCode属性
            messageModel.setMsisdn(null);
            messageModel.setOperatorCode(null);
            //拷贝相同属性
            DownloadBaseModel downloadBaseModel = new DownloadBaseModel();
            BeanUtils.copyProperties(information, downloadBaseModel);
            messageModel.setDownloadBaseModel(downloadBaseModel);
            carrierList.add(messageModel);
        }
    }
}
