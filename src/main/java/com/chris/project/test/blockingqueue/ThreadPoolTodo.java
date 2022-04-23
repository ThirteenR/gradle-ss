package com.chris.project.test.blockingqueue;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.*;

@Configuration
public class ThreadPoolTodo {
    @Resource(name = "bq")
    BlockingQueueDemo blockingQueueDemo;
    @Bean
    public Executor tp() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                (ThreadFactory) r -> new Thread(r, "AAAAAAAAAA"),
                new ThreadPoolExecutor.CallerRunsPolicy());
        tp.execute(() -> {
//            try {
////                for (;;) {
////                    String take = blockingQueueDemo.take();
////                    System.out.println(take);
////                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        return tp;
    }
}
