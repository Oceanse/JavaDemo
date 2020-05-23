package com.demo.oop.inherit.demo3_Polymorphism.polymorphhismDemo1;
/**
 * 编译时多态：详见ovload
 *
 * 运行时多态(动态方法分派): SupperClass obj=new SubClass();  obj.method();
 * obj在编译时期是SupperClass类型， 但是此类型并不是obj的实际类型；obj的实际实现类是在运行时决定的(运行时才会创建对象)；
 * 因此JVM编译期间无法决定将调用哪个类方法，此决定在运行时完成，因此这也叫作运行时多态或动态方法分派。
 * 但是运行时多态貌似没法解释属性
 *
 * 另一角度:动态绑定和静态绑定
 * 静态绑定(属性)：编译期和运行期，成员变量（包括静态变量和实例变量）只与引用变量所声明的类型的对象绑定，这种绑定属于静态绑定，因为在编译阶段已经做了绑定
 * 动态绑定(方法)：编译期，方法与引用变量声明的类型的对象绑定；运行期间，方法与实际引用的对象的进行绑定，这种绑定属于动态绑定，不同时期绑定在不同对象，由 Java 虚拟机动态决定的
 *
 * 多态步骤：继承，重写，向上转型
 *
 */
public class PolymorphhismDemo {

    /**
     * Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
     * @param args
     */
    public static void main(String[] args) {
        Bank b;
        b = new SBI();
        System.out.println("SBI Rate of Interest: " + b.getRateOfInterest());
        b = new ICICI();
        System.out.println("ICICI Rate of Interest: " + b.getRateOfInterest());
        b = new AXIS();
        System.out.println("AXIS Rate of Interest: " + b.getRateOfInterest());

    }
}
class Bank {
    float getRateOfInterest() {
        return 0;
    }
}

class SBI extends Bank {
    //这里即使没有@Override,也是对父类方法的重写，因为子类方法和父类方法的返回值 方法名(参数)完全相同
    //重写后方法的权限不能小于被重写方法的权限
    float getRateOfInterest() {
        return 8.4f;
    }
}

class ICICI extends Bank {
    float getRateOfInterest() {
        return 7.3f;
    }
}

class AXIS extends Bank {
    float getRateOfInterest() {
        return 9.7f;
    }
}

