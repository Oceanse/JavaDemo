package com.demo.concurrent.thread_safe.thread_safe_cause;


/*
 * 当多个线程在操作同一个共享数据时，一个线程对多条语句只执行了一部分，
 * 还没有执行完，另一个线程参与进来执行。导致共享数据的错误
 *
 * 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行
 * */
public class Thread_Safe_Cause3 {


    public static void main(String[] args) {

        Account account=new Account(123,9000);

        //创建启动两个线程，两个线程拥有同一个Account对象
        new Thread(new Processor(account)).start();
        new Thread(new Processor(account)).start();

    }
}

class Processor implements Runnable{

    Account accountc;//一个类引入另一个类对象,后面会针对这个对象进行操作

    public Processor(Account accountc) {
        this.accountc = accountc;
    }

    @Override
    public void run() {
        accountc.withdraw(1000);//线程体去执行withdraw动作
        System.out.println("账号为 "+accountc.getAccountId()+" 账户余额："+accountc.getBalance());

    }
}

class Account {

    int accountId;
    double balance;

    public Account() {
    }

    public Account(int accountId, double balance) {
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
        此时第二线程进来就 balance-money，导致余额不正常  */

        double balance=this.balance-money;

        try {
            Thread.sleep(2000);//某个线程执行到这延迟(阻塞)2s，其它线程就会执行这段代码，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setBalance(balance);
    }
}
