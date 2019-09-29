package com.example.business.ussd;

import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;

public interface IOldProtocolUssdService {

    DownloadBaseModel handleUssdDetailedBusiness(UploadBaseModel uploadBaseModel);
}
