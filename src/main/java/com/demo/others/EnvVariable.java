package com.demo.others;

import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * 环境变量(os变量)是包括系统环境变量和用户环境变量(os层面的变量)
 *
 * java的系统属性(VM argumen)可以理解为JVM的环境变量，对所有的java进程有效
 *在java应用程序运行时，特别是需要在跨平台工作环境中运行时，需要确定操作系统的类型、用户JDK版本、
 * 用户工作目录等随工作平台变化的信息，以确保程序正确运行。这些程序的运行环境信息为java平台的自身配置，
 * 被称为java的系统属性。系统属性与操作系统的环境变量类似，可以认为是JVM虚拟机的环境变量。
 *
 *
 * System.getEnv() 可以获取全部环境变量，包括系统环境变量和用户环境变量，是system-dependent变量；
 * 返回Map,The returned map will never contain null keys or values.
 * 新设置的环境变量(用户和环境)需要重新启动idea才能生效，否则System.getEnv()获取不到(新增了一个环境变量，一定要退出所有java进程，然后才能通过System.getEnv()获得值，否则获取不到)
 * System.getEnv() 不能获取VM argument，VM argument不是os层面的变量
 *
 * System.getEnv(String str)获取指定的环境变量，包括系统环境变量和用户环境变量，是system-dependent变量；
 * 对于windoes来说,这里传入的key就是环境变量中的key
 * 当环境变量不存在或者不生效时会得到null
 * 新设置的环境变量(用户和环境)需要重新启动idea才能生效,否则System.getEnv(String str)得到null
 * System.getEnv(String str) 不能获取VM argument，VVM argument不是os层面的变量
 *
 *
 *
 * System.getProperties()，获取所有的默认JVM环境变量(java.home,os.name)，自定义JVM环境变量(-Dkey=value)
 * System.getProperties(String str)，获取指定的JVM环境变量(java.home,os.name)，自定义JVM环境变量(-Dkey=value)
 *如果配置了-Dproperty=value参数，又在程序中使用了System.setProperty对同一个变量进行设置，那么以程序中的设置为准。
 *如果-Dproperty=value的value中包含空格，可以将value使用引号引起来。例如：-Dmyname="hello world"
 *
 *
 *
 *
 */
public class EnvVariable {
    public static void main(String[] args) {
        System.out.println(System.getenv("UUU"));
        System.out.println(System.getenv("SSS"));
        System.out.println(System.getenv("names"));//无法获取JVM的环境变量vm argument
    }
}



class Testenv{
    public static void main(String[] args) {

        Map<String, String> map = System.getenv();
        Set<String> set = map.keySet();
        for(String item:set){
            System.out.println(item+"="+map.get(item));
        }
    }
}



class Testenv2{
    public static void main(String[] args) {

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("sun.java.launcher"));
        System.out.println(System.getProperty("names"));
    }
}




class Testenv3{
    public static void main(String[] args) {
        System.setProperty("name","ocean");//当Edit configration和代码中同时设置vm argument时，代码优先级更高，会覆盖Edit configration中设置的值
        Properties properties = System.getProperties();
        properties.forEach((k,v)-> System.out.println(k+"="+v));

    }
}


class Testenv4{
    public static void main(String[] args) {
        System.setProperty("name","ocean");//当Edit configration和代码中同时设置vm argument时，代码优先级更高，会覆盖Edit configration中设置的值
        System.out.println(System.getProperty("name"));
        System.out.println(System.getProperty("java.home"));
    }
}



class Testenv5{
    public static void main(String[] args) {
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getProperty("java.home"));


        System.out.println(System.getenv("OS"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.name").replace(" ",""));

    }
}