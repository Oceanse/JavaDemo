package com.demo.basicdemo.method;


/*
 * return 这个关键中，用在方法中， 有两个作用： 1 方法执行结束，跳出方法， 2 返回方法结果；
 * 所以，如果方法指定了无需返回值 即是 void，但又因为方法内部业务逻辑需要结束运行， 则可以只用retrun来跳出方法, 不需要返回任何数据
 *
 *  return语句只要被执行，所在方法就会执行结束，所以return后面不能跟其他语句
 * */

import org.testng.annotations.Test;

public class ReturnDemo {
    public static void main(String[] args) {

    }


   /*
   public static int sum(int i,int j){
        if(i>0&j>0){
            return i+j;//这里的return不一定被执行，也就是方法最终不一定有返回值，和方法定义时的int自相矛盾
        }

        所以要在这里带一个return语句
    }
    */

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

        test3();
        String progress="ok";
        String str="{\"progress\":" + progress + ",\"links\":[],\"logs\":[{\"name\":\"CATLog\",\"id\":\"f52e6a8f-94cc-4b78-a4cc-0c95590288c3\",\"type\":\"text\"}],\"status\":\"running\"}";
        System.out.println(str);
    }


    public static String test3(){
        System.out.println(123);
        return null;
    }

}
