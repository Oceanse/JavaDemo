package com.demo.basicdemo.variable;

import org.testng.annotations.Test;


/**
 * 局部变量(Local Variable)
 * 定义：方法中的变量(包括方法体 形参)和代码块中的变量
 * 存储位置：栈内存中
 * 初始化：使用前必须进行初始化，系统默认不会对局部变量进行初始化数据操作；如果局部变量在使用前没有进行初始化则会在编译器报错；
 * 如果局部变量进行了声明没有进行初始化， 但是也一直没有被使用的话编译也是不会报错的；(局部变量使用前必须初始化话)；
 * 形参不必初始化
 * 生存时间：作用的范围结束，变量空间会自动释放；
 * 方法体内的局部变量同方法的生存时间一致，调用该方法声明该局部变量并初始化的时，该局部变量被创建并分配内存空间；直到该方法调用结束局部变量也就结束了；
 * 作用域：局部变量只在当前{}有效
 * <p>
 * <p>
 * <p>
 * <p>
 * 全局变量： 实例变量(Instance Variable)和静态变量(Static variable)     (静态变量详见statics模块)
 * 实例变量：
 * 定义：类内方法外，不被static修饰(It is not declared as static)，也称为实例变量;属于某个对象的属性，
 * 存储位置：堆内存
 * 初始化：不需要被强制初始化的，系统都会默认根据其数据类型进行默认赋值；
 * 生存时间：非静态全局变量加载在堆内存中，随着声明初始化而创建，随着对象消亡而消亡；当一个对象被实例化之后，每个实例变量的值就跟着确定
 * 作用域：再整个类中有效，在整个类中都可以被访问；因此实例变量可以声明在使用前或者使用后；
 * 一般情况下应该把实例变量设为私有，只对于类中的方法、构造方法或者语句块是可见的，使得外部能够通过这些方式获取实例变量信息；
 * <p>
 * <p>
 * <p>
 * <p>
 * 同一作用域，变量名不能重复(不能定义变量名相同的变量)；假设存在重名的两块栈内存区域，那么编译器无法把内存和对应的变量名进行匹配；
 * 但是栈内存和d堆内存是可以重名的，因为他们属于两块不同的内存区域
 * 使用变量时需要遵循的原则为：就近原则，首先在局部范围找，有就使用；没有接着在成员位置找。
 */
public class Local_Global_Variable {

    //实例变量
    String name;
    int age;

    public Local_Global_Variable() {
    }

    public Local_Global_Variable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /**
     * 局部变量没有初始化，但是没有被使用的话编译也是不会报错的
     */
    @Test
    public void test2() {
        int age;
    }


    /**
     * 局部变量没有初始化，使用的话编译器会报错
     */
    @Test
    public void test3() {
        int age;
        // System.out.println(age);根据就近原则这里使用的是局部变量age,但是因为没有错初始化，所以编译器会报错

        //String str;局部变量必须要显式的初始化
        String str = null; //String str=null会对引用变量str(存在栈内存)赋值为null,但是不会开辟堆空间，str完成了初始化
        System.out.println(str);
    }

    /**
     * 局部变量可以和全局变量重名
     * 就近原则
     */
    @Test
    public static void test4() {
        String name = "tom";//局部变量可以和全局变量重名，这里的name分配再栈内存，成员变量name分配与堆内存
        if (name != null) {//就近原则
            System.out.println(name);
        }
    }


    /**
     * 代码块中声明的变量是局部变量，仅在当前代码块内生效
     */ {
        int age = 100;
    }

}
