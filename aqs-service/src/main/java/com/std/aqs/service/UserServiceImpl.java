package com.std.aqs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.aqs.entity.User;
import com.std.aqs.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public int save(User u) {
		userRepository.save(u);
		return u.getId();
	}

	@Override
	public List<User> list() {
		
		return userRepository.findAll();
	}
	
}
