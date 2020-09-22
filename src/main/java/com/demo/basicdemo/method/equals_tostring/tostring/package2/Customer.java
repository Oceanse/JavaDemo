package com.demo.basicdemo.method.equals_tostring.tostring.package2;

public class Customer {
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 重写原生的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void info(){
        System.out.println("this: "+this);
        System.out.println("this.toString: "+this.toString());
    }

    public void info2(){
        System.out.println("super.toString: "+super.toString());//调用当前对象的父类对象的原生toString
    }

    public static void main(String[] args) {
        Customer customer=new Customer("haiyang","pan");

        //打印重写后的toString
        System.out.println("customer: "+customer);
        System.out.println("customer.toString: "+customer.toString());
        customer.info();

        //打印原生的toString
        customer.info2();//Customer对象调用父类对象的原生toString
    }
}
