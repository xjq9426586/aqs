package com.std.aqs.service;

import java.util.List;

import com.std.aqs.entity.User;

public interface UserService {
	public int save(User u);
	
	public List<User> list();
}
