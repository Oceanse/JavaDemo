package com.demo.testNG.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerimpl implements ITestListener {


    //在实例化测试类之后和在调用任何配置方法之前调用
    @Override
    public void onStart(ITestContext Result) {
        System.out.println("onStart is called");
    }

    // When Test case get Started, this method is called.执行每个测试方法之前会被调用
    @Override
    public void onTestStart(ITestResult Result) {
        System.out.println("onTestStart is called and "+ Result.getName() + " will run");
    }
    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("onTestSuccess is called and "+Result.getName()+"  is passed" );
    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result) {
        System.out.println("onTestSuccess is called and "+Result.getName()+"  is failed" );
    }


    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result) {
        System.out.println("onTestSuccess is called and "+Result.getName()+"  is skipped" );
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    //在运行所有测试并调用所有配置方法之后调用。
    @Override
    public void onFinish(ITestContext Result) {
        System.out.println("onFinish is called");
    }






}
