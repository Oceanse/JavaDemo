package com.demo.basicdemo.keywords.finals.unmutable_instance.demo3;

/**
 * 关于不可变类：
 * 当final修饰的成员变量属于引用类型变量时候，仅表示这个变量保存的地址或者指向的对象时不可变的，但是对象的内容确时可变的，
 * 这就不符合不可变类的初衷；期待结果是变量指向的对象和这个对象的内容都不能被修改
 * 因此要保证final引用变量指向的对象没有其他手柄指向它，也就是保证只有final引用变量指向那个对象
 */
public class Person {
    private final String names;
    private final int age;
    private final Address address;

    public Person(String names, int age, Address addressParam) {
        this.names = names;
        this.age = age;
        //这里addressParam和address指向不同的Address对象,保证address指向的对象只有一个手柄
        this.address=new Address(addressParam.getProvince(),addressParam.getCity());
    }

    @Override
    public String toString() {
        return "Person{" +
                "names='" + names + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        Address addressParam=new Address("Shandong","Weifang");
        Person person=new Person("Ocean",31,addressParam);
        System.out.println(person.toString());

        addressParam.setCity("Qingdao");
        System.out.println(person.toString());

    }

}

class Address{
    String province;
    String city;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}