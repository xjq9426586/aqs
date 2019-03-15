package com.std.aqs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.aqs.entity.User;
import com.std.aqs.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User getUser(int id) {
		return userRepository.getOne(id);
	}
	
}
