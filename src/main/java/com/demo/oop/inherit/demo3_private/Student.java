package com.demo.oop.inherit.demo3_private;

/**
 * 子类继承父类后，子类就拥有了父类全部的属性和行为，可以把继承过来的属性和方法全部脑补到子类当中；
 * 只不过对于父类私有属性和方法，子类只能间接拥有(通过继承父类暴露的getter/setter/constructor等方法间接访问和修改)
 * 也就是对于private属性，不能通过子类对象
 */
public class Student extends Person{
    public int id;

    //说明正在创建的Student对象拥有id属性和name属性
    public Student(int id, String name, int age) {
        //this.age=age; //当前正在创建的Student对象不能直接访问父类中的私有age属性
        super(age); //父类暴露的public constructor修改父类私有属性age
        this.id = id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {

        //父类暴露的constructor修改父类私有属性age
        Student s=new Student(1572116,"ocean",25);

        // public int getAge() {return age;}是父类pubic方法，被子类继承后这个方法就变成子类自己的方法(继承过来就是自己的了)， 可以return age说明子类拥有这个属性，只不过只能通过某些方法访问
        System.out.println(s.getAge());

        // public int setAge() {this.age = age;;}是父类pubic方法，被子类继承后这个方法就变成子类自己的方法(继承过来就是自己的了)， 可以this.age说明子类拥有这个属性，只不过只能通过某些方法修改
        s.setAge(30);
        System.out.println(s.getAge());


        //age' has private access in 'com.demo.oop.inherit.demo3_private.Person'
        //private类型的数据成员只能在定义的类内部被直接访问和修改(对象.属性)，其余任何地方都不可以，在类外部通过该类的对象也不可以 对象.属性。
         Person p=new Person();
         //System.out.println(p.age);
    }

}
