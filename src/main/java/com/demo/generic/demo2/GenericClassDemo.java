package com.demo.generic.demo2;

import java.sql.Date;

/**
 * 泛型类
 */
public class GenericClassDemo<K, V> {//此处K V是是类型参数，也被称为一个类型变量,实例化时候指定具体的类型

    //泛型类、泛型接口的属性方法可以使用泛型变量，我们可以称这些属性或者方法为“带泛型的属性方法”或者“使用泛型的属性方法”， 因此带泛型的属性方法必须出现在泛型类/接口中;
    private K key;
    private V value;

    public GenericClassDemo() {
    }

    public GenericClassDemo(K k, V v) {
        key = k;
        value = v;
    }

    //泛型类、泛型接口的属性方法可以使用泛型变量，我们可以称这些属性或者方法为“带泛型的属性方法”或者“使用泛型的属性方法”， 因此带泛型的属性方法必须出现在泛型类中/接口;
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void test(){
        //实例化时候指定具体的参数类型，类型参数只能是类类型，不能是基本类型。
        GenericClassDemo<String, String> c1 = new GenericClassDemo<String, String>("name", "findingsea");
        GenericClassDemo<String, Integer> c2 = new GenericClassDemo<String, Integer>("age", 24);

        String key = c1.getKey();
        String value = c1.getValue();

        String key2 = c2.getKey();
        Integer value2 = c2.getValue();

        System.out.println(key + " : " + value);
        System.out.println(key2 + " : " + value2);
    }

    public static void test2(){
        //实例化时候没有指定具体的参数类型，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        GenericClassDemo c1 = new GenericClassDemo("name", new Date(System.currentTimeMillis()));
        GenericClassDemo c2 = new GenericClassDemo(true, new Double[]{1.0,2.0});

        //只能用Object接收
        Object key = c1.getKey();
        Object value = c1.getValue();

        Object key2 = c2.getKey();
        Object value2 = c2.getValue();

    }

    public static void main(String[] args) {
        test();
    }
}