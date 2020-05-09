package com.demo.oop.inherit.demo3_Polymorphism.PolymorphhismDemo1;

import com.demo.oop.inherit.demo2_this_super.Person;

public class Student extends Person {

    //新增属性
    private double score;


    public Student() {
        System.out.println("Person() is invoked");
    }


    public Student(String name, int age, boolean married, double score) {
        super(name, age, married);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    /**
     * 重写父类方法
     */
    @Override
    public void info() {
        System.out.print(name + " is " + age + " years old and score is " + score);
        if(this.isMarried()==false){
            System.out.println(" He/She doesn't get married");
        }else{
            System.out.println(" He/She is married");
        }
    }


    /**
     * 添加子类独有的新方法
     */
    public void campus() {
        System.out.println("My campus is Shanghai University");
    }

}
