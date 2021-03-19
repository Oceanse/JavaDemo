package com.demo.basicdemo.code_block.static_block.demo3;


/**
 * Java对象的初始化顺序:
 *
 *     基类静态代码块，基类静态成员字段 （并列优先级，按代码中出现先后顺序执行）
 *     派生类静态代码块，派生类静态成员字段 （并列优先级，按代码中出现先后顺序执行）
 *     基类普通代码块，基类实例成员字段 （并列优先级，按代码中出现先后顺序执行）
 *     基类构造函数
 *     派生类普实例码块，派生类实例成员字段 （并列优先级，按代码中出现先后顺序执行）
 *     派生类构造函数
 *
 *
 *   静态代码块随着类的加载而被执行，只要类被加载了就会执行，所以在加载父类子类.class到内存时候(main方法之前)就会被执行，所以首先会执行父类和子类中的静态代码块
 *   实例代码块使用来初始化对象的，是在创建对象的时候被调用，而实例代码块又在构造器之前被执行，所以会接着调用父类实例代码块和构造器，完成父类对象创建
 *   然后调用子类类实例代码块和构造器，完成子类对象创建
 */
public class StaticBlock3 {

    private static String nation="America";


    public StaticBlock3() {
        System.out.println("StaticBlock3()构造函数");
    }

    {
        System.out.println("StaticBlock3 实例代码块");
    }

    static {
        System.out.println("父类静态代码块");
        nation="China";
    }


    public static String getNation() {
        return nation;
    }
}

class Kid extends StaticBlock3 {

    public Kid() {
        System.out.println("Kid()构造函数");
    }

    {
        System.out.println("Kid 实例代码块");
    }

    static {
        System.out.println("子类静态代码块");
        company="Ericsson";
    }

    private static String company="Tencent";

    public static String getCompany() {
        return company;
    }
}


class OrderTest{
    public static void main(String[] args) {
        Kid k=new Kid();
        System.out.println(k.getNation());
        System.out.println(k.getCompany());

    }
}