package com.demo.oop.encapsulation;

/*
 * 类的定义可以看成是将构成类的成员变量和方法封装起来；这就是最宏观的封装；
 *
 * 方法是一段功能代码的封装，也是某种意义上的封装；
 *
 * private 修饰属性完成了对自身对象一定程度的封装，只能类本身访问；
 * 然后对外提供接口，外部程序可以通过这个接口访问或者修改private属性
 * */
public class Encapsulation {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(100);
        p.setName("father");
        System.out.println(p.getAge());
    }

}

class Person {

    private int age;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //参数检查，这样外部代码就没有任何机会把age设置成不合理的值。
        if (age > 0 && age < 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

}
