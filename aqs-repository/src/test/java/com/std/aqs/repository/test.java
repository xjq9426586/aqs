package com.std.aqs.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.std.aqs.entity.Unit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    private UnitRepository unitRepository;


    @Test
    public void test1() {
        Unit u = new Unit();
        u.setUnitName("单位");
        unitRepository.save(u);
    }
}
