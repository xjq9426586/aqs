package com.std.aqs.service.impl;

import javax.transaction.Transactional;

import com.std.aqs.service.UserService;
import com.std.aqs.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.std.aqs.entity.User;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

}
