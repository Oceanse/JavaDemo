package com.demo.others.optional;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Optional;

/**
 * 从 Java 8 引入的一个很有趣的特性是 Optional类。要解决的问题是臭名昭著NullPointerException
 * Optional 是一个container object，可以把Optional看成是最多只包含一个元素的container
 *
 * get()方法访问空Optional对象时候会导致NoSuchElementException
 */
public class OptionalDemo {

    @Test
    public void test(){
        Optional<Object> emptyOpt = Optional.empty();//创建 Optional实例
        emptyOpt.get();//get访问 emptyOpt 变量的值会导致NoSuchElementException
    }

    @Test
    public void test2(){
        Optional<Object> opt = Optional.of("ocean");//of()方法创建Optional实例
        System.out.println(opt.get());
    }


    // null值作为参数传递进去，of()方法会抛出 NullPointerException：
    @Test
    public void test3(){
        Optional<Object> emptyOpt = Optional.of(null);//of方法创建Optional实例
        System.out.println(emptyOpt.get());
    }

    @Test
    public void test4(){
        Optional<Object> opt = Optional.ofNullable("ocean");//ofNullable方法创建Optional实例
        System.out.println(opt.get());
    }


    //ofNullable方法创建Optional实例时候可以传入null参数
    @Test
    public void test5(){
        Optional<Object> emptyOpt = Optional.ofNullable(null);//ofNullable方法创建Optional实例
        System.out.println(emptyOpt.get());//get访问 emptyOpt 变量的值会导致NoSuchElementException
    }


    @Test
    public void test6(){
        Optional<Integer> any = Arrays.asList(1, 2, 3, 4).stream().filter(n -> n % 2 == 0).findAny();//lambda创建Optional实例
        System.out.println(any.get());
    }

}
