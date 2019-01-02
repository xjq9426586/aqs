package com.std.aqs.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.std.aqs.entity.Unit;
@Service
@Transactional
public class UnitServiceImpl extends BaseServiceImpl<Unit,Integer> implements UnitService{
	

}
