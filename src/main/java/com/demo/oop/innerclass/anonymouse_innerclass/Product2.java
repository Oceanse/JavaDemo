package com.demo.oop.innerclass.anonymouse_innerclass;


/**
 * 匿名内部类：首先是没有类名，其次有一个定义类的过程，它与局部类很相似，不同的是它没有类名
 *
 *
 * 匿名内部类使用场景：
 *  当接口的实现类只是使用一次的话，采用implements创建实现类并实例化显得资源浪费， 所以可以采用匿名内部类创建接口实现类实例
 *  匿名内部类适合只需要一次使用的类
 *  Anonymous classes enable you to make your code more concise.
 *  They enable you to declare and instantiate a class at the same time
 *  Use them if you need to use a local class only once
 *
 * 优点： 匿名内部类可以使你的代码更加简洁，可以在定义一个类的同时对其进行实例化。
 *
 * 匿名内部类使用原则：
 *  1 匿名内部类必须继承一个且最多一个父类或者实现一个且最多一个接口，
 *  2 匿名内部类不能是抽象类，因为系统在创建匿名内部类时候会立即创建其对象
 *  3 匿名内部类不能定义构造器，因为它没有类名，但是可以定义初始化块
 *  4 匿名内部类创建使用后立即消失，不能重复使用
 *  5 通过实现接口创建匿名内部类对象只能使用默认隐式的的空参构造器，因此new()不能传入其他参数：    new 接口名(){。。。}
 *    但是通过继承抽象类，匿名内部类可以使用抽象父类所拥有的任何构造器：  new 抽象类名(实参列表){。。。}
 */
public abstract class Product2 {
    String name;
    double price;

    public Product2() {
    }

    public Product2(String name) {
        this.name = name;
    }

    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double getPrice();
    abstract String getName();
}

class AnonymouseTest2{

    public static void getProductInfo(Product2 product){
        System.out.println("name: "+product.getName()+" and price: "+product.getPrice());
    }



    public static void main(String[] args) {

        //new 抽象类名(实参列表){。。。}
        getProductInfo(new Product2("cellphone",3000){
            @Override
            double getPrice() {
                return price;
            }
            @Override
            String getName() {
                return name;
            }
        });


        //new 抽象类名(实参列表){。。。}
        getProductInfo(new Product2("book"){
            @Override
            double getPrice() {
                return price;
            }
            @Override
            String getName() {
                return name;
            }
        });


        //new 抽象类名(实参列表){。。。}
        getProductInfo(new Product2(){
            @Override
            double getPrice() {
                return price;
            }
            @Override
            String getName() {
                return name;
            }
        });

    }
}
