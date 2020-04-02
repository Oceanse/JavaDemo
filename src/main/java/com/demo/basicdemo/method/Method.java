package com.demo.basicdemo.method;

public class Method {


    /*
     * 方法体中的代码会自上而下顺序执行，上面的代码执行完才能执行下一行的代码
     * 方法不能嵌套定义，可以嵌套调用
     *
     *static方法，可以通过 类名.方法名(参数)，调用本类的静态方法可省略类名直接方法名(参数)
     *也就是省略类名，编译器会从当前类中找这个方法
     *
     * */


    //main函数由JVM负责调度，是整个程序的入口
    public static void main(String[] args) {

        //say();无法解析，调用非本类的静态方法必须前面加上类名
        Method2.say();


        Method.info();
        info();//调用本类的静态方法可省略类名


    }

    public static void info() {}

}


class Method2 {
    public static void say() {
    }
}


class Method3 extends Method2 {
    public static void main(String[] args) {
        say();//Method3继承Method2，也就拥有了static say()
    }
}