package com.demo.basicdemo.variable;

import com.demo.oop.aggregation.Address;
import org.testng.annotations.Test;


/**
 * 局部变量(Local variable)
 * 定义：方法中的变量(包括方法体 形参)和代码块中的变量，局部变量不属于任何类或者对象
 *
 * 存储位置：栈内存中
 *         局部变量只是存放字面值或者对象的地址，因此占用的空间比较小
 *
 * 初始化：使用前必须进行初始化，系统默认不会对局部变量进行初始化数据操作；如果局部变量在使用前没有进行初始化则会在编译器报错；
 *       如果局部变量进行了声明没有进行初始化， 但是也一直没有被使用的话编译也是不会报错的；(局部变量使用前必须初始化话)；
 *       形参不必初始化
 *
 * 生存时间：当局部变量所在的方法或者方法内的当前{}或者代码块被使用时，变量会被创建；当作用范围结束后，变量空间会自动释放；
 *         方法体内的局部变量同方法的生存时间一致，调用该方法声明该局部变量并初始化的时，该局部变量被创建并分配内存空间；直到该方法调用结束局部变量也就结束了；
 *         局部变量无需系统垃圾回收，因为他会随着方法或者代码块运行的结束而结束
 *
 * 作用域：局部变量只在当前{}有效， 或者说只在当前{}可见
 *        局部变量的作用范围越小越好，作用范围越小，在内存停留的时间就越短，程序的性能就会越好
 *
 * 全局变量： 实例变量(Instance Variable)和静态变量(Static variable)
 *
 * 实例变量：
 *    定义：类内方法外，不被static修饰(It is not declared as static)，也称为实例变量;属于某个对象的属性，
 *    存储位置：堆内存
 *    初始化：不需要被强制初始化的，系统都会默认根据其数据类型进行默认赋值；
 *    生存时间：非静态全局变量加载在堆内存中，随着对象创建而创建，随着对象消亡而消亡；当一个对象被实例化之后，每个实例变量的值就跟着确定
 *    作用域：再整个类中有效，在整个类中都可以被访问；因此实例变量可以声明在使用前或者使用后；
 *    一般情况下应该把实例变量设为私有，只对于类中的方法、构造方法或者语句块是可见的，使得外部能够通过这些方式获取实例变量信息；
 *
 * 静态变量详见statics模块
 *
 * 命名：
 * 同一作用域，变量名不能重复(不能定义变量名相同的变量)；假设存在重名的两块栈内存区域，那么编译器无法把内存和对应的变量名进行匹配；
 * 但是栈内存和堆内存是可以重名的，因为他们属于两块不同的内存区域
 * 使用变量时需要遵循的原则为：就近原则，首先在局部范围找，有就使用；没有接着在成员位置找。
 */
public class Local_Global_Variable {

    //全局变量之实例变量，对象创建时候被分配空间，对象销毁后被释放
    String name="ocean";
    int age=30;

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
    public void test() {
        Address address;
    }


    /**
     * 变量使用前必须初始化；
     * 系统默认不会对局部变量进行初始化数据操作；如果局部变量在使用前没有进行初始化则会在编译器报错；
     * 局部变量使用前必须手动初始化
     */
    @Test
    public void test2() {
        String[] hobby;
        //System.out.println(hobby); //变量没有初始化就使用会报错
    }


    /**
     * 局部变量可以和全局变量重名
     * 变量前面没有this或者super等修饰符时候会遵循就近原则
     */
    @Test
    public void test3() {
        String name = "tom";//局部变量可以和全局变量重名，这里的name分配在栈内存，成员变量name分配在堆内存
        System.out.println("name="+name);//当name前面没有this或者super等修饰符时候会遵循就近原则,所以这里的name是局部变量name
        System.out.println("this.name="+this.name);//this修饰说明name是当前对象的一个属性
    }


    /**
     * 局部变量可以和全局变量重名
     * 变量前面没有this或者super等修饰符时候会遵循就近原则
     * 局部变量只在当前{}有效， 或者说只在当前{}可见
     */
    @Test
    public  void test4() {
        int age=31;
        if(age!=this.age){
            String result="right";//result作用域是当前{}
        }
        //System.out.println(result); //result变量空间已经被释放
    }



    /**
     * 代码块中声明的变量是局部变量，仅在当前代码块内生效
     */ {
        int age = 100;
        System.out.println("age="+age);//局部变量可以和全局变量重名，这里的age分配在栈内存，成员变量age分配在堆内存
        System.out.println("this.age="+this.age);//成员变量age
    }


    /**
     * sum的作用域是整个方法，也就是只有整个方法调用结束时候变量sum才会被释放
     * sum在方法被调用时候才会为其创建分配内存空间
     *
     * i的作用范围时for循环，一次for循环结束后就会被销毁
     * i只有在执行到for循环时候才会为其创建分配内存空间
     */
    @Test
    public static void test4_2() {
       int sum=0;//注意变量要初始化
        for (int i = 0; i < 101; i++) {//这里变量i会反复被声明(开辟空间)，赋值，超出for循环之后会被销毁
            sum+=i;
        }
        System.out.println("sum="+sum);
    }



    /**
     * sum和i的作用域是整个方法，也就是只有整个方法调用结束时候变量sum才会被释放
     */
    @Test
    public static void test4_3() {
        int sum=0;//注意变量要初始化
        int i;
        for (i = 0; i < 101; i++) {
            sum+=i;
        }
        System.out.println("sum="+sum);
    }

}
