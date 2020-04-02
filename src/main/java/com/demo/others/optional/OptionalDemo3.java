package com.demo.others.optional;

import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalDemo3 {
    /**
     * 转换值
     * /map方法执行传入的lambda表达式参数对Optional实例的值进行修改,修改后的返回值仍然是一个Optional对象
     */
    @Test
    public void test(){

        Optional<Key> mykey = Optional.ofNullable(new Key("mykey"));
        Optional<String> s = mykey.map(item -> item.getAttr());
        System.out.println(s.get());
    }


    @Test
    public void test2(){

        Optional<String> stringOptional = Optional.of("zhangsan");
        String s = stringOptional.map(e -> e.toUpperCase()).orElse("失败");
        System.out.println(s);

        stringOptional = Optional.empty();
        String s2 = stringOptional.map(e -> e.toUpperCase()).orElse("失败");
        System.out.println(s2);
    }


    /**
     * 过滤值
     * 如果创建的Optional中的值满足filter中的条件，则返回包含该值的Optional对象，否则返回一个空的Optional对象
     * 注意Optional中的filter方法和Stream中的filter方法是有点不一样的，Stream中的filter方法是对一堆元素进
     * 行过滤，而Optional中的filter方法只是对一个元素进行过滤
     */
    @Test
    public void test3(){

        Optional<Key> key = Optional.ofNullable(new Key("mykey")).filter(item -> item.getAttr().equals("mykey"));//包含一个元素的Optional对象
        key.ifPresent(item->System.out.println(item.getAttr()));
        System.out.println("=======");
        Optional<Key> key2 = Optional.ofNullable(new Key("mykey")).filter(item -> item.getAttr().equals("yuourkey"));//空的Optional对象
        key2.ifPresent(item->System.out.println(item.getAttr()));//key为空，所以这里不会被执行
    }


    @Test
    public void test4(){
        Key key = Optional.ofNullable(new Key("mykey")).filter(item -> item.getAttr().equals("yuourkey")).orElseGet(() -> new Key("com/demo/others"));//过滤条件不满足则执行orElseGet
        System.out.println(key.getAttr());
    }
}
