package com.example.business.autoapn.impl;

import com.example.business.autoapn.IOldProtocolAutoapnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OldProtocolAutoapnServiceImpl implements IOldProtocolAutoapnService {


    @Override
    public String handleUssdDetailedBusiness(String message) {

        String name = "curry";
        return null;
    }
}
