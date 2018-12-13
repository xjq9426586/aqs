package com.std.aqs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.aqs.entity.Unit;
import com.std.aqs.repository.UnitRepository;
@Service
@Transactional
public class UnitServiceImpl implements UnitService{
	@Autowired
	private UnitRepository unitRepository;
	@Override
	public void save(Unit u) {
		
		unitRepository.save(u);
		
	}
	@Override
	public List<Unit> list() {
		return unitRepository.findAll();
	}

}
