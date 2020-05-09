package com.demo.oop.inherit.demo1_reuse;
/**
 * is-a: 这种事物(绵羊)是那种事物(羊)中的一个种类
 * 继承需要符合的关系是：is-a，可以理解为:“子类 is a 父类”, 父类更通用，子类更具体
 *
 * 拥有父类对象全部属性和方法：
 * 子类继承父类后，子类就拥有了父类全部的属性和行为(一个对象获取父对象的所有属性和行为);  脑海中要有子类拥有的的全部的成员变量和方法
 *
 * 重写父类对象方法：
 * 当父类方法不能满足子类需求，可以对父类继承的方法进行重写,重写只是针对方法，不针对属性，重写后子类只拥有重写后的方法
 *
 * 新增属性和方法：
 * 另外可以在父类的基础上新增成员变量和方法
 *
 * 运行时多态(动态方法分派): SupperClass obj=new SubClass();  obj.method();
 * obj在编译时期是SupperClass类型， 但是编译时类型并不是实际的类型；实际的实现类是在运行时决定的(运行时才会创建对象)；
 * 所以编译期间无法决定将调用哪个类方法，此决定在运行时完成，因此这也叫作运行时多态或动态方法分派。
 * 相反 Class obj=new Class();obj.method(); obj在编译和运行期都是同一个类型，要调用的方法也是确定的，这里就不存在多态
 * 多态步骤：继承，重写，向上转型
 *
 * 优点：继承提高代码可重用性
 *
 * 继承可以使用 extends 和 implements 这两个关键字来实现继承当一个类没有继承的两个关键字，则默认继承object
 * java只支持单继承
 * 构造器不支持继承
 */
public class Animal {

    public Animal() {
        System.out.println(" public Animal() is invoked ");
    }

    public void eat() {
        System.out.println("eating...");
    }

    public void sleep() {
        System.out.println("eating...");
    }

}
