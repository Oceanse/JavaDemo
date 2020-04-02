package com.demo.exception;

import java.io.IOException;

public class OverrideException {

    public void test() throws RuntimeException, IOException {
    }
}


//子类重写父类的方法，父类抛异常，子类可以不抛异常
class A extends OverrideException{
    @Override
    public void test(){
    }
}

//子类重写父类的方法，抛出一样大的异常
class B extends OverrideException{
    @Override
    public void test() throws RuntimeException, IOException {
    }
}

//子类重写父类的方法，抛出更小的异常
class C extends OverrideException{
    @Override
    public void test() throws ArithmeticException {
    }
}

//对父类的方法进行了重写。抛出了更大的异常,错误
class D extends OverrideException{
    /*@Override
    public void test() throws Exception { }*/
}



class F{
    public void test(){}
}

//父类没有异常，子类可以抛出任意的RuntimeException
class CC extends F{
    @Override
    public void test()throws RuntimeException{}
}