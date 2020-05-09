package com.demo.basicdemo.method.equals_tostring;

import com.demo.oop.inherit.demo2_this_super.Person;
import org.testng.annotations.Test;

public class EqualsDemo {

    String content;
    int num;


    public EqualsDemo() {
    }

    public EqualsDemo(String content, int num) {
        this.content = content;
        this.num = num;
    }


    /**
     * public boolean equals(Object obj) {
     * return (this == obj);
     * }
     * 注意==两边如果是引用类型变量，则比较的是两个引用对象的地址
     * Object中的equals的equals比较的是两个对象的内存地址是否相同
     * 现实业务中有时候需要比较的是两个对象的内容而不是两个对象的地址
     */
    @Test
    public void test() {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.equals(o2));//Object中的equals的equals比较的是两个对象的内存地址是否相同
    }


    /**
     * Persons没有重写Object中的equals方法，所以比较的是两个对象的内存地址是否相同
     */
    @Test
    public void test2() {
        Person p = new Person();
        Person p2 = new Person();
        System.out.println(p.equals(p2));//
    }

    @Test
    public void test3() {
        String s1 = new String("a");
        String s2 = new String("a");
        System.out.println(s1.equals(s2));//包装类重写Object中的equals方法，重写后的方法比较的是两个对象的内容是否相同
    }


    //重写Object的equals方法，比较的两个对象的内容是否相同
    @Override
    public boolean equals(Object obj) {//父类引用指向子类对象，所以调用子类独有方法或者属性时候需要进行强转
        if (this == obj)
            return true;
        if (obj instanceof EqualsDemo) {
            EqualsDemo e = (EqualsDemo) obj;
            if (this.num == e.num && this.content.equals(e.content)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test4() {

        EqualsDemo e = new EqualsDemo("aa", 123);
        EqualsDemo e2 = new EqualsDemo("aa", 123);

        //本类重写Object中的equals方法，重写后的方法比较的是两个对象的内容是否相同
        System.out.println(e.equals(e2));
    }


}
