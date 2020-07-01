package com.demo.oop.inherit.demo2_this_super;

/**
 * 作用：
 * 1 隐式或者显式调用父类构造方法
 * 2 访问父类的成员变量和方法;子类和父类中变量或方法名称相同时，用 super 关键字来访问父类属性和方法
 *
 * Note:
 * 子类一定会隐式或者显式调用父类构造器，也就是若不显示调用父类构造器，编译器会自动在子类构造方法的第一句加上super()，若显示调用父类带参构造器，则不会调用super();
 * 父类最好保留空参构造
 */
public class Coder extends Human {

    //新增属性
    private double salary;

    /**
     * 如果子类的构造方法中没有显示地调用父类构造方法，则系统默认调用父类无参数的构造方法
     */
    public Coder() {
        super(); //这里无论显示或者隐式调用，必须保证父类中有空参构造方法
        System.out.println("Coder() is invoked");
    }


    public Coder(double salary) {
        //super(); 这里会隐式调用super()
        this.salary = salary;
        System.out.println("Coder(String name, int age, boolean married, double salary) is called");
    }



    /**
     * 子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）
     * 显式的调用父类参数的构造方法 public Human(String name, int age, boolean married)
     *
     * @param name
     * @param age
     * @param married
     * @param salary
     */
    public Coder(String name, int age, boolean married, double salary) {
        //不再调用super()
        //因为父类的属性都是私有的，所以不能采取"this.name=name"这种方式赋值；但是可以通过public constructor初始化父类属性；
        //子类虽然不能继承父类私有属性，但是可以通过继承过来的getter setter方法访问和修改私有属性
        super(name, age, married);
        this.salary = salary;
        System.out.println("Coder(String name, int age, boolean married, double salary) is called");
    }


    /**
     * 重写父类info()方法,然后当前类的对象只拥有重写后的info方法，不再拥有父类对象的info方法
     * @Override可以让编译器帮助检查是否进行了正确的覆写。希望进行覆写，但是不小心写错了方法签名，编译器会报错
     */
    @Override
    public void info() {
        System.out.print(getName() + " is " + getAge() + " years old and salary is" + salary);
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


        //先调用父类构造方法Human()，再调用本类构造方法
        Coder coder = new Coder();
        coder.test(); //调用当前对象的info()
        coder.test2();//调用当前对象的父类对象的info()方法，当前coder对象的父类对象由Person()创建

        //这里会先调用父类空参构造
        System.out.println();
        Coder coder2 = new Coder(20000);

        //先调用父类构造方法Person(String name, int age, boolean married)，再调用本类构造方法
        System.out.println();
        Coder coder3 = new Coder("ocean", 30, true, 20000);
        coder3.test();//调用当前对象的info()
        coder3.test2();//调用当前对象的父类对象的info()方法， 当前coder2对象的父类对象由Person(String name, int age, boolean married)创建

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
