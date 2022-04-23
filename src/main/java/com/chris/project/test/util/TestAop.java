package com.chris.project.test.util;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class TestAop {
    @Pointcut("execution(public * com.chris.project.test.blockingqueue.BlockingQueueDemo.*(..))")
    public void test() {
    }

    @Before("test()")
    public void bef(){
        log.info(this);
    }



}
