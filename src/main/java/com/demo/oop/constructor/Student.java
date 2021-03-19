package com.demo.oop.constructor;

import java.util.Arrays;



public class Student {

    //实例变量只有在对象创建时候才会被声明初始化，也就是先有对象才会有实例变量
    String name;
    int id;
    String[] subject;


    /**
     无参构造方法
     */
    public Student() {
        System.out.println("Student 无参构造器");
    }

    /**
     双参构造方法
     */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Student 双参构造器");
    }

    /**
     三参构造方法
     */
    public Student(String name, int id, String[] subject) {
        this(name, id);//this调用双参构造器
        this.subject = subject;
        System.out.println("Student 三参构造器");
    }


    /**
     拷贝构造函数,可以将一个对象的值复制到另一个对象中
     */
    public Student(Student student) {
        this.name=student.name;
        this.id=student.id;
        this.subject=student.subject;
        System.out.println("Student 拷贝构造函数");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subject=" + Arrays.toString(subject) +
                '}';
    }

    /**
     这里就变成了普通方法
     */
    public void Constructor() {
    }

}



