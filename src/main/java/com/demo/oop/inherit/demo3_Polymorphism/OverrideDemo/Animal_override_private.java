package com.demo.oop.inherit.demo3_Polymorphism.OverrideDemo;


/**
 * 父类私有方法对子类是不可见的，也就是子类不能直接调用或者重写这个方法
 */
public class Animal_override_private {
   private void run() {
        System.out.println("移动");
    }

    public void move() {
        run();
    }

}





class Panada extends Animal_override_private {



    public static void main(String[] args) {
        //Panada继承拥有move方法
        new Panada().move();
        new Panada().run();
    }

    /**
     * 即使定义了一个和父类相同返回值类型、方法名、参数的方法，也不会认为是重写，而是子类一个全新的方法
     */
    private void run() {
        System.out.println("panada跑动");
    }


   /*私有方法不能被覆盖
   @Override
   private void run() {
        System.out.println("移动");
    }
    */
}