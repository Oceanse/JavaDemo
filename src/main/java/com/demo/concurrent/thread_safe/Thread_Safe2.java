package com.demo.concurrent.thread_safe;


/*
 * 当多个线程在操作同一个共享数据时，一个线程对多条语句只执行了一部分，
 * 还没有执行完，另一个线程参与进来执行。导致共享数据的错误
 *
 * 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行
 * */
public class Thread_Safe2 {


    public static void main(String[] args) {

        Accounts accounts=new Accounts(123,9000);

        //创建启动两个线程，两个线程拥有同一个Account对象
        new Thread(new Processors(accounts)).start();
        new Thread(new Processors(accounts)).start();

    }
}

class Processors implements Runnable{

    Accounts accountcs;//一个类引入另一个类对象,后面会针对这个对象进行操作

    public Processors(Accounts accountcs) {
        this.accountcs = accountcs;
    }

    @Override
    public void run() {
        accountcs.withdraw(1000);//线程体去执行withdraw动作
        System.out.println("账号为 "+accountcs.getAccountId()+" 账户余额："+accountcs.getBalance());

    }
}

class Accounts {

    int accountId;
    double balance;

    public Accounts() {
    }

    public Accounts(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money)  {

        /*多个线程同一时间都进入了这段代码会导致线程安全问题
        其中一个线程处理完balance-money，但是还没有更新余额this.setBalance(balance)
        此时第二线程进来就 balance-money，导致余额不正常
         synchronized()
         */

        synchronized (this) {//this是指Accounts对象，这里多个线程共享同一个Accounts对象，所以this对象可以保证锁的唯一性，因此这里可以用this
            double balance=this.balance-money;

            try {
                Thread.sleep(2000);//某个线程执行到这延迟(阻塞)2s，其它线程就会执行这段代码，
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.setBalance(balance);
        }
    }




    //上面synchronized可以用在方法上，这样就同步了方法体中的所有代码，使得程序执行效率降低；
    //synchronize用在代码块上更加灵活高效
  /*  public synchronized void withdraw(double money)  {

            double balance=this.balance-money;

            try {
                Thread.sleep(2000);//某个线程执行到这延迟(阻塞)2s，其它线程就会执行这段代码，
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.setBalance(balance);
    }*/


}

