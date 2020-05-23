package com.demo.oop.inherit.demo3_Polymorphism.polymorphhismDemo2.demo1;

import org.testng.annotations.Test;

public class PolymorphhismDemo2 {

    /**
     * 父类的引用变量引用子类的对象时，称为向上转型；具有父子继承关系的类才可以向上转型
     * 向上转型后，引用变量再不同时期拥有不同类型：编译时类型和运行时类型
     * 编译时类型看左边(父类类型)，运行时类型看右边(子类类型)
     */
    @Test
    public void test() {
        //向上转型 编译时是Person类型，运行时是Student类型类型
        Person person = new Student("tom", 21, true, 100);
        person.info();

        //向上转型 编译时是Person类型，运行时是Coder类型
        System.out.println();
        Person person2 = new Programmer("ocean", 30, false, 20000);
        person2.info();
    }


    /**
     * 具有父子继承关系的类才可以向上转型
     * 向上转型后，引用变量再不同时期拥有不同类型：编译时类型和运行时类型
     * 编译时类型看左边(父类类型)，运行时类型看右边(子类类型)
     * 向上转型下的变量不能调用子类独有的方法
     */
    @Test
    public void test2() {
        //向上转型 编译时是Person类型，运行时是Student类型类型
        Person person = new Student("tom", 21, true, 100);
        show(person);
        //person.campus(); student编译时是Person类型,Person类没有campus()方法，所以会编译报错

        //向上转型 编译时是Person类型，运行时是Coder类型
        System.out.println();
        Person person2 = new Programmer("ocean", 30, false, 20000);
        show(person2);
        //person2.post();person2编译时是Person类型,Person类没有post()方法，所以会编译报错
    }


    /**
     *  向下转型，类型之间存在继承关系才能向下转型
     *  向下转型就是使得变量类型由向上转型时的两者类型统一成一种类型(无论何种时期)
     *  当调用子类独有的方法时候需要向下转型
     */
    @Test
    public void test3() {

        System.out.println();
        Person person = new Student("mary", 18, false, 120);
        Student student = (Student) person;//向下转型后，student编译时和运行时都是Student类型
        student.campus(); //编译运行时候都不会报错，可以调用子类独有的方法

        //向下转型，具有父子关系的类才可以向上转型/向下转型
        Person person2 = new Programmer("danis", 60, true, 100000);
        Programmer programmer = (Programmer) person2;//向下转型后，programmer编译时和运行时都是Programmer类型
        programmer.post();//编译运行时候都不会报错，可以调用子类独有的方法
    }


    @Test
    public void test4() {
        Person person = new Student("mary", 18, false, 120);

        //引用变量person编译时候是Person类型，Programmer和Person存在继承关系，所以下面向下转型在编译时期可以通过
        //但是引用变量person运行时候是Student类型，Programmer和Student不存在继承关系，所以运行时期不能向下转型，因此运行时期会报错
        Programmer programmer = (Programmer) person;
    }



    /**
     * 父类static方法被所有子类继承拥有
     */
    @Test
    public void test5(){
        Person.showNation();
        Programmer.showNation();
        Student.showNation();

        //在Student，Coder，Singer可以省略类名直接调用showNation(),因为三个子类通过继承父类拥有了静态方法showNation()
    }

    /**
     * show方法传入的参数类型是Person，但我们无法知道参数实际类型究竟是Person还是Person的子类Student或者Programmer
     * 这就提供了一种不确定性的方法调用
     * @param person
     */
    public static void show(Person person) {
        person.info();
    }


}

