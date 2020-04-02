package com.demo.collectionandmap.collection.list;

import com.demo.collectionandmap.collection.list.pojo.Apple;
import com.demo.collectionandmap.collection.list.pojo.Fruit;
import com.demo.collectionandmap.collection.list.pojo.Grape;
import com.demo.collectionandmap.collection.list.pojo.Orange;

import java.util.ArrayList;

public class ArrayListDemo2 {
    public static void main(String[] args) {

        ArrayList<Fruit> fruit=new ArrayList<>();
        fruit.add(new Apple());
        fruit.add(new Grape());
        fruit.add(new Orange());

        String s = fruit.toString();
        System.out.println(s);

    }


}
