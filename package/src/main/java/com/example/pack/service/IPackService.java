package com.example.pack.service;

import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;

public interface IPackService {

    /**
     *
     */
    UploadBaseModel unpack(String message);

    /**
     *
     */
    String pack(DownloadBaseModel downloadBaseModel);
}
