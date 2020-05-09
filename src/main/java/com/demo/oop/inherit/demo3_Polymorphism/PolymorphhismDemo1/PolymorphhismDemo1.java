package com.demo.oop.inherit.demo3_Polymorphism.PolymorphhismDemo1;

import com.demo.oop.inherit.demo2_this_super.Coder;
import com.demo.oop.inherit.demo2_this_super.Person;
import org.testng.annotations.Test;

/**
 * 运行时多态(动态方法分派): SupperClass obj=new SubClass();  obj.method();
 * obj在编译时期是SupperClass类型， 但是编译时类型并不是实际的类型；实际的实现类是在运行时决定的(运行时才会创建对象)；
 * 所以编译期间无法决定将调用哪个类方法，此决定在运行时完成，因此这也叫作运行时多态或动态方法分派。
 *
 * 编译时多态：详见ovload
 *
 * 静态绑定：当编译时(由编译器)确定对象的类型时，它被称为静态绑定； Class obj=new Class();obj.method();
 * obj在编译和运行期都是同一个类型，要调用的方法也是确定的，这里就不存在多态
 *
 *
 * 多态步骤：继承，重写，向上转型
 *
 */
public class PolymorphhismDemo1 {

    /**
     * 父类的引用变量引用子类的对象时，称为向上转型；具有父子继承关系的类才可以向上转型
     * 向上转型后，引用变量再不同时期拥有不同类型：编译时类型和运行时类型
     * 编译时类型看左边(父类类型)，运行时类型看右边(子类类型)
     */
    @Test
    public void test() {
        //向上转型 编译时是Person类型，运行时是Student类型类型
        Person person = new Student("tom", 21, true, 100);
        person.info();

        //向上转型 编译时是Person类型，运行时是Coder类型
        System.out.println();
        Person person2 = new Coder("ocean", 30, false, 20000);
        person2.info();
    }


    /**
     * 具有父子继承关系的类才可以向上转型
     * 向上转型后，引用变量再不同时期拥有不同类型：编译时类型和运行时类型
     * 编译时类型看左边(父类类型)，运行时类型看右边(子类类型)
     * 向上转型下的变量不能调用子类独有的方法
     */
    @Test
    public void test2() {
        //向上转型 编译时是Person类型，运行时是Student类型类型
        Person person = new Student("tom", 21, true, 100);
        show(person);
        //person.campus(); student编译时是Person类型,Person类没有campus()方法，所以会编译报错

        //向上转型 编译时是Person类型，运行时是Coder类型
        System.out.println();
        Person person2 = new Coder("ocean", 30, false, 20000);
        show(person2);
        //person2.post();coder编译时是Person类型,Person类没有post()方法，所以会编译报错
    }


    /**
     *  向下转型，先向上转型，然后才能向下转型
     *  向下转型就是使得变量类型由向上转型时的两者类型统一成一种类型(无论何种时期)
     */
    @Test
    public void test3() {

        System.out.println();
        Person person3 = new Student("mary", 18, false, 120);
        Student student = (Student) person3;//向下转型后，student编译时和运行时都是Student类型
        student.campus(); //编译运行时候都不会报错，可以调用子类独有的方法

        //向下转型，具有父子关系的类才可以向上转型/向下转型
        Person person4 = new Coder("danis", 60, true, 100000);
        Coder coder = (Coder) person4;//向下转型后，Coder编译时和运行时都是Coder类型
        coder.post();//编译运行时候都不会报错，可以调用子类独有的方法
    }

    /**
     * 父类static方法被所有子类继承拥有
     */
    @Test
    public void test5(){
        Person.showNation();
        Coder.showNation();
        Student.showNation();

        //在Student，Coder，Singer可以省略类名直接调用showNation(),因为三个子类通过继承父类拥有了静态方法showNation()
    }

    public static void show(Person person) {
        person.info();
    }


}

