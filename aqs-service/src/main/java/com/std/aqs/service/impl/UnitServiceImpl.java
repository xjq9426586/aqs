package com.std.aqs.service.impl;

import javax.transaction.Transactional;

import com.std.aqs.service.UnitService;
import com.std.aqs.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.std.aqs.entity.Unit;
@Service
@Transactional
public class UnitServiceImpl extends BaseServiceImpl<Unit,Integer> implements UnitService {


    @Override
    public void set() {

    }
}
