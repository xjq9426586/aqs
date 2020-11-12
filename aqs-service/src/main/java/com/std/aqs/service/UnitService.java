package com.std.aqs.service;

import com.std.aqs.entity.Unit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("df")
public interface UnitService extends BaseService<Unit,Integer>{
    @ApiOperation(value="set")
    void set();
}
