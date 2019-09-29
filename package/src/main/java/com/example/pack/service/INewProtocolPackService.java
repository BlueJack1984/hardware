package com.example.pack.service;

import com.example.entity.pack.NewProtocolPackSubject;
import com.example.entity.pack.NewProtocolUnpackSubject;

public interface INewProtocolPackService extends IPackService{

    /**
     * 对外提供的通用服务接口功能，解包
     * @param message
     * @return
     */
    NewProtocolUnpackSubject unpackService(String message);

    /**
     * 对外提供的通用服务接口功能,打包
     * @param newProtocolPackSubject
     * @return
     */
    String packService(NewProtocolPackSubject newProtocolPackSubject);
}
