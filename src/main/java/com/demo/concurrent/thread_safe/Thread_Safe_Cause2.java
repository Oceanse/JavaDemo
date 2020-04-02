package com.demo.concurrent.thread_safe;


public class Thread_Safe_Cause2 implements Runnable {



    //三个线程对象会抢占式执行这段线程体
    @Override
    public void run() {

        while(Ticket.ticket>0){
            //假设当前ticket=100,三个线程可能依次执行完打印这一步后都失去cpu阻塞，所以会打印出三张ticket=100的重票；
            //如果最后还剩一张票ticket=1，三个线程可能执行完while(Ticket.ticket>0)，然后都失去cpu阻塞在这一步，然后依次执行，所以会打印出1,0，-1，两张错票
            System.out.println(Thread.currentThread().getName()+"票号"+Ticket.ticket);
            Ticket.ticket--;
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        Thread_Safe_Cause2 t=new Thread_Safe_Cause2();
        Thread thread=new Thread(t);
        Thread thread2=new Thread(t);
        Thread thread3=new Thread(t);

        //启动三个线程
        thread.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");


        thread.start();
        thread2.start();
        thread3.start();
    }
}


class Ticket{
    static int ticket=100;//三个线程对象拥有着同一个Thread_Safe_cause对象，执行同一个线程体，共同修改同一份数据ticket
}