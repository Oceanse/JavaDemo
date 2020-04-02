package com.demo.oop.extend;
/*
* 继承需要符合的关系是：is-a，可以理解为:“子类 is a 父类”, 父类更通用，子类更具体
*子类继承父类后，子类就拥有了父类全部的非private属性和行为
* 当父类方法不能满足子类需求，可以对父类继承的方法进行重写,重写只是针对方法，不针对属性，重写后子类只拥有重写后的方法
* 另外可以在父类的基础上新增成员变量和方法
* 脑海中要有子类所拥有的的成员变量和方法
* java只支持单继承
* 构造器不支持继承
* */


public class Animal {
    String name;

    public Animal() {
        System.out.println("Animal 空参构造器被调用");
    }

    public Animal(String name) {
        this.name = name;
    }

    public void move(){
        System.out.println("动物在移动");
    }

    public void sleep(){
        System.out.println("动物睡觉");
    }

    public void drink(){
        System.out.println("动物喝水");
    }

    //父类private方法对子类不可见，所有不能被重写
    private void m(){
        System.out.println("这是私有方法");
    }

    public static void statics(){
        System.out.println("这是static method");
    }

}






class Bird extends Animal {

    String wing;

    public Bird() {
        System.out.println("bird 空参构造");
    }

    public Bird(String wing) {
        this.wing = wing;
        System.out.println("Bird(String wing)被调用");
    }

    @Override
    public void move() {//重写时权限修饰符权限不能比原来小
        System.out.println("Birds fly");//重写就是对父类方法体进行重写
    }

    public void fly(){
        System.out.println("bird飞翔");
    }


    /*
        父类private方法对子类不可见，所有不能重写
        @Override
        private void m(){
        System.out.println("重写父类私有方法");
        }
    */






    public static void main(String[] args) {

        //注意父子类构造器调用顺序
        new Bird("一双翅膀");


        //new Bird("一双翅膀").m();父类private方法对子类不可见，所有不能被调用


        //static方法被继承，Bird类也拥有了这个静态方法,当然父类也拥有这个静态方法
        Bird.statics();
        Animal.statics();















    }

}


