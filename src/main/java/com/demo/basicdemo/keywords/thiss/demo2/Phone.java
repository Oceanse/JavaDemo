package com.demo.basicdemo.keywords.thiss.demo2;


public class Phone {
    private String brand;
    private double price;

    /**
     * this出现在构造器中时候表示正在创建的当前类对象
     * 形式参数和实例变量是相同的，所以要使用this关键字来区分。
     * @param brand
     */
    public Phone(String brand) {
        this.brand = brand;//"this" is required
    }


    /**
     * 第一个this用来调用当前类的构造函数，reusing constructor
     * 第二个this表示正在创建的当前类对象
     * @param brand
     * @param price
     */
    public Phone(String brand, double price) {
        this(brand);//this()必须是构造函数中的第一个语句
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    /**
     * this表示当前类的对象,所以可以this.成员变量或者this.方法
     */
    public void showBrand(){
        System.out.println(brand);//这里实际省略了this, JVM调用时候会自动加上this
        System.out.println(getBrand());//这里实际省略了this, JVM调用时候会自动加上this

        System.out.println(this.brand);//"this" is optional
        System.out.println(this.getBrand());//"this" is optional
    }


    /**
     * 静态方法不能
     * @param args
     */
    public static void main(String[] args) {
        //this.showBrand();
    }

}
