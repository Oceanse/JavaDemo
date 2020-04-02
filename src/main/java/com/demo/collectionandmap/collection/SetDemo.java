package com.demo.collectionandmap.collection;

import com.demo.pojo.TestResourceinfo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SetDemo {
    public static void main(String[] args) {
        //底层存储无序，且不能重复
        HashSet set=new HashSet();
        set.add(true);
        set.add(true);
        set.add(123);
        set.add("set");
        set.add('$');

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
