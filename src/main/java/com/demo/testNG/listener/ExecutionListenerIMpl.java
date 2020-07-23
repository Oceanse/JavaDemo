package com.demo.testNG.listener;

import org.testng.IExecutionListener;


/**
 * IExecutionListener用于监听TestNG执行的开始和结束，开始于TestNG处理任何监听器之前，结束于测试报告产生后TestNG退出JVM之前。
 */
public class ExecutionListenerIMpl implements IExecutionListener {


    //invoked before TestNG proceeds with invoking any other listener
    @Override
    public void onExecutionStart() {
        System.out.println("onExecutionStart is called");
    }

    //invoked at the very last (after report generation phase), before TestNG exits the JVM
    @Override
    public void onExecutionFinish() {
        System.out.println("onExecutionFinish is called");
    }



}
