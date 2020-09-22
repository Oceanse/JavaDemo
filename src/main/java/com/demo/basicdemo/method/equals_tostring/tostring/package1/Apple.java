package com.demo.basicdemo.method.equals_tostring.tostring.package1;

import org.testng.annotations.Test;

/**
 *  The toString() method returns the string representation of the object.
 *
 * 1 toString方法是Object里面已经有了的方法，而所有类都是继承Object，因此所有对象都有这个方法
 *
 * 2 Object的toString()源码分析：
 *   public String toString() {
 *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *     }
 *   返回: 全类名+hashcode
 *
 * 3 某些特定的方法，比如print方法会自动在对象后面加toString(),详述如下：
 *   若obj是非String引用类型
 *   System.out.println(obj) 等价于 System.out.println(obj.toString())
 *
 *  4 原生的toString打印出来的信息可能并不是我们想要的，所以热河一个类可以对其进行重写来得到有意义的输出
 *
 *
 *
 */
public class Apple {
    String color;

    public Apple(String color) {
        this.color = color;
        System.out.println("Apple(String info).....");
    }


    /**
     * 自动调用继承过来的toString
     * 输出： com.demo.basicdemo.method.equals_tostring.tostring.package1.Apple@1d16f93d
     */
    @Test
    public  void test(){
        System.out.println(new Apple("red"));//compiler writes here: new Apple("red").toString()
    }


    /**
     * 手动调用继承过来的toString
     * 输出： com.demo.basicdemo.method.equals_tostring.tostring.package1.Apple@1d16f93d
     */
    @Test
    public  void test2(){
        System.out.println(new Apple("red").toString());
    }

    /**
     * 这里不会自动调用继承过来的toString
     * @return
     */
    @Test
    public  Apple test3(){
        return new Apple("red");
    }

    /**
     * 手动调用继承过来的toString
     * @return
     * 这里的返回值是：com.demo.basicdemo.method.equals_tostring.tostring.package1.Apple@1d16f93d
     */
    @Test
    public  String test4(){
        return new Apple("red").toString();
    }





    /**
     * 包装类Byte Short Integer Long Float Double Character Boolean重写了toString
     */
    @Test
    public void test5(){

        String name="ocean";
        System.out.println(name);
        System.out.println(name.toString());


        System.out.println(new Character('a').toString());
        System.out.println(new Character('a'));
    }


}
