package com.example.library.packer.sms.packet;

import com.packer.commons.sms.base.IExtendPointer;

import java.util.List;

public interface IValueSource extends IExtendPointer {
    List<String> getValues() throws ValueSourceException;
}
