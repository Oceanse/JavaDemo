package com.demo.basicdemo.keywords.thiss.demo3;


public class Computer2 {
    String brand;
    double price;
    String cpu;


    /**
     * 双惨构造函数， 这里的this用来调用当前类的重载构造函数，实现代码复用
     *
     * @param brand
     * @param price
     */
    public Computer2(String brand, double price) {
       this(brand,price,"core i5");
    }


    /**
     * this表示正在创建的当前类对象的引用
     *
     * @param brand
     * @param price
     * @param cpu
     */
    public Computer2(String brand, double price, String cpu) {
        this.brand = brand;
        this.price = price;
        this.cpu = cpu;
    }

    /**
     * this关键字用来返回当前类
     *
     * @return
     */
    public Computer2 getComputer() {
        return this;//谁调用我，我返回谁
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", cpu='" + cpu + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Computer2("HP", 10000, "CORE i5").getComputer().toString());
    }
}
