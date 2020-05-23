package com.demo.oop.inherit.demo1_reuse;

public class Bird extends Animal {

    String swingsShape;

    public Bird() {
        System.out.println(" public Bird() is invoked");
    }

    public String getSwingsShape() {
        return swingsShape;
    }

    public void setSwingsShape(String wingsShape) {
        this.swingsShape = wingsShape;
    }

    public void fly() {
        System.out.println("Fly...");
    }
}
