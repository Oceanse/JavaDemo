package com.demo.basicdemo.keywords.finals.final_class_method;







public class Shoes {

    /**
     * final修饰的的属性一旦初始化后就不能修改
     */
    public static final String material = "xxx";

    /**
     * final修饰的方法不能被重写
     */
    public final void function() {
        System.out.println("walk.....");
    }

    private final void function2() {
        System.out.println("xxx.....");
    }

    public String showMaterial() {
        return null;
    }

}


/**
 * final修饰的类不能被继承
 * final修饰某个类，里面的方法会自动成为final方法·
 */
final class SportShoes extends Shoes {


    @Override
    public String showMaterial() {
        return super.showMaterial();
    }

    /*
    重写父类final方法编译报错
    @Override
    public void function(){
        System.out.println("run.....");
    }
    */




    /*只是添加@Override也会被认为是重写
    @Override
    public void function(){
    }
    */



    /*
    不加 @Override也会认为是重写，编译报错
    public void function(){
        System.out.println("run.....");
    }*/


    /**
     * 对千一个private方法，因为它仅在当前类中可见，其子类无法访问该方法，所以子类无法重写该
     * 方法一如果子类中定义一个与父类private方法有相同方法名、相同形参列表、相同返回侦类型的方
     * 法，也不是方法重写，只是重新定义了一个新方法。因此，即使使用final修饰一个private访问权限的
     * 方法，依然可以在其子类中定义与该方法具有相同方法名、和同形参列表、相同返回值类型的方法。
     */
    private final void function2() {
        System.out.println("xxx.....");
    }


}

// class RunShoes extends SportShoes{ }  final class不允许被继承


