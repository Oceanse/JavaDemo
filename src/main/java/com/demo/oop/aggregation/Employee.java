package com.demo.oop.aggregation;

public class Employee {
    int id;
    String name;
    private Address address;//Employee有一个实体引用地址(Address)，因此关系是：Employee HAS-A Address

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {//在Employee使用Address类的功能
        System.out.println(id + " " + name);
        System.out.println(address.getCity() + " " + address.getProvince());
    }

}
