package com.std.aqs.service;

import java.util.List;

public interface BaseService<T,ID> {
	public T save(T t);
	public List<T> list();
}
