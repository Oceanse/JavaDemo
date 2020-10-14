package com.demo.generic.demo3;

import com.demo.generic.demo2.GenericClassDemo;

//继承时指名泛型类型K V，所有使用泛型的地方都要替换成指明的类型
public class SubGenericClassDemo extends GenericClassDemo<String, Integer> {
    public SubGenericClassDemo(String name, Integer age) {
        super(name, age);
    }

    public static void main(String[] args) {
        SubGenericClassDemo s=new SubGenericClassDemo("ocean",30);
        String name = s.getKey();
        Integer value = s.getValue();
        System.out.println(name+":"+value);

    }
}
