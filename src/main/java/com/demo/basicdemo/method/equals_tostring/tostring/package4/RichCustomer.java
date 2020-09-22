package com.demo.basicdemo.method.equals_tostring.tostring.package4;

import com.demo.basicdemo.method.equals_tostring.tostring.package2.Customer;

public class RichCustomer extends Customer {
    private long balance;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    /**
     * 重写父类Customer的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "Customer [order=" + order + ", FirstName()=" + getFirstName()
                + ", LastName()=" + getLastName() + "]";
    }

    public static void main(String[] args) {
        RichCustomer customer = new RichCustomer();
        customer.setFirstName("Rajesh");
        customer.setLastName("Bhojwani");
        customer.setBalance(110);
        Order order = new Order("A1111","Game",100,"In-Shiping");
        customer.setOrder(order);
        System.out.println(customer);//等价于 System.out.println(customer.toString())
        System.out.println(new RichCustomer());//等价于 System.out.println(new RichCustomer().toString())
    }
}


class Order{
    private String orderId;
    private String desc;
    private long value;
    private String status;

    public Order(String orderId, String desc, long value, String status) {
        this.orderId = orderId;
        this.desc = desc;
        this.value = value;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", desc='" + desc + '\'' +
                ", value=" + value +
                ", status='" + status + '\'' +
                '}';
    }
}