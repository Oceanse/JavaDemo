package com.demo.collectionandmap.collection.list;

import org.testng.annotations.Test;

import java.util.LinkedList;


/*
LinkedList存储元素的数据结构是双向链表结构，由存储元素的结点连接而成，
每一个节点都包含前一个节点的引用，后一个节点的引用和节点存储的值。当一个新节点插入时，
只需要修改其中保持先后关系的节点的引用即可*/
public class LinkedListDemo {

    @Test
    public void test(){
        LinkedList ls=new LinkedList();
        ls.add("aa");
        ls.add("bb");//将指定元素添加到此列表的结尾。
        System.out.println(ls);

        ls.addFirst("first");//将指定元素插入此列表的开头。
        ls.addLast("last");
        System.out.println(ls);

        ls.add(1,"second");
        System.out.println(ls);

        /*addAll(Collection<? extends E> c)
        添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序。

        addAll(int index, Collection<? extends E> c)
        将指定 collection 中的所有元素从指定位置开始插入此列表。
        */

    }

    @Test
    public void test2(){
        /*addAll(Collection<? extends E> c)
        添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序。

        addAll(int index, Collection<? extends E> c)
        将指定 collection 中的所有元素从指定位置开始插入此列表。
        */

        LinkedList ls=new LinkedList();
        ls.add("aa");
        ls.add("bb");

        LinkedList ls2=new LinkedList();
        ls2.addAll(ls);
        System.out.println(ls2);

        ls2.addAll(1,ls);
        System.out.println(ls2);

    }

    @Test
    public void test3(){

        LinkedList ls=new LinkedList();
        ls.add("aa");
        ls.add("bb");

        LinkedList ls2=new LinkedList();
        ls2.add("aa");
        ls2.add("bb");
        ls2.add("cc");
        ls2.add("dd");

        ls2.removeFirst();
        ls2.removeLast();
        System.out.println(ls2);


    }
}
