package com.std.aqs.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.aqs.bean.ResultBean;
import com.std.aqs.entity.Unit;
import com.std.aqs.service.UnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api("单位信息管理")
@RestController
@RequestMapping("/api/unit/*")
@SuppressWarnings("unchecked")
public class UnitController {
	@Autowired
	private UnitService unitService;
	
	
	@ApiOperation("获取单位列表")  
	@GetMapping("list")
	public ResultBean<List<Unit>> list(){
		log.info("获取list");
		return ResultBean.isOk(1).data(unitService.list());
	}
	
	@ApiOperation("新增单位")
	@PostMapping("save")
    public Unit save(@RequestBody Unit unit) {
		unitService.save(unit);
        return unit;
    }
}

