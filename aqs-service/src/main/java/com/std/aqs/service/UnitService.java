package com.std.aqs.service;

import java.util.List;

import com.std.aqs.entity.Unit;

public interface UnitService {
	public void save(Unit u);
	public List<Unit> list();
}
