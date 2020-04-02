package com.demo.basicdemo.statics;


/*
 * 当一个类所有对象执行某个方法时产生的影响是相同的，我们可以把这个方法定义为静态方法
 * 静态方法属于类级别的方法
 * 可以将常用的工具类中的方法定义为静态方法，可以方便编程使用
 * */
public class StaticMethod {

    int n=1;

    public void test(){

    }




    //因为在程序开始执行时必须调用main() ，所以它被声明为static。
    public static void main(String[] args) {

        int sum = MathUtils.add(1, 2);


        //静态方法和对象无关，这里依然可以调用add方法，猜测编译会推测出该对象的类型，从而调用静态方法
        MathUtils mathUtils=null;
        int sum2=mathUtils.add(2,4);




       /*
       静态方法不能访问实例变量和实例方法
       System.out.println(n);
       tests();
       */


    }

}


//工具类中的方法定义为静态方法，可以方便编程使用
class MathUtils {

    public static int add(int m, int n) {
        return m + n;
    }
}
