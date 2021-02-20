package com.demo.collection_map.collection.list;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda_List {

    /**
     * forEach是Iterable接口的一个default方法:Performs the given action for each element
     * forEach接受的是一个函数型接口Consumer对象，这个接口唯一的抽象方法：void accept(T t);
     */
    @Test
    public void test1() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);

        //打印所有数
        ls.forEach(x -> System.out.print(x + " "));
        ls.forEach(System.out::println);//:: 把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下

        //只打印偶数
        System.out.println();
        ls.forEach(n -> {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        });

        //打印所有数的平方
        System.out.println();
        ls.forEach(x -> System.out.print(square(x) + " "));

    }


    /**
     * Stream是1.8新加入的接口
     * stream()方法是Collection接口的一个default方法：default Stream<E> stream(){xxx} 可以返回Stream对象
     * filter方法：Stream<T> filter(Predicate<? super T> predicate); 是Stream接口的一个抽象方法，接受一个函数型接口Predicate对象
     * 这个接口中的抽象方法：boolean test(T t);
     * Returns a stream consisting of the elements of this stream that match the given predicate.
     */
    @Test
    public void test2() {
        List<String> ls = new ArrayList<>();
        ls.add("apple");
        ls.add("banana");
        ls.add("orange");
        ls.add("grape");

        Stream<String> favoriteFruit = ls.stream().filter(item -> (item.equals("apple") || item.startsWith("g")));
        //等价于：Stream<String> favoriteFruit = ls.stream().filter(item -> {return (item.equals("apple") || item.startsWith("g"));});
        List<String> ff = favoriteFruit.collect(Collectors.toList());
        System.out.println(ff);
    }

    @Test
    public void test2_2() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(5);
        ls.add(2);
        ls.add(2);
        ls.add(7);
        ls.add(4);
        List ls2 = ls.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        Set set = ls.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
        System.out.println(ls);
        System.out.println(ls2);
        System.out.println(set);
    }




    /**
     * Stream<T> limit(long maxSize);
     */
    @Test
    public void test3() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(6);
        ls.add(2);
        ls.add(7);
        ls.add(4);
        Stream<Integer> limit = ls.stream().filter(n -> n % 2 == 0).limit(2);
        List ls2 = limit.collect(Collectors.toList());
        System.out.println(ls2);

        //等价于：
        List ls3 = ls.stream().filter(n -> n % 2 == 0).limit(2).collect(Collectors.toList());
        System.out.println(ls3);
    }


    /**
     * Stream<T> sorted();
     */
    @Test
    public void test4() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(6);
        ls.add(2);
        ls.add(7);
        ls.add(4);
        Stream<Integer> sort = ls.stream().filter(n -> n % 2 == 0).sorted();
        List ls2 = sort.collect(Collectors.toList());
        System.out.println(ls2);

        //等价于：
        List ls3 = ls.stream().filter(n -> n % 2 == 0).sorted().limit(2).collect(Collectors.toList());
        System.out.println(ls3);
    }


    /**
     * long count(): return the count of elements in this stream
     */
    @Test
    public void test5() {

        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(6);
        ls.add(2);
        ls.add(7);
        ls.add(4);

        long num = ls.stream().filter(n -> n % 2 == 0).count();
        long num2 = ls.stream().filter(n -> n % 2 == 0).limit(10).count();
        System.out.println(num);
        System.out.println(num2);
    }




    /**
     * Stream<R> map(Function<? super T, ? extends R> mapper);
     * 被重写的函数型接口中的抽象方法是：R apply(T t);
     */
    @Test
    public void test6() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(6);
        ls.add(2);
        ls.add(7);
        ls.add(4);

        //如果大括号内有且仅有一个语句且需要返回值，那么可以同时省略大括号、return关键字及语句分号
        Stream<Integer> map = ls.stream().map(n -> n * n);

        //完整写法
        Stream<Integer> map2 = ls.stream().map(n -> {
            return n * n;
        });
        List ls2 = map.collect(Collectors.toList());
        List ls3 = map2.collect(Collectors.toList());
        System.out.println(ls);//ls没有发生改变
        System.out.println(ls2);
        System.out.println(ls3);
    }


    @Test
    public void test6_2() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(6);
        ls.add(2);
        ls.add(7);
        ls.add(4);

        //多条语句必须用{}
        Stream<Integer> map = ls.stream().map(n -> {
            int i = n * n;
            return i;
        });
        List ls2 = map.collect(Collectors.toList());
        System.out.println(ls);//ls没有发生改变
        System.out.println(ls2);
    }


    @Test
    public void test6_3() {
        List<String> ls = new ArrayList<>();
        ls.add("abc");
        ls.add("bcd");
        ls.add("cde");
        //把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下
        List ls2 = ls.stream().map(String::toUpperCase).collect(Collectors.toList());
    }




    /**
     * boolean anyMatch(Predicate<? super T> predicate);
     * 实现Predicate这个接口中的抽象方法：boolean test(T t);
     *
     * anyMatch，allMatch，noneMatch
     * anyMatch流中存在一个元素满足指定的条件那么返回true
     * allMatch流中所有元素满足指定的条件那么返回true
     * noneMatch流中所有元素都不满足指定的条件那么返回true
     */

    @Test
    public void test7() {

        List<String> strs = Arrays.asList("a", "a", "c", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
        boolean dd = strs.stream().noneMatch(str -> str.equals("e"));
        System.out.println(aa);// TRUE
        System.out.println(bb);// FALSE
        System.out.println(cc);// FALSE
        System.out.println(dd);// TRUE
    }


    /**
     * Stream 可以并行化操作，迭代器只能命令式地、串行化操作。顾名思义，
     * 当使用串行方式去遍历时，每个 item 读完后再读下一个 item。而使用并行去遍历时，
     * 数据会被分成多个段，其中每一个都在不同的线程中处理，然后将结果一起输出,
     * Stream 的并行操作依赖于 Java7 中引入的 Fork/Join 框架（JSR166y）来拆分任务和加速处理过程
     * parallelStream其实就是一个并行执行的流.它通过默认的ForkJoinPool,可能提高你的多线程任务的速度
     */
    @Test
    public void test8() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.stream().forEach(ele -> System.out.print(ele + " "));//输出顺序是固定的
        System.out.println();
        ls.parallelStream().forEach(ele -> System.out.print(ele + " "));//并行流遍历造成输出结果顺序是随机的

        //如果平行处理时，希望最后顺序是按照原来Stream的数据顺序，那可以调用forEachOrdered()
        System.out.println();
        ls.parallelStream().forEachOrdered(ele -> System.out.print(ele + " "));
    }






    public static int square(int i) {
        return i * i;
    }

}
