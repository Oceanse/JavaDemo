package com.demo.others;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * 操作系统环境变量(os变量)是包括系统环境变量和用户环境变量(os层面的变量)，包括默认os环境变量和自定义os环境变量
 *
 * java的系统属性(VM argumen)可以理解为JVM的环境变量，对所有的java进程有效
 *在java应用程序运行时，特别是需要在跨平台工作环境中运行时，需要确定操作系统的类型、用户JDK版本、
 * 用户工作目录等随工作平台变化的信息，以确保程序正确运行。这些程序的运行环境信息为java平台的自身配置，
 * 被称为java的系统属性。系统属性与操作系统的环境变量类似，可以认为是JVM虚拟机的环境变量。
 *
 *
 * System.getEnv() 可以获取全部os环境变量，包括系统环境变量和用户环境变量/默认os环境变量和自定义os环境变量；
 * 返回Map,The returned map will never contain null keys or values.
 * 新设置的环境变量(用户和环境)需要重新启动idea才能生效，否则System.getEnv()获取不到(新增了一个环境变量，一定要退出所有java进程，然后才能通过System.getEnv()获得值，否则获取不到)
 * System.getEnv() 不能获取VM argument，VM argument不是os层面的变量
 *
 * System.getEnv(String str)获取指定的os环境变量，包括系统环境变量和用户环境变量/默认os环境变量和自定义os环境变量；
 * 对于windoes来说,这里传入的key就是环境变量中的key
 * 当环境变量不存在或者不生效时会得到null
 * 新设置的环境变量(用户和环境)需要重新启动idea才能生效,否则System.getEnv(String str)得到null
 * System.getEnv(String str) 不能获取VM argument，VVM argument不是os层面的变量
 *
 *
 *
 * System.getProperties()，获取所有的默认(提前定义好)JVM环境变量(java.home,os.name)，自定义JVM环境变量(-Dkey=value)
 *
 * System.getProperties(String str)，获取指定的JVM环境变量(java.home,os.name)，包括默认JVM环境变量和自定义JVM环境变量(-Dkey=value)
 *如果配置了-Dproperty=value参数，又在程序中使用了System.setProperty对同一个变量进行设置，那么以程序中的设置为准。
 *如果-Dproperty=value的value中包含空格，可以将value使用引号引起来。例如：-Dmyname="hello world"
 *
 *
 *
 *
 */
public class EnvVariable {


    /**
     *获取指定的默认/自定义os环境变量
     */
    @Test
    public void test(){
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getenv("Path"));
        System.out.println(System.getenv("OS"));
    }




    /**
     *获取全部os环境变量
     */
    @Test
    public void test2(){
        Map<String, String> map = System.getenv();
        Set<String> set = map.keySet();
        for(String item:set){
            System.out.println(item+"="+map.get(item));
        }
    }



    /**
     *获取指定的默认/自定义JVM环境变量
     */
    @Test
    public void test3(){
        System.setProperty("name","ocean");
        System.out.println(System.getProperty("name"));

        System.out.println(System.getProperty("java.version"));//运行时环境版本
        System.out.println(System.getProperty("java.vendor"));//运行时环境供应商
        System.out.println(System.getProperty("java.vendor.url"));//运行时环境供应商
        System.out.println(System.getProperty("java.home"));//运行时环境安装目录
        System.out.println(System.getProperty("java.library.path"));// 加载库时搜索的路径列表
        System.out.println(System.getProperty("os.name"));//操作系统的名称
        System.out.println(System.getProperty("os.name").replace(" ",""));
        System.out.println(System.getProperty("os.version"));//操作系统的版本
        System.out.println(System.getProperty("os.arch"));//操作系统的架构
        System.out.println(System.getProperty("file.separator"));//文件分隔符(在 UNIX 系统中是"/")
        System.out.println(System.getProperty("path.separator"));//路径分隔符(在 UNIX 系统中是":")
        System.out.println(System.getProperty("user.name"));//用户名称
        System.out.println(System.getProperty("user.home"));//用户主目录
        System.out.println(System.getProperty("os.name"));
    }



    /**
     *获取全部默认/自定义JVM环境变量
     */
    @Test
    public void test4(){
        System.setProperty("name","ocean");
        System.out.println(System.getProperty("name"));

        Properties properties = System.getProperties();
        properties.forEach((k,v)-> System.out.println(k+"="+v));
    }



    /**
     *当Edit configration和代码中同时设置vm argument时，代码优先级更高，会覆盖Edit configration中设置的值
     */
    @Test
    public void test5(){
        System.setProperty("name","ocean");
        System.out.println(System.getProperty("name"));
    }


}

