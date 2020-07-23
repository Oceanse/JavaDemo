package com.demo.testNG;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数定义在suite.xml中， 通过@Parameters注解传递到测试方法中
 */
public class ParameterizedTest {


    // 定义数据源
    @DataProvider(name = "paramData")
    public Object[][] createData() {
        return new Object[][]{{"dadaorufeng", 29}, {"zhangsan", 28}};
    }

    // 使用数据源
    @Test(dataProvider = "paramData")
    public void verifyData(String name, int age) {
        System.out.println("name:" + name + ",age:" + age);
    }


    /**
     * 从param.xml中获取参数<parameter name="name" value="Tank" />
     * @param myname
     */
    @Test
    @Parameters("name")
    public void verifyData2(String myname) {
        System.out.println();
        System.out.println("name:" + myname);
    }


    /**
     * 从param.xml中获取参数
     *  <parameter name="length" value="10" />
     *  <parameter name="width" value="5" />
     *
     * @param length
     * @param width
     */
    @Test
    @Parameters({"length", "width"})
    public void verifyData3(String length, String width) {
        System.out.println();
        System.out.println( " long: " + length+" width:" + width);
    }
}


