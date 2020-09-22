package com.demo.basicdemo.keywords.finals;


/**
 * 当final修饰变量属于引用类型变量时候，仅表示这个变量保存的地址或者指向的对象时不可变的，但是对象的内容确时可变的，
 * 这就不符合不可变类的初衷；期待结果是变量指向的对象和这个对象都不能被修改
 * 就是要保证final引用变量指向的对象没有其他手柄指向它
 */
public class Unmutable_Instance4 {
    private final Computer computer;


    /**
     * computer指向的对象只有一个手柄
     * @param computer
     */
    public Unmutable_Instance4(Computer computer) {
        this.computer = new Computer(computer.getBrand());
    }

    public Computer getComputer() {
        return computer;
    }

    public static void main(String[] args) {
        Computer computer=new Computer("lennovo");
        Unmutable_Instance4 unmutable_instance4 = new Unmutable_Instance4(computer);
        System.out.println(unmutable_instance4.getComputer().getBrand());

        computer.setBrand("Mac");
        System.out.println(unmutable_instance4.getComputer().getBrand());
    }
}

class Computer{
    String brand;

    public Computer(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
