package com.demo.oop.inherit.abstracts.interfaces.demo2;


/**
* 汽车生产商和引擎生产商两者都面向接口设计
* 接口是实现类和调用者之间的过渡，实现类面向接口去实现，调用者面向接口去调用
* 实现分层开发提高效率，降低耦合，提高可扩展性
* */


//面向接口设计，也就是制定一套标准规范
public interface Iengine {
    void start();
}



//EngineA 面向接口实现,可以继续添加实现类，可扩展性好
class EngineA implements Iengine{

    @Override
    public void start() {
        System.out.println("engineA start");
    }
}


//EngineB 面向接口实现，可以继续添加实现类，可扩展性好
class EngineB implements Iengine{

    @Override
    public void start() {
        System.out.println("engineB start");
    }
}


//简单工厂模式：把生成实现类(具体引擎)的逻辑集中在工厂类当中
class EngineFactory{

    public static Iengine getEngineA(){
        return new EngineA();
    }

    public static Iengine getEngineB(){
        return new EngineB();
    }
}



class Car{

    Iengine e;
    public Car(Iengine e) {
        this.e = e;
    }

    //面向接口调用
    public void testEngine(){//调用层面向接口设计
        e.start();
    }

    public static void main(String[] args) {
        Iengine engineA = EngineFactory.getEngineA();
        Iengine engineB = EngineFactory.getEngineB();

        new Car(engineA).testEngine();
        new Car(engineB).testEngine();
    }
}