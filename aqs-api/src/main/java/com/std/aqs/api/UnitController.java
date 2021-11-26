package com.std.aqs.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.std.aqs.entity.You;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultBean<List<Unit>> list() {
        log.info("获取list");
        return ResultBean.isOk(1).data(unitService.list());
    }

    @ApiOperation("新增单位")
    @PostMapping("save")
    public You save(@RequestBody You s) {
//        unitService.save(unit);
        return s;
    }

    @PostMapping("test")
    public Map<String, Object> test(@RequestBody Map<String, Object> params) {
        Map<String, Object> name1 = new HashMap<>();
        Map<String, Object> name2 = new HashMap<>();
        List<Map<String, Object>> names = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        name1.put("a", "a111111");
        name2.put("a", "a22222222222");
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> re = new HashMap<>();
        re.put("cstNm", "hhhhhhhhhhhhhh");
        re.put("names", names);
        map.put("data", re);
        map.put("code", 300);
        map.put("msg", "jl;k;;");
        map.put("a", "111");
        return map;
    }
}

