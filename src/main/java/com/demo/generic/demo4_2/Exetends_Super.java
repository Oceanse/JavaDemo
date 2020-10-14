package com.demo.generic.demo4_2;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Exetends_Super<T extends Number> {//此处T可以随便写为任意标识，就是类型形参

    T t;

    public Exetends_Super(){

    }

    //使用泛型的方法
    public Exetends_Super(T t){
        this.t=t;
    }

    public void setT(T t){
        this.t=t;
    }

    public T getT(){
        return t;
    }




    //数组复制到list
    public <T> List<T> fromArrayToList(T[] t,List<T> list){
        for(T t1 : t){
            list.add(t1);
        }
        return list;
    }


    @Test
    public void test(){
        //Exetends_Super<String> t4=new Exetends_Super<>("abc"); 报错
        Exetends_Super<Double> t=new Exetends_Super<>(1.2);
        Exetends_Super<Integer> t2=new Exetends_Super<>(1);

        Double t3 = t.getT();
        Integer t4 = t2.getT();
    }



    @Test
    public void test2(){
        Exetends_Super t=new Exetends_Super();//如果实例化时不传入泛型类型实参的话，T默认是Object,
        Object t1 = t.getT();//实例化时不传入泛型类型实参，T默认是Object
    }




    @Test
    public void test3(){
        //在实例化泛型类时，必须指定T的具体类型
        Exetends_Super<Integer> t=new Exetends_Super<>();

        List<Integer> l=new ArrayList<>();
        l.add(1);
        List<Integer> integers = t.fromArrayToList(new Integer[]{1, 2, 3}, new ArrayList<Integer>());
    }
}