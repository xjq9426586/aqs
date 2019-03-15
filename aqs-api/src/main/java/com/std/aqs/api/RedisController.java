package com.std.aqs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.aqs.bean.ResultBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/redis")
@Api(tags = "redis测试API")
@SuppressWarnings("unchecked")
public class RedisController {
 
    @Autowired
    StringRedisTemplate redisTemplate;
     
	@GetMapping("set/{key}/{value}")
    @ApiOperation(value="设置缓存")
    public ResultBean<String> set(@PathVariable("key")String key,@PathVariable("value") String value) {
        //注意这里的 key不能为null spring 内部有检验
        redisTemplate.opsForValue().set(key, value);
        return ResultBean.isOk(1).data(key + "," + value);
    }
     
    @GetMapping("get/{key}")
    @ApiOperation(value="根据key获取缓存")
    public ResultBean<String> get(@PathVariable("key") String key) {
         
        return ResultBean.isOk(1).data("key=" + key + ",value=" + redisTemplate.opsForValue().get(key));
    }
}
