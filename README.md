# Spring事件传播机制

> 参考链接：
> [Spring事件监听机制 - 知乎](https://zhuanlan.zhihu.com/p/101128672)
> [深入浅出Spring/SpringBoot 事件监听机制 - 知乎](https://zhuanlan.zhihu.com/p/145927110)
> [Spring事件发布监听](https://blog.csdn.net/fenglllle/article/details/88370998)

## 0.代码

[xuyikai1/Question · GitHub](https://github.com/xuyikai1/Question)

## 1.问题阐述
Spring事件传播中，监听器在接收到事件发布，则执行事件对应的内容，但是发现事件发布与内容只能同步执行，甚至是两个线程的同步执行，**无法异步执行**

## 2.代码介绍

- EventConfig.java：开启异步，初始化一个简单的线程池，保证ApplicationEventMulticaster类的multicastEvent()方法中能获取到线程池，从而走异步的方式执行监听器的内容
- TestEvent.java：自定义测试的事件
- TestListener.java：自定义监听TestEvent的测试监听器(使用注解的形式实现)
- TestController.java：测试接口

## 3.发生问题的现象分析

在监听器的listen方法打断点，调用测试接口。
发现：
- 原来应该直接返回成功的请求卡在了异步执行的listen方法断点（同步）
- 打印出来的处理请求和处理listen方法的两者线程名称不一样

打断点在ApplicationEventMulticaster类的multicastEvent()方法，查看问题，发现executor为null
