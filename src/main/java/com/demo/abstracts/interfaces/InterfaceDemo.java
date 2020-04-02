package com.demo.abstracts.interfaces;

interface A {
    public static final int A = 1;

    public abstract void infoA();
}


interface B {
    public static final int B = 1;

    public abstract void infoB();
}


//多继承
interface C extends A,B{

}

//多实现
public class InterfaceDemo implements A,B{

    @Override
    public void infoA() {

    }

    @Override
    public void infoB() {

    }
}

