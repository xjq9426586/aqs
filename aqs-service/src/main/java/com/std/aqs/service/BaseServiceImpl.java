package com.std.aqs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public class BaseServiceImpl<T,ID> implements BaseService<T,ID>{
	@Autowired
	private JpaRepository<T, ID> j;
	@Override
	public T save(T t) {
		j.save(t);
		return t;
	}

	@Override
	public List<T> list() {
		
		return j.findAll();
	}
	
	@Override
	public Optional<T> getEntity(ID id) {
		
		return j.findById(id);
	}
}
