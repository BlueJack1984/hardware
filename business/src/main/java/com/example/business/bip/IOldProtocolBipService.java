package com.example.business.bip;

import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;

public interface IOldProtocolBipService {

    DownloadBaseModel handleBipDetailedBusiness(UploadBaseModel uploadBaseModel);
}
