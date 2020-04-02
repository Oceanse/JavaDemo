package com.demo.basicdemo.statics;

public class StaticExtend {

    public static void info() {
        System.out.println("aaa");
    }

}



//继承父类的static info()方法，相当于该类拥有static方法info()
class Kid extends StaticExtend{


    public static void main(String[] args) {
        StaticExtend.info();
        Kid.info();//调用本类static方法info()
        info();//调用本类static方法info()可以省略类名

        new Kid().info();
    }
}
