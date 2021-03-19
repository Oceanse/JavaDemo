package com.demo.oop.inherit.abstracts.abstract_class.demo1;

/**
*
*
 * 抽象类是将子类所共同拥有的属性和普通/抽象方法进行抽取(其中的抽象方法的实现还无法确定，需要子类进行实现和具体化),它比普通的类具有更高层次的抽象
 * 当编写一个类时，常常会为该类定义一些方法，这些方法用以描述该类的行为方式， 那么这些方法
 * 都有具体的方法体。但在某些情况下，某个父类只是知道其子类应该包含怎样的方法，但无法准确地知
 * 道这些子类如何实现这些方法。例如定义了一个Shape 类， 这个类应该提供一个计算周长的方法
 * calPerimeter(), 但不同Shape子类对周长的计算方法是不一样的， 即Shape类无法准确地知道其子类计
 * 算周长的方法。可能有读者会提出， 既然Shape类不知道如何实现calPerimeterO方法， 那就干脆不要管它了！这不
 * 是一个好思路： 假设有一个Shape引用变量， 该变量实际上引用到Shape子类的实例， 那么这个Shape
 * 变量就无法调用calPerimeter()方法， 必须将其强制类型转换为其子类类型，才可调用caIPerimeter()方法，
 * 这就降低了程序的灵活性。如何既能让Shape类里包含calPerimeter()方法，又无须提供其方法实现呢？使用抽象方法即可满足
 * 该要求： 抽象方法是只有方法签名， 没有方法实现的方法。
 *
 *
 * 从设计层面看，抽象类体现继承关系（is-a）(is-a指的是类的父子继承关系)，
 * 它主要描述类的从属关系或者父子关系，抽象类和它的派生类之间是典型的IS-A关系，即“子is a父”。
 * 抽象类体现的是一种模板设计模式，以抽象类作为模板，避免子类设计的随意性
 *
 * 抽象类可以包含成员变量、方法（普通方法和抽象方法都可以）、构造器、初始化块、内部类（接口、枚举） 5种成分
 *
 * 抽象类：拥有抽象方法的类就是抽象类
 *       抽象类一定要使用abstract关键字声明, 它可以包含或者不包含抽象方法；
 * 抽象方法：是指没有方法体的方法(和抽象方法相对应的就是具象方法，也就是具象方法有着具体的方法实现);
 *         抽象类中的抽象方法还必须使用关键字abstract做修饰。由于抽象方法需要被子类重写实现，所以不能是private和static
 *
 * 构造器：抽象类可以包含构造器，但是不能被实例化，因为因为抽象类中方法未具体化；抽象类中的构造器在创建其子类的实例时被调用。
 *
 * 继承和实现： 子类继承父类并实现抽象方法，为后面的多态作准备
 *
 * static和 abstract
 * 除此之外，当使用static 修饰一个方法时，表明这个方法属千该类本身，即通过类就可调用该方法，
 * 但如果该方法被定义成抽象方法，则将导致通过该类来调用该方法时出现错误（调用了一个没有方法体
 * 的方法肯定会引起错误）。因此static 和abstract 不能同时修饰某个方法， 即没有所谓的类抽象方法。
 *
 *
 * private 和 abstract
 * abstract 关键字修饰的方法必须被其子类重写才有意义， 否则这个方法将永远不会有；
 * 方法体，因此abstract 方法不能定义为private 访问权限，即private 和abstract 不能同时修􀀂-
 * 饰方法。
 *
 * 归纳起来， 抽象类可用“有得有失" 4个字来描述。“得“ 指的是抽象类多了一个能力：抽象类可以包含抽象方法；
 * “失” 指的是抽象类失去了一个能力：抽象类不能用于创建实例。
 *
 * */


public abstract class Shape {

    //定义一个计算面积的抽象方法
    public abstract double area();

    //定义一个计算周长的抽象方法
    public abstract double perimeter();

    //定义一个返回形状的抽象方法
    public abstract String getType();

    {
        System.out.println("抽象类构造代码块");
    }
}

class Rectangle extends Shape{

    private double length;
    private double width;


    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        System.out.println("Rectangle area: "+length*width);
        return length*width;
    }

    @Override
    public double perimeter() {
        System.out.println("Rectangle perimeter: "+2*(length+width));
        return 2*(length+width);
    }

    @Override
    public String getType() {
        return "rectangle";
    }
}

class Circle extends Shape{

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        System.out.println("Circle area: "+Math.PI*r*r);
        return Math.PI*r*r;
    }

    @Override
    public double perimeter() {
        System.out.println("Circle perimeter: "+Math.PI*2*r);
        return Math.PI*2*r;
    }

    @Override
    public String getType() {
        return "circle";
    }
}


class Test{

    //多态运用
    //Shape s=new Rectangle(double length, double width)
    //Shape s=new Circle(double r)
    public static void findInfo(Shape s){
        System.out.println(s.getType());
        s.area();
        s.perimeter();
    }

    public static void getTotalArea(Shape... shapes){
        double totalArea=0;
        for (Shape shape : shapes) {
            totalArea=totalArea+shape.area();
        }
        System.out.println("total area is: "+totalArea);
    }

    public static void main(String[] args) {
        //findInfo(new Rectangle(1,2));
        //findInfo(new Circle(1));
        getTotalArea(new Rectangle(1,2),new Circle(1));
    }
}
