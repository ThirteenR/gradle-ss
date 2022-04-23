package com.chris.project.test.operation.impl;

import com.chris.project.test.operation.ITestForService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("testForService1")
public class TestForService1 implements ITestForService {
    @Resource(name = "testForService")
    ITestForService testForService;
    @Override
    public void test() {
        System.out.println(1);
    }
}
