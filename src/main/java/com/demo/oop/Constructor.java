package com.demo.oop;
/*
* 构造方法也叫构造器或者构造函数
*
* 构造方法与类名相同，没有返回值，连void都不能写
*
* 权限修饰符 类名(形参) { }
*
  构造方法在创建对象时调用，new 类名(形参)，作用是为正在创建的对象的成员变量赋初值。

  构造方法会有一个默认返回值，不用自己return

  如果手动添加了构造器，那么默认空参构造器就会消失，所以建议手动加上空参构造器

  this在构造方法中调用重载构造方法，只能位于第一行
* */


class Constructor1 {
    //这里有一个默认空参构造方法

}

class Constructor2 {
   String color;

    public Constructor2(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        //new Constructor2(); Constructor2空参构造器已被覆盖不存在

    }
}






public class Constructor {

    String name;

    int age;

    //这里就变成了普通方法
    public void Constructor() {
    }


    //构造方法重载
    public Constructor() {
        System.out.println("无参构造器");
    }


    public Constructor(String name) {
        this.name = name;
        System.out.println("单参构造器");
    }

    public Constructor(int age) {
        this.age = age;
        System.out.println("单参构造器");
    }

    public Constructor(String name, int age) {
        this(name);  //this调用重载构造器
        this.age=age;
        System.out.println("双参构造器");
    }
}
