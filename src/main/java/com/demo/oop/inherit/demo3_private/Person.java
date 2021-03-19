package com.demo.oop.inherit.demo3_private;

public class Person {
    public String name;
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student s=new Student(1572116,"ocean",25);
        // 即使在Person类内部也不能直接访问age属性，说明private只能在定义的类中被定义类的类型对象(编译及运行时类型)直接访问和修改修改，即使是子类也不能直接访问
        //简单来说就是要满足一是在定义类中操作，二是对象的编译及运行时类对象都属于定义属性的类
        //System.out.println(s.age);


        //属性静态绑定：编译期和运行期，成员变量（包括静态变量和实例变量）只与引用变量所声明的类型的对象绑定，
        Person p=new Student(1572116,"ocean",25);
        System.out.println(p.age);//这里age属性编译和运行期间都是绑定在Person类中，所以可以在当前定义age属性的类中被直接访问

    }
}
