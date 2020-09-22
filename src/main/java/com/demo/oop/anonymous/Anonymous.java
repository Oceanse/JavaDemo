package com.demo.oop.anonymous;


import org.testng.annotations.Test;

/**
我们也可以不定义对象的句柄，而直接调用这个对象的方法。这样的对象叫做匿名对象 new Human().shout();
如果对一个对象只需要进行一次方法调用，那么就可以使用匿名对象。
我们经常将匿名对象作为实参传递给一个方法调用。

* */
public class Anonymous {

    void fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("factorial is " + fact);
    }

    @Test
    public void test() {
        new Anonymous().fact(5);// calling method with anonymous object
    }


    public static void showSinger(Singer singer){
        singer.sing();
    }

    @Test
    public static void test2() {
        showSinger(new PopularSinger());//匿名对象作为实参传递给一个方法
    }


}

abstract class Singer{
    public abstract void sing();
}

class PopularSinger extends Singer{

    @Override
    public void sing() {
        System.out.println("heng heng ha hei");
    }
}
