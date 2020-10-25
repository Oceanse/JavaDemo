package com.demo.others;

import java.security.ProtectionDomain;

public class GetProtectionDomainDemo {
    public static void main(String[] args) {

        try {
            Class cls = Class.forName("com.demo.others.GetProtectionDomainDemo");

            // returns the name of the class
            System.out.println("Class = " + cls.getName());

            // 测试发现，ProtectionDomain是当前类所在的classpath
            //如果在idea跑，ProtectionDomain是当前类所在的classpath=C:/Users/epanhai/git/myproject/JavaDemo/target/classes/
            //如果把某个springnoot工程打包成可执行jar,然后再主类打印主类的ProtectionDomain，java- jar xxx.jar 启动时候，得到的ProtectionDomain=该jar的绝对路径
            ProtectionDomain p = cls.getProtectionDomain();
            System.out.println(p);
        } catch(ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
}
