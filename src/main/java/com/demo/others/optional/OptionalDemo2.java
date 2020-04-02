package com.demo.others.optional;

import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 *
 */
public class OptionalDemo2 {

    @Test
    public void test(){
        Optional<String> ocean = Optional.ofNullable("ocean");
        assertEquals(ocean.get(),"ocean");
    }

    @Test
    public void test2(){
        Optional<String> ocean = Optional.ofNullable(null);
        System.out.println(ocean.isPresent());//isPresent()判断Optional容器是否为空
        assertFalse(false);
    }


    /**
     * 检查是否有值的另一个选择是 ifPresent() 方法。该方法除了执行检查，
     * 还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式：
     */
    @Test
    public void test3(){
        Optional<String> ocean = Optional.ofNullable(null);
        ocean.ifPresent(item-> System.out.println("null==>"+item));

        Optional<String> ocean2 = Optional.ofNullable("ocean");
        ocean2.ifPresent(item-> System.out.println(item));
    }


    /**
     * Optional 类提供了 API 用以返回对象值，或者在对象为空的时候返回默认值。
     * 这里你可以使用的第一个方法是 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值
     */
    @Test
    public void test4(){
        Object name = Optional.ofNullable(null).orElse("ocean");
        System.out.println(name);

        Object name2 = Optional.ofNullable("oceans").orElse("ocean");
        System.out.println(name2);
    }


    /**
     * 无论Optional是否为空容器，orElse一定会被执行，只是orElse得到的结果可能被采纳，也可能不被采纳
     */
    @Test
    public void test5(){
        Object key = Optional.ofNullable(null).orElse(new Key("mykey"));
        System.out.println(key);

        Object key2 = Optional.ofNullable(new Key("k1")).orElse(new Key("k2"));
        System.out.println(key2);
    }

    /**
     * orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，如果没有值，
     * 它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果：
     *
     * 当Optional是空容器时候，orElseGet才会被执行
     */
    @Test
    public void test6(){
        Object key = Optional.ofNullable(null).orElseGet(()->new Key("mykey"));
        System.out.println(key);

        Object key2 = Optional.ofNullable(new Key("k1")).orElseGet(()->new Key("k2"));
        System.out.println(key2);
    }

}


class Key{

    String attr;

    public Key(String attr) {
        this.attr=attr;
        System.out.println("Key("+attr+")is called");
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "Key{" +
                "attr='" + attr + '\'' +
                '}';
    }
}