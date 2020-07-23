package com.demo.testNG.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


/**
 * @BeforeGroups: The @BeforeGroups annotated method will run only once before all the test methods belonging
 * to a specified group have been executed.
 * @BeforeGroups注解的方法将在本组内测试方法执行前被执行一次，可用于执行初始化操作，只执行一次。
 *
 * @AfterGroups annotated method run only once for a group after the execution of all test cases belonging to that group.
 * @AfterGroups 注解的方法将在本组内任何测试方法执行后被执行，可用于关闭资源，只执行一次。
 */
public class Before_AfterGroup {
    @BeforeGroups(groups={"group-b"})
    public void setUp(){
        System.out.println("Method---setup");
    }


    @Test(groups = { "group-a" })
    public void aaaMethod() {
        System.out.println("Method---aaa");
    }

    @Test(groups = { "group-b"} )
    public void bbbMethod() {
        System.out.println("Method---bbb");
    }


    @AfterGroups(groups={"group-b"})
    public void tearDown(){
        System.out.println("Method---tearDown");
    }

}
