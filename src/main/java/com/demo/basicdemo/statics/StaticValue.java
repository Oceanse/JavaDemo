package com.demo.basicdemo.statics;



/*
static关键字修饰的变量，叫类变量或者静态变量,是类级别或者模板级别的变量，和具体的对象无关
java虚拟机在加载类的过程中为静态变量分配内存
静态变量位于方法区，被类的所有实例共享,可以节省内存
静态变量生命周期取决于类的生命周期。
类名.类变量或者对象.类变量访问，但是建议类名.类变量
* */
public class StaticValue {

    String name;
    Long id;
    static String nation="China";

    public StaticValue(String name, Long id) {
        this.name = name;
        this.id = id;
    }



    public static void main(String[] args) {
        StaticValue s=new StaticValue("ocean",123L);
        StaticValue s2=new StaticValue("ocean",123L);

        System.out.println(StaticValue.nation);
        System.out.println(nation);
        System.out.println(s.nation);
        System.out.println(s2.nation);


        //s和s2共享类变量nation
        s.nation="USA";
        System.out.println(s2.nation);

        //这里依然可以访问到nation
        s2=null;
        System.out.println(s2.nation);

    }
}
