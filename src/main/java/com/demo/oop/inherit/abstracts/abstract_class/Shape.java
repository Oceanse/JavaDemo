package com.demo.oop.inherit.abstracts.abstract_class;

/*
以抽象类作为其子类的模板，从而避免了子类的随意性。

从多个具有相同特征的类中抽出一个抽象类
* 是对一系列看上去不同，但是本质上相同的具体概念的抽象。
*
* 实现设计（方法只有声明没有实现）与实现（子类完成）分开
*
* 包含抽象方法的类
*
*  从设计层面看，抽象类体现继承关系（is-a）(is-a指的是类的父子继承关系)，
*  它主要描述类的从属关系或者父子关系，抽象类和它的派生类之间是典型的IS-A关系，即“子is a父”。
 * */


public abstract class Shape {
    public abstract void area();
    public abstract void perimete();
}

class Rectanngle extends Shape{

    private double length;
    private double width;


    public Rectanngle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void area() {
        System.out.println("Rectangle area: "+length*width);
    }

    @Override
    public void perimete() {
        System.out.println("Rectangle perimete: "+2*(length+width));
    }
}

class Circle extends Shape{

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void area() {
        System.out.println("Circle area: "+Math.PI*r*r);
    }

    @Override
    public void perimete() {
        System.out.println("Circle perimeter: "+Math.PI*2*r);
    }
}


class Test{

    public void findInfo(Shape s){
        s.area();
        s.perimete();
    }

    public static void main(String[] args) {
    new Test().findInfo(new Rectanngle(1,2));
    new Test().findInfo(new Circle(1));
    }
}
