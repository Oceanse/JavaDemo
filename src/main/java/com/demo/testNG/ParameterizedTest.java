package com.demo.testNG;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterizedTest {


    /*@DataProvider(name = "mapParamMethod")
    public Object[][] mapParamMethod() {
    final XmlTest currentXmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
    final Map<String, String> parameters = Reporter.getCurrentTestResult().getMethod()
            .findMethodParameters(currentXmlTest);*/
    @BeforeClass
    public static ITestResult getTestClassName(){
        ITestResult it = Reporter.getCurrentTestResult();
        return it;
    }


    // 定义数据源
    @DataProvider(name = "test")
    public Object[][] createData() {
        return new Object[][]{{"dadaorufeng",29},{"zhangsan",28}};
    }

    // 使用数据源
    @Test(dataProvider = "test")
    public void verifyData(String name, int age) {
        System.out.println("name:" + name + ",age:" + age);
    }



    @Test
    @Parameters("name")//从xml中获取参数
    public void verifyData2(String name) {
        System.out.println();
        System.out.println("name2:" + name );
    }

    @Test
    @Parameters({"name","age"})//从xml中获取参数
    public void verifyData3(String name,int age) {
        System.out.println();
        System.out.println("name3:" + name+" age: "+age );
    }
}


