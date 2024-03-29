package com.example.library.packer.sms.mapping;


import com.packer.commons.sms.packet.PacketChannel;

import java.util.List;

public interface XMLMapping {
    List<PacketChannel> loadChannels();

    void serializeChannels(List<PacketChannel> var1);
}
