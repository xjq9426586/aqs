package com.std.aqs.service;

import java.util.List;
import java.util.Optional;


public interface BaseService<T,ID> {
	public T save(T t);
	public List<T> list();
	public Optional<T> getEntity(ID id);
}
