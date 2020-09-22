package com.demo.oop.OOPDemo;
/**
 * OOP：Object Oriented Programming
 * 类：对具有相同属性(成员变量)行为(方法)的一组对象的集合
 *
 * 对象：也称为实例，根据类生成的具体实体，具有明确定义的属性(成员变量)和行为(方法)；
 *     不同的对象具有各自独有的一套属性和行为，但是共享相同的类变量和类方法
 *
 *
 * 类可以理解为汽车设计图，对象就是根据图纸设计出的每辆汽车
 * 定义class就是定义了一种数据类型，对应的instance是这种数据类型的实例；
 *
 * 类成员组成设计：成员变量(类成员变量和实例成员变量) 方法 构造器 代码块 内部类
 *
 * 面向对象开发过程：观察现实世界中对象，抽取出这些对象的共同特征(状态和行为)，脑海中形成一个模板，然后用代码进行类的设计，
 * 然后通过类创建对象，所有的对象协作起来形成一个系统
 * 面向对象程序设计的重点是类的设计
 * <p>
 * 类和对象的使用:
 * 1.创建类，设计类的成员
 * 2.创建类的对象
 * 3.通过“对象.属性”或“对象.方法”调用对象的结构。
 * <p>
 * 关于对象引用：引用是一个变量，是局部变量或者成员变量，引用变量本身有自己的内存地址，并且还保存着对象所在堆内存的地址
 * <p>
 */

import java.util.Arrays;

public class OOPDemo {

    //实例变量，对象级别的变量
    private String name;
    boolean isMarried;
    String[] hobby;
    Site site;

    //类变量
    private static String nation = "China";


    //空参构造器
    public OOPDemo() {
        System.out.println("OOP1() is called");
    }


    //四参构造器
    public OOPDemo(String name, boolean isMarried, String[] hobby, Site site) {
        this.name = name; //this指向当前对象或则实例
        this.isMarried = isMarried;
        this.hobby = hobby;
        this.site = site;
    }

    //方法
    @Override
    public String toString() {
        return "OOPDemo{" +
                "name='" + name + '\'' +
                ", isMarried=" + isMarried +
                ", hobby=" + Arrays.toString(hobby) +
                ", site=" + site +
                '}';
    }

    //代码块
    {
        int age = 30;

    }

    //内部类
    class InnerClass {
    }
}


class Site {

    private String country;
    private String city;
    private String county;

    public Site() {
    }

    public Site(String country, String city, String county) {
        this.country = country;
        this.city = city;
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "Site{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}


class OOPDemoTest {
    public static void main(String[] args) {

        Site location = new Site("China", "Shanghai", "Changning");
        String[] hobby = {"Code", "Sing", "movie"};

        //demo称之为引用或者引用变量
        //栈内存中的demo变量保存着堆内存当中OOPDemo对象的地址, 只有通过引用才能找到对象
        OOPDemo demo = new OOPDemo("ocean", false, hobby, location);

        //这里的引用指向特定对象，就可以把引用“当成”特定对象，通过引用取调用对象的toString方法
        System.out.println(demo.toString());

        location.setCity("Weifang");
        location.setCounty("Anqiu");
        System.out.println(demo.toString());

       //站引用变量不指向任何堆对象，也就是demo对应的对象或者实例不存在，那么相应的属性和方法也不存在，所以会导致NPE
        demo=null;
        demo.toString();

    }
}
