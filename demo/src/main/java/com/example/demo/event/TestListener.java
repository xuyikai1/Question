package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@Component
@Slf4j
public class TestListener {


    @EventListener(value = TestEvent.class)
    @Async
    public void listen(TestEvent event){
        log.info("\n██listener线程:{}",Thread.currentThread().getThreadGroup()+ "/" +Thread.currentThread().getName());
        log.info("test");
        log.info("event:{}",event);
    }

}
