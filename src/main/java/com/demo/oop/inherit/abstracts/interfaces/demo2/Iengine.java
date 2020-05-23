package com.demo.oop.inherit.abstracts.interfaces.demo2;


/*
* 汽车生产商和引擎生产商两者都面向接口设计
* 接口是实现类和调用者之间的过渡，实现类面向接口去实现，调用者面向接口去调用
* 实现分层开发提高效率，降低耦合，提高可扩展性
* */
public interface Iengine {
    void start();
}



//EngineA EngineB都是面向接口设计,可以继续添加实现类，提高可扩展性
class EngineA implements Iengine{

    @Override
    public void start() {
        System.out.println("engineA start");
    }
}


class EngineB implements Iengine{

    @Override
    public void start() {
        System.out.println("engineB start");
    }
}

class Car{

    Iengine e;

    public Car(Iengine e) {
        this.e = e;
    }

    public void testEngine(){//调用层面向接口设计
        e.start();
    }

    public static void main(String[] args) {
        new Car(new EngineA()).testEngine();
        new Car(new EngineB()).testEngine();
    }
}