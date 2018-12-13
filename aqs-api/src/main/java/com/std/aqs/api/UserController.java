package com.std.aqs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.aqs.bean.ResultBean;
import com.std.aqs.entity.User;
import com.std.aqs.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("用户信息管理")
@RestController
@RequestMapping("/api/user/*")
@SuppressWarnings("unchecked")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation("新增用户")
	@PostMapping("save")
	public ResultBean<Integer> save(@RequestBody User user) {
		return ResultBean.isOk(1).data(userService.save(user));
	}
}
