package com.example.business.bip;

import com.example.entity.protocol.base.DownloadBaseModel;
import com.example.entity.protocol.base.UploadBaseModel;

public interface INewProtocolBipService {

    DownloadBaseModel handleDetailedBusinessByCommandType(UploadBaseModel uploadBaseModel);
}
