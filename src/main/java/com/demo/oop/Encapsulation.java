package com.demo.oop;

/*
 * 类的定义可以看成是将构成类的成员变量和方法封装起来；这就是最宏观的封装；
 * private 修饰属性完成了对自身对象一定程度的封装，只能类本身访问；
 * 然后对外提供接口，外部程序可以通过这个接口访问private 属性
 * */
public class Encapsulation {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(10);
        System.out.println(p.getAge());
    }

}

class Person {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        }
    }
}
