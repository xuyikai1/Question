package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Executor executor;

    @GetMapping("/test")
    public String test(){
        log.info("\n██Test线程:{}",Thread.currentThread().getThreadGroup()+ "/" +Thread.currentThread().getName());
        executor.execute(()->applicationContext.publishEvent(new TestEvent("消息")));
        log.info("Executor:{}",executor);
        return "请求成功";
    }

}
