package com.demo.oop.inherit.demo3_Polymorphism.OverrideDemo;


/**
 * 父类私有方法对子类是不可见的，也就是子类不能直接调用或者重写这个方法
 */
public class Animal_override_private {

    /**
     * 私有方法
     */
    private void run() {
        System.out.println("移动");
    }


    /**
     * 通过一个public暴露封装的私有方法
     */
    public void move() {
        run();
    }

}





class Panda extends Animal_override_private {



    public static void main(String[] args) {
        //Panda继承拥有move方法
        new Panda().run();//访问子类自己独有的move方法
        new Panda().move();//通过继承过来的move方法间接访问父类的私有方法
    }

    /**
     * 即使定义了一个和父类相同返回值类型、方法名、参数的方法，也不会认为是重写，而是子类一个全新的方法
     */
    private void run() {
        System.out.println("Panda跑动");
    }


   /*私有方法不能被覆盖
   @Override
   private void run() {
        System.out.println("移动");
    }
    */
}