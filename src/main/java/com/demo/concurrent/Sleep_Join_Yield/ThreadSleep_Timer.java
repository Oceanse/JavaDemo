package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadSleep_Timer {


    public static void main(String[] args) throws InterruptedException {

        //new ThreadSleep_Timer().test();
        new ThreadSleep_Timer().test2();



    }


    public void test(){
         /*
            主线程执行到这里时会休眠3s，此时因为只有一个主线程，所以进程中也没有其它线程争抢cpu,
            因此这里的sleep(3000)相当于延时3s,然后执行sleep后面的代码
        */

        System.out.println("现在开始计时.....");
        long start=System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("时间过去了"+(end-start)/1000+"s");
        System.out.println("3s后我被执行了");

    }



    public void test2(){
         /*整个进程只有一个单线程
           循环过程中加入延时，此时因为只有一个主线程，所以进程中也没有其它线程争抢cpu,
           因此两轮循环之会间隔1s,最后的效果就是每秒输出一个数字*/

        for (int i = 0; i <10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }


}
