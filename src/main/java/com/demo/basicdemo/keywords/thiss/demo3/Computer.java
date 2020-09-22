package com.demo.basicdemo.keywords.thiss.demo3;


public class Computer {
    String brand;
    double price;
    String cpu;



    public Computer(String brand, double price, String cpu) {
        //this用在构造函数中时候表示正在创建的当前类对象
        this.brand = brand;
        this.price = price;
        this.cpu = cpu;
    }

    /**
     * this关键字用来返回当前类
     * @return
     */
    public Computer getComputer(){
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
        System.out.println(new Computer("HP", 10000, "CORE i5").getComputer().toString());
    }
}
