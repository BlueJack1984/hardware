package com.example.library.packer.sms.packet;


import com.packer.commons.sms.base.IExtendPointer;

public interface IValueValidator extends IExtendPointer {
    void validate(String var1) throws ValueValidatorException;
}
