package com.demo.others;

import java.security.ProtectionDomain;


/**
 * https://blog.csdn.net/yu102655/article/details/112347600
 * https://blog.csdn.net/qq_27399407/article/details/79866980
 */
public class GetProtectionDomainDemo {
    public static void main(String[] args) {

        try {
            Class cls = Class.forName("com.demo.others.GetProtectionDomainDemo");

            // returns the name of the class
            System.out.println("Class = " + cls.getName());

            // 测试发现，path是当前类(字节码文件)所在的classpath
            //如果在idea跑，ProtectionDomain是当前类所在的classpath=C:/Users/epanhai/git/myproject/JavaDemo/target/classes/
            //如果把某个springnoot工程打包成可执行jar,然后再主类打印主类的ProtectionDomain，java- jar xxx.jar 启动时候，得到的ProtectionDomain=该jar的绝对路径
            String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
            System.out.println(path);
        } catch(ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
}
