package com.demo.basicdemo.keywords.finals.unmutable_instance.demo3;

import java.util.Arrays;

/**
 * 关于不可变类：
 * 当final修饰的成员变量属于引用类型变量时候，仅表示这个变量保存的地址或者指向的对象时不可变的，但是对象的内容确时可变的，
 * 这就不符合不可变类的初衷；期待结果是变量指向的对象和这个对象的内容都不能被修改
 * 因此要保证final引用变量指向的对象没有其他手柄指向它，也就是保证只有final引用变量指向那个对象
 */
public class Fruit {
    private final String[] kinds;

    // 把数组对象拷贝一份，然后把副本(拷贝的拿分)的地址赋值给kinds，所以这里kinds和fruitKinds是指向两个地址不同、内容相同的数组
    public Fruit(String[] array) {
        this.kinds = array.clone();//array和array.clone()是两个对象
    }
    public String[] getKinds(){
        return kinds;
    }

    public static void main(String[] args) {
        String[] fruitKinds=new String[]{"Apple","banana","orange"};
        Fruit fruit=new Fruit(fruitKinds);//这里kinds和fruitKinds是指向两个地址不同、内容相同的数组
        System.out.println(Arrays.toString(fruit.getKinds()));

        //count的改变不会导致myArray的改变，所以成员变量myArray指向的数组对象不会发生改变
        fruitKinds[0]="grape";
        System.out.println(Arrays.toString(fruit.getKinds()));
    }
}
