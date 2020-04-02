package com.demo.concurrent.threadpool.queque;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;


/*
 * 一个基于链接节点的无界线程安全队列,非阻塞队列
 * 按照 FIFO（先进先出）原则对元素进行排序
 * 新的元素插入到队列的尾部，队列获取操作从队列头部获得元素。
 * */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        clq.add("java");
        clq.offer("c++");//add() 和 offer() 完全一样，都是往队列尾部添加元素
        clq.add("python");
        clq.add("go");

        System.out.println(clq.poll());//获取并移除此队列的头
        System.out.println(clq.size());// 返回此队列中的元素数量

        System.out.println(clq.poll());
        System.out.println(clq.size());

        System.out.println(clq.poll());
        System.out.println(clq.size());

        System.out.println(clq.poll());
        System.out.println(clq.size());

        System.out.println(clq.poll());//如果此队列为空，则返回null。
        System.out.println(clq.size());

    }

    @Test
    public void test() {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        clq.add("java");
        clq.offer("c++");//add()和offer() 完全一样，都是往队列尾部添加元素
        clq.add("python");
        clq.add("go");


        System.out.println(clq.peek());//获取但不移除队列的头
        System.out.println(clq.size());

        System.out.println(clq.peek());//获取但不移除队列的头
        System.out.println(clq.size());

    }

    @Test
    public void test2() {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        clq.add("java");
        clq.offer("c++");//add()和offer() 完全一样，都是往队列尾部添加元素
        clq.add("python");
        clq.add("go");

        System.out.println(clq.peek());//获取但不移除队列的头
        boolean java = clq.remove("java");// 从队列中移除指定元素的单个实例,移除成功返回true
        boolean java2 = clq.remove("java");//移除失败返回false
        System.out.println(java);
        System.out.println(java2);

    }


    @Test
    public void test3() {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        clq.add("java");
        clq.offer("c++");//add()和offer() 完全一样，都是往队列尾部添加元素
        clq.add("python");
        clq.add("go");

        //迭代遍历
        Iterator<String> iterator = clq.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
