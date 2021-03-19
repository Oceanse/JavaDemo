package com.demo.basicdemo.code_block.construct_block.demo1;

/**
 * Person类中存在若干个包含相同代码逻辑的构造函数，存在很多重复代码，可以将这部分同的代码抽取出来，使用构造代码块取代
 *
 * 构造代码块
 * 使用场景：如果多个构造器包含相同的代码，且这些代码无需接受参数，可以把他们抽取出来放在构造代码块中
 *
 * 本质：构造代码块是一种假象，javac对源文件编译后，构造代码块会消失，代码块中的代码会被还原到每个构造器中，并且位于构造器的最前面
 *
 * 作用：构造代码块给所有对象的相同部分进行初始化，提高代码的复用性和可维护性
 *
 * 执行时机： 创建对象(调用构造器)的时候执行(类加载的时候不会被执行)
 *
 * 特点：1 代码块是没有独立运行的能力，没法通过类或者对象去调用，运行时候必须依附一个载体，编译器会将代码块按照他们的顺序(假如有多个代码块)插入到所有的构造函数的最前端，
 *        所以Person2的代码等同于Person的代码， 这样就能保证不管调用哪个构造函数都会执行所有的构造代码块；
 *      2 假如有多个代码块,自上而下顺次执行；因为每个代码块都会被执行，所以建议把多个代码块合并成一个代码块
 *      3 不接受任何参数
 *      4 初始化顺序：实例属性初始值/代码块(取决于两者代码先后顺序)-->构造器内部代码
 *      Java创建对象时候会先为所有的对象创建内存空间(前提是该类已经被加载过)，接着开始对这些实例变量进程初始化；先是默认值，然后执行实例代码块或者声明实例变量时的初始值，两者的
 *      顺序和他们在源代码中的排列顺序相同，然后再执行构造器内部的代码
 */

/**
 * Person类中存在若干个包含相同代码逻辑的构造函数，存在很多重复代码，
 */
public class Person {
    String name;
    int age;

    public Person() {
        System.out.println("I am chinese");
    }

    public Person(String name) {
        System.out.println("I am chinese");
        this.name = name;
    }

    public Person(int age) {
        System.out.println("I am chinese");
        this.age = age;
    }

    public Person(String name, int age) {
        System.out.println("I am chinese");
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


/**
 * Person类多个构造器包含相同的代码，且这些代码无需接受参数，可以把他们抽取出来放在构造代码块中
 */
class Person2 {
    String name;
    int age;

    {
        System.out.println("I am chinese");
    }

    public Person2() {
        System.out.println("Person2() is called");
    }

    public Person2(String name) {
        System.out.println("Person2(String name) is called");
        this.name = name;
    }

    public Person2(int age) {
        System.out.println("Person2(int age) is called");
        this.age = age;
    }

    public Person2(String name, int age) {
        System.out.println("Person2(String name, int age) is called");
        this.name = name;
        this.age = age;
    }
}



class BlockTest{
    public static void main(String[] args) {
        new Person2();
        System.out.println();

        new Person2("ocean");
        System.out.println();

        new Person2("ocean",30);

    }
}