package com.demo.oop.inherit.abstracts.interfaces.demo1;

/**
 interface是全局常量值和抽象方法定义的集合

 类可以实现多个interface，而且不要求实现者和interface定义在概念本质上是一致的，
 仅仅是实现了interface定义的契约而已。接口主要描述的是类型间的行为合同或者标准规范，
 接口和它的实现类之间是典型的CAN-DO关系，即“子can do父”。


 面向接口设计实现
   接口的作用是制定一组标准协议规范，指明了它的实现类必须要做什么(避免了子类设计的随意性),具体做什么由子类决定
   剩下的就是实现类面向接口去实现.接口体现的是标准规范和实现分离的设计哲学

 面向接口调用
   统一标准之后的下一件事情，就是多态；调用者面向接口去调用，也就是调用方法中的参数要从接口的角度出发
   可以实现项目分层，降低接口实现类和调用者之间的耦合度，提高可扩展性；比如想增加某个子类时候，只需要这个
 类实现接口规范即可

 总结：接口是实现类和调用者之间的过渡，面向接口去设计实现和调用



架构师定义好一套接口A(标准规范)，下层程序员用实现类B,C去实现接口，
调用层method(A a)接收接口类型参数,具体传入哪个对象是无需关注的,
method进来的参数一定是实现A接口类的对象,即使有一天将Test1与Test2两个类删除，
Test接口还在，那么method方法就有用，并且随意扩展一个新的类来实现A接口
接口是实现类和调用者之间的过渡，实现类面向接口去实现，调用者面向接口去调用，
降低接口实现类和调用者之间的耦合度，提高扩展性(可以增加实现类)



接口中的方法定义默认为public abstract类型，成员变量类型默认为public static final。
public static final int id=10            ======>    int id=10
public abstract 返回值类型 方法名(参数)     =====>     返回值类型 方法名(参数)

java类可以implements多个接口，接口可以extends多个接口

案例1：
我们知道，如果某个设备需要向电脑中读取或者写入某些东西，
这些设备一般都是采用USB方式与电脑连接的，我们发现，只要带
有USB功能的设备就可以插入电脑中使用了，那么我们可以认为USB
就是一种功能，这种功能能够做出很多的事情（实现很多的方法），
其实USB就可以看做是一种标准，一种接口，只要实现了USB标准的
设备我就认为你已经拥有了USB这种功能。（因为你实现了我USB标准中规定的方法


 案例2：
 例如主机板上提供了PCI插槽， 只要一块显卡遵守PCI接口规范， 就可以插入PCI插槽内， 与该主机
 板正常通信。至于这块显卡是哪个厂家制造的， 内部是如何实现的， 主机板无须关心
*/


//面向接口设计，也就是制定一套标准规范
public interface IUSB {

    /**
     * 接口中的方法会被隐式的指定为 public abstract
     * 实现USB接口的实现类都具备read write功能
     */
    void read();
    void write();
}

//子类1遵循标准规范，可以继续添加实现类，可扩展性好
class Cellphone implements IUSB{

    public Cellphone() {
        super();
    }

    @Override
    public void read() {
        System.out.println("Cellphone usb is reading");
    }

    @Override
    public void write() {
        System.out.println("Cellphone usb is writinging");
    }
}


//子类2遵循标准规范，可以继续添加实现类，可扩展性好
class Udisk implements IUSB{

    @Override
    public void read() {
        System.out.println("udisk usb is reading");
    }

    @Override
    public void write() {
        System.out.println("udisk usb is writing");
    }
}

class Tests{

    /**
     * 面向接口调用
     * @param usb
     */
    public static void test( IUSB usb){
        usb.read();
        usb.write();
    }



    public static void main(String[] args) {
        test(new Cellphone());
        test(new Udisk());
    }
}
