package com.demo.basicdemo.keywords.thiss.demo1;


import org.testng.annotations.Test;

/**
 * this使用场景：
 * 1 this用在构造函数中时候(this.属性，this.方法)：
 *    A 表示正在创建的当前类对象
 *    B 调用本类的重载构造方法
 * 2 this用在普通方法(this.属性，this.方法， return this)表示当前类对象，也就是调用当前方法的对象
 *
 *
 *
 * this不能出现在static方法中，因为调用当前类方法的是类，此时可能还不存在对象，所以this也无法代指当前对象
 */
public class WhyThis {

    int legs;

    public void run(){
        System.out.println("run");
    };

    @Override
    public String toString() {
        return "WhyThis{" +
                "legs=" + legs +
                '}';
    }

    /**
     * A方法调用本类的另一个实例方法B或者属性B时候(说明A方法依赖B方法和属性B)一定需要通过对象调用，
     * 如果没有this关键字，只能通过new一个新的对象然后去调用，如下所示，但是这就像A方法
     * 依赖另一个对象的方法和属性；然而很多情况是A方法依赖同一个对象的方法B和属性B，所以我们不需要额外
     * 创建新的对象，可以通过this关键字来代表当前对象(或者是正在创建的对象)，也就是调用当前方法
     * 的对象，甚至我们可以省略关键字this,那么等价于前面有this
     */
    public WhyThis jump(){
        WhyThis w=new WhyThis();
        w.legs=2;
        w.run();
        System.out.println(w);
        return w;
    };




    public WhyThis jump2(){

        //this关键字来代表当前对象,也就是调用当前方法jump2方法的对象
        this.run();
        this.legs=2;
        System.out.println(this);
        return this;
    };



    public void jump3(){

        //前面this可以省略，可以想象成前面有this
        run();
        legs=2;
    };

}
