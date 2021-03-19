package com.demo.basicdemo.keywords.statics.static_extend;

public class Sports {
    public static void info() {
        //静态方法不能被重写
        System.out.println("Sports make body strong");
    }
}



//继承父类的static info()方法，相当于该类拥有static方法info()
class Football extends Sports{
    public static void main(String[] args) {
        Sports.info();//通过父类名调用父类静态方法info()
        Football.info();//通过子类名调用调用父类静态方法info()
        info();//继承父类的static info()方法，相当于该类拥有static方法info()，所以省略类名时候默认会从当前类加载这个方法

        new Football().info();//通过子类对象调用父类静态方法,本质还是通过对象所属的类
    }
}
