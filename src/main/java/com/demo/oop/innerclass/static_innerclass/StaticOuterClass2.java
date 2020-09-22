package com.demo.oop.innerclass.static_innerclass;

import com.demo.oop.innerclass.instance_innerclass.OuterClass2;

/**
 * 静态内部类也是定义在一个类里面的类，只不过在类的前面多了一个关键字static
 * 静态内部类可以想象成静态属性或者静态方法，是不需要依赖于外部类对象而存在，所以在没有外部类的对象的情况下，也可以创建静态内部类的对象
 * 静态内部类不能直接访问或者通过OutterClass.this访问外部类的非static成员变量或者方法，只能通过外部类对象访问外部类实例成员变量
 * 外部类内部通过 内部类类名.静态成员 或者 外部类类名.内部类类名.静态成员 来访问内部类静态成员
 *
 * 外部类中创建静态内部类对象：OuterClass.InnerClass in=new OuterClass.InnerClass()
 *
 */
public class StaticOuterClass2 {

    private String name="outname";
    private static int age=30;





    static class InnerClass{
        private String name="inname";
        private static double weight =125.0;

        /**
         * 这是静态内部类的一个实例方法，可以访问内部类中的实例属性和实例方法
         * 可以访问外部类静态方法或者静态属性
         * 静态内部类不可以直接访问外部类实例成员变量
         *
         */
        public void showName(){
            System.out.println(this.name);//this代指内部类对象引用
            System.out.println(StaticOuterClass2.age);//可以访问外部类静态属性
            //System.out.println(StaticOuterClass.this.name);//静态内部类不可以访问外部类实例成员变量
            System.out.println(new StaticOuterClass2().name);//只能通过外部类对象访问外部类实例成员变量
        }
    }

    public static void main(String[] args) {
        //这里实际上是StaticOuterClass2.InnerClass in2=new StaticOuterClass2.InnerClass() 外部类内部声明内部类对象时候会自动添加上外部类限制符
        InnerClass in=new InnerClass();
        in.showName();
    }
}
