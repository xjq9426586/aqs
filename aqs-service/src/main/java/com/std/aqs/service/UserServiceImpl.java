package com.std.aqs.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.std.aqs.entity.User;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService{
	
}
