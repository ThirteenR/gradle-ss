package com.chris.project.test.web;

import com.alibaba.fastjson.JSONObject;
import com.chris.project.test.blockingqueue.BlockingQueueDemo;
import com.chris.project.test.entity.ManEntity;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Log4j2
public class TestWeb {
    @Resource(name = "bq")
    BlockingQueueDemo blockingQueueDemo;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/put/{num}")
    public String put(@PathVariable("num") String num) throws InterruptedException {
        blockingQueueDemo.put(num);
        return "success";
    }

    @PostMapping("/send/{tag}")
    public String send(@RequestBody @Validated ManEntity json, @PathVariable("tag") String tag) throws InterruptedException {
        log.info(AopUtils.isCglibProxy(rocketMQTemplate));
        rocketMQTemplate.convertAndSend("RSQ:" + tag , json);
        log.info(json);
        TimeUnit.MILLISECONDS.sleep(200);
        return "{\"message\":\"success\"}";
    }

}
