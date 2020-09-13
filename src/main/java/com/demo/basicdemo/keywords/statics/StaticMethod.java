package com.demo.basicdemo.keywords.statics;


/**
 * 当一个类所有对象执行某个方法时产生的影响是相同的，我们可以把这个方法定义为静态方法；
 * 静态方法属于类级别的方法；
 *
 * 静态方法适合工具类中方法的定义，方便编程使用；比如文件操作，日期处理，数值处理
 * 静态方法适合入口方法的定义；比如单例模式，因为从外部拿不到构造函数，所有定义一个静态的方法获取对象非常有必要；
 *
 * 使用方式：
 * 1 类名.静态方法名(参数)
 * 2 对象.静态方法名(参数)
 * 2 静态方法名(参数) 调用本类的static方法时候可省略类名，编译器会从当前类中找这个方法
 * <p>
 * <p>
 * 静态方法只能访问调用静态成员和方法，不能调用非静态的方法和变量；（非静态方法可以任意的调用静态方法/变量）
 * 静态方法内部不能使用this和super关键字（静态方法属于类级别，此时可能还没有对象，故不能使用(this/super属于对象级别)
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
     *  静态方法不能访问实例变量和实例方法
     */
    public static void test3() {

        StaticMethod.test2();//通过类访问静态方法
        new StaticMethod().test2();//通过对象访问静态方法
        test2();//等价于this.test2()，对于静态方法来说，即使当前对象没有生成，this.静态方法 也不会报错，他会从当前类中寻找这个方法

        double pi = StaticMethod.PI;//通过类访问静态变量
        double pi2 = new StaticMethod().PI;//通过对象访问静态变量
        double pi3 = PI;//从当前类中找这个变量，也就是调用当前类的static变量时候可省略类名或者对象名


    }

    /**
     *  静态方法不能通过this访问实例变量和实例方法
     *  this代表调用test4方法的当前对象，test4方法在执行时候可能还没有产生对象，所以this.test()或报错
     */
    public static void test4() {
        //test(); //等价于 this.test()
        //this.test()
        //System.out.println(PI); ////等价于 this.PI
        //System.out.println(this.PI);
    }


    /**
     * 因为在程序开始执行时必须调用main() ，甚至在构造方法之前，所以它被声明为static。
     */
    public static void main(String[] args) {

        //通过类名调用非本类static方法
        int sum = MathUtils.add(1, 2);

        //静态方法和对象无关，这里依然可以调用add方法，猜测编译会推测出该对象的类型，从而调用静态方法
        MathUtils mathUtils = null;
        int sum2 = mathUtils.add(2, 4);

    }

}


//工具类中的方法定义为静态方法，可以方便编程使用
class MathUtils {

    public static int add(int m, int n) {
        return m + n;
    }
}
