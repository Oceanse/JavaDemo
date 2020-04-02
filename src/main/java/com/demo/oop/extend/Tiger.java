package com.demo.oop.extend;

import org.testng.annotations.Test;

/*
 * 多态存在的三个必要条件:
 * 继承
 * 重写
 * 父类引用指向子类对象
 * 多态的好处：可以使程序有良好的扩展，并可以对所有类的对象进行通用处理
 *
 * */

public class Tiger extends Animal {

    public Tiger() {
        System.out.println("tiger空参构造器");
    }

    @Override
    public void move() {
        System.out.println("老虎奔跑");
    }

    @Override
    public void drink() {
        System.out.println("老虎喝水");
    }

    public void hunt() {
        System.out.println("老虎捕食");
    }

    @Test
    public void test() {
        //无论向上转型还是向下转型，两种类型必须要有继承关系
        Animal a = new Tiger();//父类引用指向子类对象(父类--->子类)，称之为向上转型,可以理解为自动转换

        Tiger t = (Tiger) a;//父类型--->子类型 称之为向下转型,可理解为强制转换


        //注意：只要两种类型存在继承关系，就可以向下转型
        Animal a2 = new Bird();
        //这里编译时a2是Animal类型，所以可以强转成Tiger类型；
        // 但是运行时a2是Bird类型，无法转换成Tiger类型，因为两者不存在继承关系，所以运行时会产生类型转换异常
        Tiger tiger = (Tiger) a2;


        //为了避免强转时出现转换异常，java规范建议instanceof判断
        //
        Animal a3 = new Bird();
        if (a3 instanceof Tiger) {//a3运行时是Tiger类型
            ((Tiger) a3).hunt();
        } else if (a3 instanceof Bird) {//a3运行时是Bird类型
            ((Bird) a3).fly();
        }


    }


    public static void main(String[] args) {

        //Tiger对drink进行了重写，然后就只拥有这个重写的方法，原先的被重写的方法不再拥有
        //tiger编译和运行时都是Tiger类型，所以调用的是Tiger对象的drink
        Tiger tiger = new Tiger();
        tiger.drink();


        //a对象编译时类型是Animal，运行时类型是Tiger;
        //编译看左边，运行看右边
        //动态绑定
        Animal a = new Tiger();


        /*
        程序运行阶段堆内存中真正创建的是Tiger对象，所以运行的是Tiger的move方法,
        只不过这个方法是Tiger把父类中的move重写后，然后变成了自己的方法
        重写后子类只拥有重写后的方法
        */
        a.move();



        /*
        程序运行阶段堆内存中真正创建的是Tiger对象，所以运行的是Tiger的sleep方法,
        只不过这个sleep方法是Tiger从父类直接继承过来，然后变成了自己的
        脑海中要有子类所拥有的的成员变量和方法
        */
        a.sleep();




        /*
        a.hunt();
        编译时期，a是Animal类型，编译器无法从Animal.class找到ea()t方法，所有编译会报错
        当我们调用的方法是子类中特有的方法时候就需要向下转型(父类----->子类,向下转型必须存在继承关系)，
        这样编译器在编译时候就会把a当成Tiger类型，编译时就可以通过，当然运行时还是Tiger类型
        */
        ((Tiger) a).hunt();


    }
}
