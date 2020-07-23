package com.demo.testNG.listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ExecutionListenerIMpl.class})
//@Listeners({TestListenerimpl.class})
//@Listeners({SuiteListenerDemo.class})
@Listeners({IInvokedMethodListenerImp.class})
public class ListenerDemo {

    @Test
    public void TestToPass() {
        System.out.println("This method to test pass");
        Assert.assertTrue(true);
    }


    @Test
    public void TestToFail() {
        System.out.println("This method to test fail");
        Assert.assertTrue(false);
    }


    @Test
    public void TestToSkip() {
        System.out.println("This method to test skip");
        throw new SkipException("skip the test");//代码中抛出SkipException异常，这次测试就会被标记为Skip
    }
}
