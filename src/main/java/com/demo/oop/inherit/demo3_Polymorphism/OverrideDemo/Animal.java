package com.demo.oop.inherit.demo3_Polymorphism.OverrideDemo;

import com.demo.concurrent.threadpool.A;
import org.testng.annotations.Test;

/**
 * 重写(Override): 方法覆盖需要和多态联合使用才会凸显其真正的价值
 *
 * 当父类实例方法不能满足子类需求，可以对父类继承的方法进行重写,重写只是针对方法，不针对属性，重写后子类只拥有重写后的方法
 * 也就是子类对象不能再去直接调用父类中的方法； 如果非要通过子类对象调用父类方法，可以在子类的某个方法中通过super实现如下：{super.父类被重写的方法}
 *
 * 子类方法和父类方法的返回值 方法名(参数)完全相同时候，编译器就会认为子类对父类方法进行了重写，无论带不带有@Override
 * 重写方法的方法名/参数必须和被重写的方法保持一致
 * 重写后方法的权限不能小于被重写方法的权限
 * 重写后方法的返回值类型比被重写的方法的返回值类型更小或者相等
 * 重写后方法抛出的异常不能多于被重写方法
 * 静态方法/私有方法不能被重写
 */
public class Animal {
    void move() {
        System.out.println("移动");
    }



    Object species(){
        return "Animal";
    }


    /**
     * 静态方法不能被重写
     */
    public static void sleep(){
        System.out.println("sleep...");
    }


    /**
     * 私有方法不能被重写
     */
    private void babyCount(){
        System.out.println(2);
    }

    public static void main(String[] args) {
        Animal a =new Sparrow();
        a.move();
    }
}


class Bird extends Animal {

    String Swing="Bird的翅膀";

    //重写后方法的权限可以变大
    @Override
    public void move() {
        System.out.println("Bird飞翔");
    }

    // 重写后方法的返回值类型比被重写的方法的返回值类型更小或者相等
    @Override
    public String species() {
        return "Bird";
    }


   /*
    重写后方法的权限不能小于被重写方法的权限
    @Override
    private void move() {
        System.out.println("飞翔");
    }*/

}





class Sparrow extends Bird {

    String Swing="Sparrow的翅膀";

    @Override
    public void move(){
        System.out.println("麻雀飞翔");
    }


    /**
     * 通过super调用父类被重写的方法
     */
    public void superClassMove(){
        super.move();
    }



  /*
    静态方法不能被重写
    @Override
    public static void sleep(){
        System.out.println("123sleep...");
    }
    */

    /**
     * 私有方法不能被重写，即使方法和父类完全相同，也会被认为时当前类新增的方法
     */
    //@Override  //这里添加@Override会编译报错
    private void babyCount(){
        System.out.println(1);
    }

    public static void main(String[] args) {
       new Sparrow().move();
       new Sparrow().superClassMove();
       //super.move(); //super不能出现在静态方法中
        new Sparrow().showSwing();
    }

    public void showSwing(){
        System.out.println(this.Swing);
        System.out.println(super.Swing);
    }

}

