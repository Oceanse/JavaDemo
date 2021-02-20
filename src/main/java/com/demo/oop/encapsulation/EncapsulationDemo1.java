package com.demo.oop.encapsulation;

/**
 * 封装的定义：
 * 把该隐藏的隐藏起来，把该暴露的暴露出来
 * 封装将类的某些信(成员变量/工具类方法)息隐藏在类内部，不允许外部程序直接访问，只能通过该类提供的方法(setter/getter)来实现对隐藏信息的操作和访问。
 *
 * 例如：一台计算机内部极其复杂，有主板、CPU、硬盘和内存， 而一般用户不需要了解它的内部细节，不需要知道主板的型号、CPU主频、硬盘和内存的大小，
 * 于是计算机制造商将用机箱把计算机封装起来，对外提供了一些接口，如鼠标、键盘和显示器等，这样当用户使用计算机就非常方便。
 * 另外类的定义可以看成是将构成类的成员变量和方法封装起来；这就是最宏观的封装；
 * 方法是一段功能代码的封装，也是某种意义上的封装；
 *
 * 封装的特点：
 * 隐藏类的实例细节，方便修改和实现。
 * 只能通过规定的方法访问数据。在对外暴露的方法中，可以加入自己的控制逻辑
 *
 * 优点：
 * 隐藏细节
 * 控制逻辑
 * 高内聚，低耦合，方便维护扩展
 *
 * 案例：
 *  1 private隐藏属性
 *    private 修饰属性完成了对自身对象一定程度的封装，只能类本身访问；
 *    然后对外提供接口(加入属性控制语句,对属性值的合法性进行判断)，外部程序可以通过这个接口访问或者修改private属性
 *
 *  2 private隐藏内部工具类方法，因为这些工具类方法主要供类内使用，不需要对外开放
 *
 *  3 使用protected修饰某个方法通常是希望子类来override这个方法
 *
 *
 *
 */
public class EncapsulationDemo1 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(100);
        p.setName("father");
        System.out.println(p.getAge());
    }

}

class Person {

    private int age;//Person类外面不能访问该属性

    private String name;


    /**
     * 在对外暴露的方法中，可以加入自己的控制逻辑
     * @param name
     */
    public void setName(String name) {
        //参数检查，这样外部代码就没有任何机会把name设置成不合理的值。
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }



    /**
     * 在对外暴露的方法中，可以加入自己的控制逻辑
     * @param age
     */
    public void setAge(int age) {
        //参数检查，这样外部代码就没有任何机会把age设置成不合理的值。
        if (age > 0 && age < 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
