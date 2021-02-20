package com.demo.collection_map.collection.list;

import com.demo.collection_map.collection.list.model.Apple;
import com.demo.collection_map.collection.list.model.Fruit;
import com.demo.collection_map.collection.list.model.Grape;
import com.demo.collection_map.collection.list.model.Orange;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import com.demo.pojo.TestResourceinfo;

import java.util.*;


/**
 * ArrayList底层存储结构是数组
 * 集合只能存储引用(对象的内存地址)，不能存储基本数据类型，也不能存储对象，如果添加的是基本类型数据则会自动装箱
 * 有序可以重复
 *
 */
public class ArraylistDemo {


    /**
     * List的构造
     */
    @Test
    public void test(){

        //通过可变参数构造List, Returns a fixed-size list
        List list=Arrays.asList(1,2,3);
        System.out.println(list);//等价于ls.toString()， ArrayList重写了toString方法
        //list.add(1); //运行会报错

        //通过数组构造List, Returns a fixed-size list
        List list1=Arrays.asList(new int[]{1,2,3});
        //list1.add(1); //运行会报错


        List list2=new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list2);

        //通过List构造list
        List list3=new ArrayList(list2);
        System.out.println(list3);

        //通过Set构造list
        Set set =new HashSet();
        set.addAll(list3);
        List list4=new ArrayList(set);
        System.out.println(list4);
    }




    /**
     * 添加元素：public boolean add(E e)
     * 元素都一次添加在list的尾部，此时插入效率较高
     */
    @Test
    public void test1() {
        ArrayList<Object> container = new ArrayList();

        //集合只能存储引用(对象的内存地址)，不能存储基本数据类型，也不能存储对象，如果添加的是基本类型数据则会自动装箱，
        container.add(1);
        container.add(2.0f);
        container.add(3.0);
        container.add('@');
        container.add(true);
        container.add("abc");
        container.add(new TestResourceinfo());
        container.add(new com.demo.jetty.model.User());
        System.out.println(container.toString());//Collection集合重写了toString方法,相当于依次打印每个对象的toString
    }


    /**
     * 添加元素：public void add(int index, E element)
     * 会把所有元素往后移动一位，所以ArrayList首位或者中间部分插入数据效率较低
     */
    @Test
    public void test1_2() {
        ArrayList<Object> container = new ArrayList();
        container.add(1);
        container.add(2.0f);
        container.add(3.0);
        System.out.println(container);
        container.add(0,"first");
        container.add(1,"second");
        System.out.println(container);
    }

    /**
     * 添加元素：addAll(Collection<? extends E> c)
     */
    @Test
    public void test1_3() {
        ArrayList<Object> container = new ArrayList();
        container.add(1);
        container.add(2.0f);
        container.add(3.0);
        ArrayList container2 = new ArrayList();
        container2.addAll(container);
        System.out.println(container2);
    }


    /**
     * 删除元素：
     * 按索引删除：public E remove(int index)
     * 会把所有元素往前移动一位(删除最后一位时候不需要移动元素)
     */
    @Test
    public void test2() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add('@');
        container.add(true);
        container.add("last");
        System.out.println(container);

        //删除第一个元素
        container.remove(0);
        System.out.println(container);

        //删除最后一个元素
        container.remove(container.size()-1);
        System.out.println(container);
    }




    /**
     * 删除元素：
     * 按对象删除：public boolean remove(Object o)， Removes the first occurrence of the specified element from this list
     * 会把所有元素往前移动一位(删除最后一位时候不需要移动元素)
     */
    @Test
    public void test2_2() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add('@');
        container.add(true);
        container.add(true);
        container.add("last");
        System.out.println(container);

        container.remove("first");
        System.out.println(container);

        //删除第一次出现的指定元素
        container.remove(true);
        System.out.println(container);
    }

    /**
     * 删除元素：
     * 按集合删除：public boolean removeAll(Collection<?> c)
     */
    @Test
    public void test2_3() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add('@');
        container.add(true);
        container.add(true);
        container.add("last");
        System.out.println(container);

        Collection c = new ArrayList();
        c.add(true);
        c.add("second");
        c.add('@');
        container.removeAll(c);//两个true都会被删除
        System.out.println(container);
    }


    /**
     * 删除全部元素：public void clear()
     */
    @Test
    public void test2_4() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add('@');
        container.add(true);
        container.add(true);
        container.add("last");
        System.out.println(container);

        container.clear();
        System.out.println(container);
        System.out.println(container.size());
        System.out.println(container.isEmpty());
    }


    /**
     * remove通过object删除元素时候，底层用的是equals
     */
    @Test
    public void test2_5() {
        ArrayList<String> container = new ArrayList();
        container.add(new String("first"));
        System.out.println(container);
        container.remove(new String("first"));//String底层重写了equals,所以这里会删除成功
        System.out.println(container);
    }


    /**
     * 更新/修改元素：public E set(int index, E element)
     */
    @Test
    public void test3() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add('@');
        container.add(true);
        container.add(true);
        container.add("last");
        System.out.println(container);

        container.set(1,"second");//修改第二个元素
        System.out.println(container);
    }


    /**
     * public boolean retainAll(Collection<?> c)
     *
     * A.retainAll(B):
     * 改变了集合A中的元素，将存在于集合A中但不存在于集合B中的元素移除。,也就是集合A中仅保留交集元素
     * 集合B中的元素保持不变
     * 如果集合A的大小发生了改变，返回true，、
     * 如果集合A的大小没有发生改变，返回false
     */
    @Test
    public void test3_2() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add(true);
        container.add("last");
        ArrayList<Object> container2 = new ArrayList();
        container2.add("first");
        container2.add(false);
        container2.add("last");
        boolean b = container.retainAll(container2);
        System.out.println(b);
        System.out.println(container);
        System.out.println(container2);


        System.out.println();
        ArrayList<Object> container3 = new ArrayList();
        container3.add(1);
        container3.add(2);
        boolean b2 = container.retainAll(container3);
        System.out.println(b2);
        System.out.println(container);
        System.out.println(container3);


        System.out.println();
        ArrayList<Object> container4 = new ArrayList();
        container4.add(true);
        ArrayList<Object> container5 = new ArrayList();
        container5.add(true);
        boolean b3 = container4.retainAll(container5);
        System.out.println(b3);
        System.out.println(container4);
        System.out.println(container5);
    }


    /**
     * 查询
     */
    @Test
    public void test4() {
        ArrayList<Object> container = new ArrayList();
        container.add("first");
        container.add('@');
        container.add(true);
        container.add(true);
        container.add("last");
        System.out.println("c.size:" + container.size());
        System.out.println("c.contains('@'):" + container.contains('@'));//底层调用equals方法
        System.out.println("fisrt elem:" + container.get(0));
        System.out.println("last elem:" + container.get(container.size() - 1));
        System.out.println("@ of index:" + container.indexOf(true));//返回指定元素首次出现的索引
        System.out.println("c2 clear:" + container.isEmpty());
    }


    /**
     * 通过分析contains源码可知，此方法会把传入的元素依次和集合中的每个元素进行equals比较
     * 像String重写了equals方法，那么依次比较的就是内容
     * 若没有重写，那么依次比较的就是引用地址
     *
     */
    @Test
    public void test4_2() {
        ArrayList<Object> container = new ArrayList();

        //String重写了equals方法
        String s=new String("first");
        container.add(s);
        String s2=new String("first");
        System.out.println(container.contains(s2));

        //TestResourceinfo重写了equals方法
        TestResourceinfo t1 = new TestResourceinfo();
        container.add(t1);
        TestResourceinfo t2 = new TestResourceinfo();
        System.out.println(container.contains(t2));

        //Apple没有重写equals方法
        Apple apple=new Apple();
        container.add(apple);
        Apple apple2=new Apple();
        System.out.println(container.contains(apple2));

    }


    /**
     * public Object clone()
     */
    @Test
    public void test5(){
        ArrayList<Number> container = new ArrayList();
        container.add(0,1);
        container.add(1,2.1);
        container.add(2,3.1f);
        System.out.println(container);

        Object clone = container.clone();
        List container2 = (ArrayList) clone;
        System.out.println(container2);
        System.out.println(container==container2);
    }

    /**
     *
     <dependency>
     <groupId>com.google.guava</groupId>
     <artifactId>guava</artifactId>
     <version>25.1-jre</version>
     </dependency>
     */
    @Test
    public void test5_2() {
        List list=Arrays.asList(1,2,3);
        ArrayList list2 = Lists.newArrayList(list);
        System.out.println(list+"\n"+list2);
        System.out.println(list==list2);
    }


    /**
     * 遍历
     */
    @Test
    public void test6(){
        ArrayList<String> ls = new ArrayList();
        ls.add("Aaa");
        ls.add("Bbb");
        ls.add("Ccc");

        //fori循环
        System.out.println();
        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i).toUpperCase() + " ");
        }
        System.out.println();
        System.out.println(ls);

        //增强for循环
        System.out.println();
        for (String str : ls) {//系统会把迭代元素的值
            System.out.print(str.toLowerCase() + " ");
        }
        System.out.println();
        System.out.println(ls);


        //Iterator必须依附于Collection对象，也就是若有一个Iterator对象，必然有一个与之对应的Collection对象；
        //public interface Collection<E> extends Iterable<E>， 所以所有Collecton对象都是可迭代的(可遍历的)
        //Iterator就是用来遍历迭代集合的
        System.out.println();
        Iterator it = ls.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        //lambda遍历
        System.out.println();
        ls.forEach(ele -> System.out.print(ele + " "));

        //::可以把参数都省掉
        System.out.println();
        ls.forEach(System.out::print);
    }


    /**
     * 使用 Iterator 迭代器遍历集合的过程中不能添加、删除或修改元素
     * 但是使用迭代器的删除方法(remove()) 删除是正确可行的，也是开发中推荐使用的。
     */
    @Test
    public void test6_2(){
        ArrayList<String> ls = new ArrayList();
        ls.add("Aaa");
        ls.add("Bbb");
        ls.add("Ccc");

        Iterator it = ls.iterator();
        while (it.hasNext()) {
            String item=(String)it.next();
            if(item.equals("Aaa")){
                it.remove();//List集合的遍历删除建议使用迭代器遍历删除操作。
            }
        }
        System.out.print(ls + " ");
    }


    /**
     * 使用 Iterator 迭代器遍历集合的过程中不能添加、删除或修改元素，
     * 但是使用迭代器的删除方法(remove()) 删除是正确可行的
     */
    @Test
    public void test6_3(){
        ArrayList<String> ls = new ArrayList();
        ls.add("Aaa");
        ls.add("Bbb");
        ls.add("Ccc");

        Iterator it = ls.iterator();
        while (it.hasNext()) {
            String item=(String)it.next();
            if(item.equals("Aaa")){
                ls.remove(item);//使用迭代器遍历，却使用集合的方法删除元素: ConcurrentModificationException
            }
        }
        System.out.print(ls + " ");
    }


    /**
     *使用 Iterator 迭代器遍历集合的过程中不能添加、删除或修改元素，
     */
    @Test
    public void test6_4(){
        ArrayList<String> ls = new ArrayList();
        ls.add("Aaa");
        ls.add("Bbb");
        ls.add("Ccc");

        Iterator it = ls.iterator();
        while (it.hasNext()) {
            String item=(String)it.next();
            if(item.equals("Aaa")){
                ls.add("aaa");//使用 Iterator 迭代器遍历集合的过程中不能添加、删除或修改元素，
            }
        }
        System.out.print(ls + " ");
    }

    /**
     *使用 Iterator 迭代器遍历集合的过程中不能添加、删除或修改元素，
     */
    @Test
    public void test6_5(){
        ArrayList<String> ls = new ArrayList();
        ls.add("Aaa");
        ls.add("Bbb");
        ls.add("Ccc");

        Iterator it = ls.iterator();
        while (it.hasNext()) {
            ls.set(1,"aaa");
            System.out.println(it.next());
        }
        System.out.print(ls + " ");
    }

    /**
     * 泛型(about generic)
     */
    @Test
    public void test7(){

        //泛型(about generic)
        ArrayList<Fruit> fruit=new ArrayList<>();
        fruit.add(new Apple());
        fruit.add(new Grape());
        fruit.add(new Orange());
        System.out.println(fruit);

        //List--->array， 无论是否使用泛型都会返回Object[]
        Object[] objects1 = fruit.toArray();
        Fruit[] object2 = (Fruit[]) fruit.toArray();
    }

}
