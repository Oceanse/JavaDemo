package com.demo.oop.constructor;

public class ClassRoom {

    double square;

    //单参构造方法会覆盖默认的空参构造方法
    public ClassRoom(double square) {
        this.square = square;
    }
}
