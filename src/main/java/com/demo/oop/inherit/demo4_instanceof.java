package com.demo.oop.inherit;

/**
 * boolean result = obj instanceof Class
 * instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例
 * obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，或者是其直接或间接子类的对象，或者是接口的实现类，结果result 都返回 true，否则返回false。
 */
public class demo4_instanceof {

    public static void main(String[] args) {
        People people=new Man();
        People people2=new Woman();

        //instanceof 在向上转型时候使用表示实例是不是运行时类型
        if(people instanceof Man){
            Man man=(Man)people;
            man.smoke();
        }

        //instanceof 在向上转型时候使用表示实例是不是运行时类型
        if(people2 instanceof Woman){
            Woman woman=(Woman)people2;
            woman.dress();
        }


        Man man=new Man();
        System.out.println(man instanceof Man);
        System.out.println(man instanceof People);
        System.out.println(man instanceof Object);


        System.out.println(null instanceof Object);

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