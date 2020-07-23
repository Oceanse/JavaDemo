package com.demo.testNG.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;


/**
 * suite的AOP
 * ISuiteListener 针对的是测试套件
 * ISuiteListener 使用户有机会在测试套件开始执行以及执行结束之后嵌入自己的逻辑；
 */
public class SuiteListenerDemo implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart is called");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish is called");
    }
}
