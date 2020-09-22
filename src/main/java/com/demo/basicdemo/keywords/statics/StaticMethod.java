package com.demo.basicdemo.keywords.statics;


import static com.demo.basicdemo.keywords.statics.MathUtils.add;

/**
 * 定义：
 * 当一个类所有对象执行某个方法时产生的影响是相同的，我们可以把这个方法定义为静态方法；静态方法属于类级别的方法；
 *
 * 用途：
 * 静态方法适合工具类中方法的定义，方便编程使用；比如文件操作，日期处理，数值处理
 * 静态方法适合入口方法的定义；比如单例模式，因为从外部拿不到构造函数，所有定义一个静态的方法获取对象非常有必要；
 *
 * 使用方式：
 * 1 类名.静态方法名(参数)
 * 2 对象.静态方法名(参数)
 * 2 静态方法名(参数) 调用本类的static方法时候可省略类名，编译器会从当前类中找这个方法
 *
 * 注意：
 *  1 静态方法只能访问调用静态成员和方法，不能直接访问或者通过this/super访问调用普通的非静态的方法和变量；（非静态方法可以任意的调用静态方法/变量）
 *  2 静态方法内部可以调用一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
 *  3 静态方法内部不能使用this和super关键字（静态方法属于类级别，此时可能还没有对象，故不能使用(this/super属于对象级别)
 *
 * <p>
 */
public class StaticMethod {

    private int n = 1;
    public static double PI=3.14;

    /**
     * 实例方法
     */
    public void test() {
    }


    /**
     * static 方法
     */
    public static void test2() {
    }


    /**
     *  静态方法不能直接访问或者通过this/super访问实例变量和实例方法，
     *  但是静态方法可以访问一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
     */
    public static void test3() {

        StaticMethod.test2();//通过类访问静态方法
        new StaticMethod().test2();//通过对象访问静态方法
        test2();//调用本类的static方法时候可省略类名，编译器会从当前类中找这个方法

        double pi = StaticMethod.PI;//通过类访问静态变量
        double pi2 = new StaticMethod().PI;//通过对象访问静态变量
        double pi3 = PI;//调用本类的static属性时候可省略类名，编译器会从当前类中找这个属性
    }


    /**
     *  静态方法内部不能使用this和super关键字（静态方法属于类级别，此时可能还没有对象，故不能使用(this/super属于对象级别)
     *  this代表调用test4方法的当前对象，test4方法在执行时候可能还没有产生对象，所以this.test()或者this.PI会报错
     *
     *  静态方法不能直接访问或者通过this/super访问实例变量和实例方法，
     *  但是静态方法可以访问一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
     */
    public static void test4() {
        test2();
        //this.test()
        //System.out.println(this.PI);
    }


    /**
     * 静态方法只能访问调用静态成员和方法，不能直接访问或者通过this/super访问实例变量和实例方法，
     * 这里直接访问就等价于this.test(), 因为此时test4_2方法在执行时候可能还没有产生对象，所以直接访问test()会报错
     */
    public static void test4_2() {
        //test();
    }

    /**
     *静态方法内部可以调用非静态构造方法来new对象
     * 静态方法可以访问一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
     *
     */
    public static void test4_3() {
        new StaticMethod().test();
        System.out.println(new StaticMethod().n);
    }


    /**
     *  实例方法可以使用this和super关键字，可以用他们访问静态方法和静态属性，当然也可以访问实例变量和实例方法
     *  this代表调用test4方法的当前对象，test4方法在执行时候可能还没有产生对象，所以this.test()或报错
     */
    public void test5() {
        test(); //等价于 this.test()
        this.test();

        test2();//系统监测到调用的方法是静态方法，然后就会从当前类加载这个方法
        this.test2();//当然也可以通过当前对象调用静态方法
        StaticMethod.test2();//通过类名调用静态方法

        System.out.println(PI); //系统监测到当前变量是静态变量，然后就会从当前类加载这个变量
        System.out.println(this.PI);//当然也可以通过当前对象调用静态变量
        System.out.println(StaticMethod.PI);//通过类名调用静态变量
    }


    public void test6() {
        //通过类名调用非本类static方法,也就是调用非本类静态方法前一定需要通过类名或者方法名来调用
        int sum = add(1, 2);
    }

    public void test6_2() {
        //通过import进其他类的方法到本类中可以实现省略类名或者对象名来调用静态方法
        //import static com.demo.basicdemo.keywords.statics.MathUtils.add;
        int sum = add(1, 2);
    }



    /**
     * 因为在程序开始执行时必须调用main() ，甚至在构造方法之前，所以它被声明为static。
     */
    public static void main(String[] args) {

    }

}


//工具类中的方法定义为静态方法，可以方便编程使用
class MathUtils {

    public static int add(int m, int n) {
        return m + n;
    }
}
