package com.demo.oop.OOPDemo.demo1;
/**
 * OOP：Object Oriented Programming 面向对象
 * POP: Procedure Oriented Programming 面向过程
 *
 * 类：对具有相同状态(属性/成员变量)行为(方法)的一组个体进行抽象后的模板
 *
 * 对象：也称为实例，根据类生成的具体实体，具有明确定义的属性和方法；
 *     同一类的不同的对象具有各自独有的一套属性和行为，但是共享相同的类变量和类方法
 *
 *
 * 类和对象的通俗理解：
 * 类可以理解为汽车设计图，对象就是根据图纸设计出的每辆汽车
 * 定义class就是定义了一种数据类型，对应的instance是这种数据类型的实例；
 *
 * 类成员组成设计：
 * 成员变量(类成员变量和实例成员变量) 方法 构造器 代码块 内部类
 *
 * java程序员要有高度抽象能力，观察现实世界中对象(不同的电脑)，抽取出这些对象的共同特征(状态和行为，品牌、主板、CPU、硬盘、内存)，脑海中形成一个模板(笔记本)，然后用代码进行类的设计，
 * 当然还有生产商，销售商也可以抽象成一个个的类，然后通过这些类创建对象(电脑主体)，所有的对象协作起来形成一个系统；
 * 面向对象程序设计中类的设计很重要
 *
 * 类和对象的使用:
 * 1.创建类，设计类的成员
 * 2.创建类的对象
 * 3.通过“对象.属性”或“对象.方法”调用对象的结构。
 *
 * 关于引用：
 *  Person people1 = new Person("ocean", false, hobby, site);
 *  String name=people1.name;
 *  people1.toString();
 *  People people2=people1;
 *  people2=null;
 *  people1是引用变量，指向堆内存中的对象；
 *  通过引用访问属性和方法，实际上是访问引用指向的对象的属性和方法
 *  一个对象可以有多个引用变量或者多个引用变量可以指向同一个对象
 *  如果一个对象没有任何引用变量，将会被GC,释放堆内存
 */

import java.util.Arrays;

public class Person {

    //实例变量，对象级别的变量
    private String name;
    boolean isMarried;
    String[] hobby;
    Site site;//把A类的对象作为B类的成员变量组合起来，从而可以复用A类的属性和方法(组合或者聚合关系，has-a关系)

    //类变量
    private static String nation = "China";


    //空参构造器
    public Person() {
        System.out.println("Person() is called");
    }


    //四参构造器
    public Person(String name, boolean isMarried, String[] hobby, Site site) {
        this.name = name; //this指向当前正在创建的对象或则实例
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
        System.out.println("构造代码块被调用");

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


class Tests {
    public static void main(String[] args) {

        Site site = new Site("China", "Shanghai", "Changning");
        String[] hobby = {"Code", "Sing", "movie"};

        //demo称之为引用或者引用变量
        //栈内存中的people变量保存着堆内存当中Person对象的地址, 只有通过引用才能找到对象
        Person people = new Person("ocean", false, hobby, site);

        //这里的引用指向特定对象，就可以把引用当成特定对象，通过引用取调用对象的toString方法
        System.out.println(people.toString());

        //demo指向堆内存OOPDemo对象地址，堆内存中Person存放着Site对象的引用变量site, 所以这里存在着一个"引用链", 引用1-->引用2-->具体对象
        //当引用2发生改变时候，引用1对应的对象也会发生改变
        site.setCity("Weifang");
        site.setCounty("Anqiu");
        System.out.println(people.toString());

       //站引用变量不指向任何堆对象，也就是demo对应的对象或者实例不存在，那么相应的属性和方法也不存在，所以会导致NPE
        people=null;
        people.toString();

    }
}
