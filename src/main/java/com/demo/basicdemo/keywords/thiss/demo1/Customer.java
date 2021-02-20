package com.demo.basicdemo.keywords.thiss.demo1;


/**
 * this使用场景：
 * 1 this用在构造函数中时候(this.属性，this.方法)：
 * A 表示正在创建的当前类对象
 * B 调用本类的重载构造方法
 * 2 this用在普通方法(this.属性，this.方法， return this)表示当前类对象的引用，也就是调用当前方法的对象的引用
 * <p>
 * this不能出现在static方法中，因为调用当前类方法的是类，此时可能还不存在对象，所以this也无法代指当前对象
 */
public class Customer {

    String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }


    public void shopping() {
        //这里this可以省略 this之当前对象的引用，也就是调用当前shopping方法的对象的引用
        System.out.println(this.name + " go shopping");
    }


    public void printInfo() {
        //this关键字来代表当前对象的引用,也就是调用当前getInstance()方法的对象
        if (this.name.equals("xm")) {
            this.setName("haiyang");
        }
        System.out.println(this);//这里实际调用this.toString()
    }

    ;


    public Customer getInstance() {
        //this关键字来代表当前对象的引用,也就是调用当前getInstance()方法的对象
        return this;
    }



    public static void main(String[] args) {

        Customer xm = new Customer("xm");
        Customer xh = new Customer("xh");
        xm.shopping();//shopping中的this对应xm
        xh.shopping();//shopping中的this对应xh

        xh.printInfo();
        xm.printInfo();

        System.out.println(xm.getInstance().getName());
        System.out.println(xh.getInstance().getName());

        //System.out.println(this); this不能出现在静态方法中，因此调用静态方法时候对象可能还不存在
    }


}
