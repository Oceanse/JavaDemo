package com.demo.generic.demo1;

import com.demo.collection_map.collection.list.model.Apple;
import com.demo.collection_map.collection.list.model.Fruit;
import com.demo.collection_map.collection.list.model.Grape;
import com.demo.collection_map.collection.list.model.Orange;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制
 * <p>
 * 泛型，即“参数化类型（类型参数化，实参就是具体的类型）”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
 * 参数化类型就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。
 * <p>
 * <p>
 * 泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法()，都带有<>
 * 泛型类、泛型接口、泛型方法声明的类型参数也被称之为类型变量，
 * 泛型类、泛型接口的属性方法可以使用泛型变量，我们可以称这些属性或者方法为“带泛型的属性方法”或者“使用泛型的属性方法”， 因此带泛型的属性方法必须出现在泛型类中;
 * 泛型方法或者泛型属性和泛型类无关，他们可以出现在非泛型类中
 */
public class GeneriDemo {

    @Test
    public void test() {
        //ArrayList不带泛型可以存放任意数据类型程，所以导致序运行后会发生ClassCastException
        ArrayList names = new ArrayList();
        names.add("TOM");
        names.add("MARRY");
        names.add(123);
        for (Object o : names) {
            String str = ((String) o).toUpperCase();//java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        }


        //使用泛型后，编译器会在编译阶段就能够帮我们发现错误
        //java7之前，必须写成：ArrayList<Integer> b = new ArrayList<Integer>();
        //在Java7中是可以通过前面的类型参数去推导出ArrayList中的数据类型的，也就是类型参数不需要了，但是这个<>尖括号是必须的，至于尖括号中的类型，是可以自动被推导出来的，这个就叫做菱形语法，为啥叫菱形语法嘞，因为这个<>尖括号像菱形啊…
        //这里的Integer就是类型实参，类型形参在泛型类的定义中：public class ArrayList<E>
        ArrayList<Integer> b = new ArrayList<>();
        b.add(256);
        b.add(65536);
        //b.add(1024.0); 在编译阶段，编译器就会报错

        Map<String, Integer> info = new HashMap<>();
        info.put("ocean", 28);
        //map.put("hyp",27.5)   在编译阶段，编译器就会报错
    }


    /**
     * java中的泛型，只在编译阶段有效。
     * 泛型信息在进入到运行时阶段前会被擦出,也就是在生成的 Java 字节代码中是不包含泛型中的类型信息的。
     * 如在代码中定义的 List<Integer> 和 List<String> 等类型，在编译之后都会变成 List。JVM 看到的只是 List，
     * 因此泛型附加的类型信息对 JVM 来说是不可见的
     */
    @Test
    public void test2() {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();
        System.out.println(stringArrayList.getClass());
        System.out.println(integerArrayList.getClass());
    }


    /**
     * 迭代器支持泛型
     */
    @Test
    public void test3() {
        //泛型(about generic)
        ArrayList<Fruit> fruit = new ArrayList<>();
        fruit.add(new Apple());
        fruit.add(new Grape());
        fruit.add(new Orange());

        Iterator<Fruit> iterator = fruit.iterator();//iterator支持泛型
        while (iterator.hasNext()) {
            Fruit next = iterator.next();//没有使用泛型，会返回Object类型
            if (next instanceof Apple) {
                System.out.println("apple is here");
            }
        }
    }

    @Test
    public void test4() {
        //泛型(about generic)
        ArrayList<Fruit> fruit = new ArrayList<>();
        fruit.add(new Apple());
        fruit.add(new Grape());
        fruit.add(new Orange());

        for (Fruit fruit1 : fruit) {//使用泛型后fruit1是Fruit类型
            if (fruit1 instanceof Apple) {
                System.out.println("apple is here");
            }
        }
    }
}