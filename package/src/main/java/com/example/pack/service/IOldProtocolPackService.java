package com.example.pack.service;

import com.example.entity.pack.OldProtocolPackSubject;
import com.example.entity.pack.OldProtocolUnpackSubject;

/**
 *
 */
public interface IOldProtocolPackService extends IPackService{

    /**
     * 对外提供的通用服务接口功能，解包
     * @param message
     * @return
     */
    OldProtocolUnpackSubject unpackService(String message);

    /**
     * 对外提供的通用服务接口功能,打包
     * @param oldProtocolPackSubject
     * @return
     */
    String packService(OldProtocolPackSubject oldProtocolPackSubject);
}
