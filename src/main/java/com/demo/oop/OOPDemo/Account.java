package com.demo.oop.OOPDemo;

/**
 * 设计银行账户
 * 成员变量：账户姓名 账号 存款
 * 方法：存钱 取钱 查询余额
 */
public class Account {

    private int id;
    private String name;
    private double balance;

    public Account() {
    }

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    /**
     * 取钱
     * @param amount
     */
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient Balance");
        } else {
            balance=balance-amount;
            System.out.println(amount+" withdrawn");
        }
    }

    /**
     * 存钱
     * @param amount
     */
    public void deposit(double amount) {
        balance=balance+amount;
        System.out.println(amount+" deposited");
    }

    /**
     * 查询余额
     */
    public void checkBalance(){
        System.out.println("balance is "+balance);
    }

    public static void main(String[] args) {
        Account account=new Account(369,"Bill Gates",1000);
        account.withdraw(2000);
        account.withdraw(100);
        account.checkBalance();
        account.deposit(100);
        account.checkBalance();
    }
}
