package com.demo.oop.inherit.demo3_Polymorphism.PolymorphhismDemo4;

import com.demo.basicdemo.code_block.construct_block.demo1.Person;

/**
 * boolean result = obj instanceof Class
 * instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例
 * obj 为一个对象的引用，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，或者是其直接或间接子类的对象，或者是接口的实现类，结果result 都返回 true，否则返回false。
 * 注意：
 *
 * 常用场景：引用变量所指向的实例是否是指定类型或者说引用变量的运行时类型是否是指定类型，通常和向下转型结合使用
 * 如果是，可以进行向下转型：把引用类型变量强转成运行时类型，然后就可以调用子类类型中所有的成员，特别是子类独有的方法
 * SuperClass obj=new SubClass();
 * if(obj instanceOf SubClass){
 *     SubClass subObj=(SubClass)obj;
 * }
 *
 * 通过向下转型，不过需要注意：
 * 1 父类引用对象指向的是期望子类对象，那么在向下转型的过程中是安全的，编译运行是不会出错误。
 * 但是如果父类引用指向的是父类本身对象或者是其他非期望子类对象，那么在向下转型的过程中是编译时候也不会出错，但是运行时会出现错误，所以是有隐患不安全的，
 * 因此使用 instanceof 运算符来避免出此类错误。
 *
 * 2 instanceof前面操作数的编译时类型要和运算符后面的类具有继承关系或者相等，否则会引起编译报错
 *
 *
 */
public class demo4_instanceof {

    public static void main(String[] args) {
        People people=new Man();
        People people2=new Woman();

        //Woman woman=(Woman)people;这里向下转型编译时候会通过，但是运行时候会报错

        //people指向的对象实例是否是指定Man类型或者说people的运行时类型是否是指定Man类型
        if(people instanceof Man){
            Man man=(Man)people;//向下转型后，man在编译和运行时期都是Man类型
            man.smoke();
        }

        //people2指向的对象实例是否是指定Woman类型或者说people2的运行时类型是否是指定Woman类型
        if(people2 instanceof Woman){
            Woman woman=(Woman)people2;//向下转型后，woman在编译和运行时期都是Woman类型
            woman.dress();
        }



        Man man=new Man();
        System.out.println(man instanceof Man);
        System.out.println(man instanceof People);
        System.out.println(man instanceof Object);
        //System.out.println(man instanceof Woman);


        People people3=new People();
        System.out.println(people3 instanceof Man);
        System.out.println(null instanceof Object);


        //Person Man Man String和Object具有父子关系，所以可以运行instanceof
        Object o=new Man();
        System.out.println(o instanceof Person);
        System.out.println(o instanceof Man);
        System.out.println(o instanceof Woman);
        System.out.println(o instanceof String);

        People p=new Man();
        System.out.println(p instanceof People);
        System.out.println(p instanceof Man);
        System.out.println(p instanceof Woman);
        //System.out.println(p instanceof String);//编译不通过People和String之间没有继承关系，所以不能进行instanceof，
    }


}

class People{

    public void love(){
        System.out.println("People love....");
    }
}

class Man extends People{

    @Override
    public void love(){
        System.out.println("Man love sports");
    }

    public void smoke(){
        System.out.println("smoking....");
    }
}


class Woman extends People{

    @Override
    public void love(){
        System.out.println("Woman love shopping");
    }

    public void dress(){
        System.out.println("dressing....");
    }
}