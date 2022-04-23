package com.chris.project.test.blockingqueue;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
@Component
@RocketMQMessageListener(topic = "RSQ", selectorExpression = "tag1",consumerGroup = "my-consumer-group")
@Slf4j
public class MqConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.debug("consumer -----:{}", message);
    }
}
