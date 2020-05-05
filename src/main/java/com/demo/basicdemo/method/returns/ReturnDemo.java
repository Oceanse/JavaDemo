package com.demo.basicdemo.method.returns;


/*
 * return 这个关键中，用在方法中有两个作用：
 * 1 返回方法结果；
 * 2 方法执行结束，跳出方法；如果方法无需返回值但又因为方法内部业务逻辑需要结束运行， 则可以只用retrun来跳出方法, 不需要返回任何数据
 *    return;语句只能出现在void方法中
 *
 *  return语句只要被执行，所在方法就会执行结束，所以return后面不能跟其他语句
 * */

import org.testng.annotations.Test;

public class ReturnDemo {
    public static void main(String[] args) {

    }


    /**
     * 这里需要if语句保证存在返回值，假设去掉else分支会报错
     * @param d
     * @return
     */
   public static double abs(double d){
        if(d<0){
            return -d;//这里的return不一定被执行，也就是方法最终不一定有返回值，和方法定义时的int自相矛盾
        }
        else {
            return d;
        }
    }

    public static void sum(int i, int j) {
        System.out.println("hahaha");
        return;//方法执行结束，用return关键字跳出方法

    }


    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                break;  //终止for循环,不会终止方法
                //return; //终止方法
            }
        }
        System.out.println("hahaha");//前面如果是return，这里永远不会被执行
    }





    @Test
    public static void test2() {

        test3();//这里相当于没有接收test3()的返回值，可以想象成String res=test3();
        test4();
        String str="come on";
        System.out.println(str);
    }


    public static String test3(){
        return null;
    }

    public static void test4(){
        return;
        //后面不能跟语句
    }

}
