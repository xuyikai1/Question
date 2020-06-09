package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@Configuration
@Slf4j
@EnableAsync
public class EventConfig extends SimpleApplicationEventMulticaster {

    /**
     * 初始化一个简单的线程池，保证ApplicationEventMulticaster类的multicastEvent()方法中能获取到线程池，
     * 从而走异步的方式执行监听器的内容
     * @return
     */
    @Override
    public Executor getTaskExecutor() {
        // 这里的线程池可以使用业务中已经定义好的，此处只是例子
        return Executors.newFixedThreadPool(5);
    }

    /**
     * 初始化simpleApplicationEventMulticaster时设置一个默认的TaskExecutor，
     * 保证ApplicationEventMulticaster类的multicastEvent()方法中能获取到线程池，
     * 从而走异步的方式执行监听器的内容
     * @return
     */
    /*@Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
                = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }*/

}
