package com.chris.project.test.blockingqueue;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.LinkedBlockingQueue;

@Service("bq")
@Transactional
public class BlockingQueueDemo extends LinkedBlockingQueue<String> {

    public void test(){
        System.out.println("as");
    }

}
