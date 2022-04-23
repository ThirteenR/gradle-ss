package com.chris.project.test.operation.impl;

import com.chris.project.test.operation.ITestForService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("testForService")
public class TestForService implements ITestForService {
    @Resource(name = "testForService1")
    ITestForService testForService1;
    @Override
    public void test() {
        System.out.println(2222);
    }
}
