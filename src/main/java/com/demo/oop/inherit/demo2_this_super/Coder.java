package com.demo.oop.inherit.demo2_this_super;

public class Coder extends Person {

    //新增属性
    private double salary;

    /**
     * 如果子类的构造方法中没有显示地调用父类构造方法，则系统默认调用父类无参数的构造方法
     */
    public Coder() {
        super(); //这里无论显示或者隐式调用，必须保证父类中有空参构造方法
        System.out.println("Coder() is invoked");
    }

    /**
     * 子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）
     * 显式的调用父类参数的构造方法 public Person(String name, int age, boolean married)
     *
     * @param name
     * @param age
     * @param married
     * @param salary
     */
    public Coder(String name, int age, boolean married, double salary) {
        super(name, age, married);//不再调用super()
        this.salary = salary;
        System.out.println("Coder(String name, int age, boolean married, double salary) is called");
    }


    /**
     * 重写父类info()方法,然后当前类的对象只拥有重写后的info方法，不再拥有父类对象的info方法
     */
    @Override
    public void info() {
        System.out.print(name + " is " + age + " years old and salary is" + salary);
        if (this.isMarried() == false) {
            System.out.println(" He/She doesn't get married");
        } else {
            System.out.println(" He/She is married");
        }
    }

    /**
     * 添加子类独有的新方法
     */
    public void post() {
        System.out.println("My post is software engineer");
    }



    public static void main(String[] args) {


        //先调用父类构造方法Person()，再调用本类构造方法
        Coder coder = new Coder();
        coder.test(); //调用当前对象的info()
        coder.test2();//调用当前对象的父类对象的info()方法，当前coder对象的父类对象由Person()创建

        //先调用父类构造方法Person(String name, int age, boolean married)，再调用本类构造方法
        System.out.println();
        Coder coder2 = new Coder("ocean", 30, true, 20000);
        coder2.test();//调用当前对象的info()
        coder2.test2();//调用当前对象的父类对象的info()方法， 当前coder2对象的父类对象由Person(String name, int age, boolean married)创建

    }

    /**
     *  调用当前对象的info()方法
     */
    public void test() {
        this.info();
    }

    /**
     * 调用当前类对象的父类对象的info()方法
     */
    public void test2() {
        super.info();
    }


}

