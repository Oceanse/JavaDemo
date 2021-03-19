package com.demo.basicdemo.keywords.finals.unmutable_instance.demo2;

import java.util.Arrays;

/**
 * 当final修饰变量属于引用类型变量时候，仅表示这个变量保存的地址或者指向的对象时不可变的，但是对象的内容确是可变的，
 */
public class Fruit {

    private final String[] kinds;//成员类型是引用类型，即使final修饰，该成员指向的对象还是可以改变，也就是Fruit对象的内容还是可以发生变化

    public Fruit(String[] kinds) {
         this.kinds = kinds;
    }

    public String[] getKinds() {
        return kinds;
    }



    /**
     * kinds 和形参 fruitKinds 指向同一块内存地址，用户可以在 Fruit 实例之外通过 fruitKinds修改 数组对象的值
     * @param args
     */
    public static void main(String[] args) {
        String[] fruitKinds=new String[]{"Apple","banana","orange"};
        Fruit fruit=new Fruit(fruitKinds);//kinds 和形参 fruitKinds 指向同一块内存地址(数组对象)
        System.out.println(Arrays.toString(fruit.getKinds()));

        //成员变量myArray指向的数组对象发生了改变
        fruitKinds[0]="grape";
        System.out.println(Arrays.toString(fruit.getKinds()));

    }
}
