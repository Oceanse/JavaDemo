package com.demo.oop.inherit.abstracts.abstract_class.demo1;

/**
*
*
 * 抽象类是将子类所共同拥有的属性和普通/抽象方法进行抽取(其中的抽象方法的实现还无法确定，需要子类进行实现和具体化),它比普通的类具有更高层次的抽象
 *
 * 从设计层面看，抽象类体现继承关系（is-a）(is-a指的是类的父子继承关系)，
 * 它主要描述类的从属关系或者父子关系，抽象类和它的派生类之间是典型的IS-A关系，即“子is a父”。
 *
 * 抽象类体现的是一种模板设计模式，以抽象类作为模板，避免子类设计的随意性
 *
 * 抽象类：拥有抽象方法的类就是抽象类
 *       抽象类一定要使用abstract关键字声明, 它可以包含或者不包含抽象方法；
 * 抽象方法：是指没有方法体的方法(和抽象方法相对应的就是具象方法，也就是具象方法有着具体的方法实现);
 *         抽象类中的抽象方法还必须使用关键字abstract做修饰。由于抽象方法需要被子类重写实现，所以不能是private和static
 *
 * 构造器：抽象类可以包含构造器，但是不能被实例化，因为因为抽象类中方法未具体化
 *
 * 继承和实现： 子类继承父类并实现抽象方法，为后面的多态作准备
 *
 * */


public abstract class Shape {
    public abstract void area();
    public abstract void perimeter();
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
    public void perimeter() {
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
    public void perimeter() {
        System.out.println("Circle perimeter: "+Math.PI*2*r);
    }
}


class Test{

    //多态运用
    //Shape s=new Rectanngle(double length, double width)
    //Shape s=new Circle(double r)
    public void findInfo(Shape s){
        s.area();
        s.perimeter();
    }

    public static void main(String[] args) {
    new Test().findInfo(new Rectanngle(1,2));
    new Test().findInfo(new Circle(1));
    }
}
