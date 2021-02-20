package com.demo.collection_map.collection;

import com.demo.pojo.TestResourceinfo;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Set继承于Collection接口，元素无序且不重复，主要有HashSet和TreeSet两大实现类。
 * 在判断重复元素的时候，Set集合会调用hashCode()和equal()方法来实现。
 *
 *
 * Set常用方法：
 * A:添加功能
 *     boolean add(E e);
 *     boolean addAll(Collection<? extends E> c);
 *
 * B:删除功能
 *     boolean remove(Object o);
 *     boolean removeAll(Collection<?> c);
 *     void clear();
 *
 *  C:长度功能
 *     int size();
 *
 *  D:判断功能
 *     boolean isEmpty();
 *     boolean contains(Object o);
 *     boolean containsAll(Collection<?> c);
 *     boolean retainAll(Collection<?> c);
 *
 *  E:获取Set集合的迭代器：
 *     Iterator<E> iterator();
 *
 *  F:把集合转换成数组
 *     Object[] toArray();
 *     <T> T[] toArray(T[] a);
 *
 *     //判断元素是否重复，为子类提高重写方法
 *     boolean equals(Object o);
 *     int hashCode();
 *
 *
 *
 *  HashSet：
 *        HashSet实现Set接口，底层由HashMap(后面讲解)来实现，为哈希表结构，新增元素相当于HashMap的key，value默认为一个固定的Object。
 *        当有元素插入的时候，会计算元素的hashCode值，将元素插入到哈希表对应的位置中来；
 *
 *
 */
public class SetDemo {
    @Test
    public void test1(){
        //底层存储无序，且不能重复
        HashSet set=new HashSet();
        set.add(true);
        set.add(true);
        set.add(123);
        set.add("set");
        set.add("set");
        set.add('$');
        set.add(null);//允许插入Null值；
        System.out.println(set);//打印顺序和存储顺序不一致
    }


    public static void main(String[] args) {
        //底层存储无序，且不能重复
        HashSet set=new HashSet();
        set.add(true);
        set.add(true);
        set.add(123);
        set.add("set");
        set.add('$');
        set.add(null);//允许插入Null值；
        System.out.println(set);

        //重写equals和hashCode，如果不重写默认对比的是对象内存地址
        set.add(new TestResourceinfo());
        set.add(new TestResourceinfo());


        for (Object o : set) {
            System.out.print(o+" ");

        }
        System.out.println();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();




        System.out.println("=====================================");
        //指定遍历顺序
        LinkedHashSet set2=new LinkedHashSet();
        set2.add(true);
        set2.add(true);
        set2.add(123);
        set2.add("set");
        set2.add('$');

        System.out.print("linkedhashset: ");
        for (Object o : set2) {
            System.out.print(o+" ");
        }

        //contains( ),isEmpty( ),remove()


    }
}
