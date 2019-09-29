package com.example.core.service.impl;

import com.example.core.service.ILuManualInstructionService;
import com.example.entity.table.LuManualInstruction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LuManualInstructionServiceImpl implements ILuManualInstructionService {


    @Override
    public List<LuManualInstruction> getListAllActive() {

        return null;
    }
}
