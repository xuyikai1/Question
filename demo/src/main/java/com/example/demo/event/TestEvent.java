package com.example.demo.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@Getter
@Setter
public class TestEvent extends ApplicationEvent {

    private static final long serialVersionUID = 4181929072911659524L;

    private String message;

    public TestEvent(String message) {
        super(message);
        this.message = message;
    }
}
