package com.demo.basicdemo.statics;


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
 * 静态方法不能调用非静态的方法和变量；（非静态方法可以任意的调用静态方法/变量）
 * 不能使用this和super关键字（很明显，它属于类级别滴，没有创建对象签怎么可以用this/super）
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
        //test();
        //System.out.println(n);

        //调用本类static 方法，可省略类名
        test2();

        //调用本类static 变量，可省略类名
        double r=1;
        System.out.println(PI*r*r);
    }


    /**
     * 因为在程序开始执行时必须调用main() ，所以它被声明为static。
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
