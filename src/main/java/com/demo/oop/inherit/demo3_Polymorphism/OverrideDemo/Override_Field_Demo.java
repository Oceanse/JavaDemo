package com.demo.oop.inherit.demo3_Polymorphism.OverrideDemo;

/**
 * 子类和父类具有相同的属性,在使用子类对象(没有父引用指向子类对象)调用同名属性时候调用的时候子类的属性，个人也理解为“属性被覆盖”
 */
public class Override_Field_Demo {
    String id="37xxx";//身份证号

    public Override_Field_Demo() {
    }

    public Override_Field_Demo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}




class Stu extends Override_Field_Demo {
    String id="15xx";//学号

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }


    /**
     *  访问当前对象的id
     */
    public void accessStuId() {
        System.out.println(this.id);
    }


    /**
     * 调用当前类对象的父类对象的id
     */
    public void accessAnimalId() {
        System.out.println(super.id);
    }

    public static void main(String[] args) {

        //创建子类对象时候一定会先创建父类对象
        Stu s=new Stu();
        s.accessStuId();
        s.accessAnimalId();

        Override_Field_Demo s2=new Stu();
        System.out.println(s2.id);

    }
}
