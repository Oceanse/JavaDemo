package com.demo.basicdemo.keywords.statics;

public class StaticExtend {

    public static void info() {
        System.out.println("aaa");
    }

}



//继承父类的static info()方法，相当于该类拥有static方法info()
class Kid extends StaticExtend{


    public static void main(String[] args) {
        StaticExtend.info();//通过父类名调用父类静态方法info()
        Kid.info();//通过子类名调用调用父类静态方法info()
        info();//继承父类的static info()方法，相当于该类拥有static方法info()，所以省略类名时候默认会从当前类加载这个方法

        new Kid().info();//通过子类对象调用父类静态方法
    }
}
