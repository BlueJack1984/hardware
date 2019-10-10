package com.example.pack.service;

import com.example.entity.protocol.base.UploadBaseModel;

/**
 * 抽取出来新协议和旧协议的共同方法
 */
public interface ICommonPackService {

    /**
     *
     * @param message
     * @return
     */
    String handleMessageReadable(String message);

    /**
     *
     * @param uploadBaseModel
     * @param message
     */
    void obtainSharedProperties(UploadBaseModel uploadBaseModel, String message);

}
