package com.demo.concurrent.callable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


/**
 * submit和execute方法大家都不陌生，即开启线程执行池中的任务。
 * execute提交的方式只能提交一个Runnable的对象，且该方法的返回值是void，也即是提交后如果线程运行后，和主线程就脱离了关系了
 * submit提交一个实现了Callable接口的对象,并且返回Future对象，即执行的结果
 */
public class CallablePool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
    }

}
