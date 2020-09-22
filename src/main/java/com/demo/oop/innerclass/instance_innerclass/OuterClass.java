package com.demo.oop.innerclass.instance_innerclass;


/**
 * 把实例成员内部类InnerClass想象成外部类一种普通的引用类型的实例成员变量
 *
 * 实例成员内部类对象声明
 *   实例内部类对象声明完整格式：OutterClass.InnerClass in
 *   在外部类内部声明时候可以省略外部类限制符，直接InnerClass in
 *
 *  实例内部类对象创建
 *    实例成员内部类理解为外部类的一个成员，所以实例成员内部类对象是依附外部类对象而存在的，也就是说，如果要创建实例成员内部类的对象，前提是必须存在一个外部类的对象
 *    外部类内部创建语法： InnerClass in = 外部类对象.new InnerClass(xxx)或者new OutterClass(xxx).new InnerClass(xxx)
 *                     若this等价于当前外部类对象，在外部类实例方法中这样创建：InnerClass in = this.new InnerClass(xxx) 或者 InnerClass in = new InnerClass(xxx)
 *
 *  成员访问：实例成员内部类理解为外部类的一个成员，所以内部类对象可以无条件直接访问外部类所有成员变量或者方法，包括private成员变量或者方法
 *          当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象， 所以显式访问外部类成员变量1语法：外部类.this.成员变量
 *
 *          外部类对象不能直接访问内部类的成员变量或者方法，因为外部类对象存在的时候内部类对象可能不存在，所以内部类的成员变量或者方法也不存在，因此无法通过外部类对象直接访问内部类的成员变量或者方法，
 *          必须通过内部类对象去访问
 *
 */
public class OuterClass {

    private String name="outname";





    class InnerClass{
        private String name="inname";

        /**
         * 成员内部类理解为外部类的一个成员，所以可以访问外部类private成员变量
         * 外部类成员变量1和内部类成员变量2及内部类局部变量3同名时候，系统查找顺序：3--->2--->1
         * 显式访问外部类成员变量1语法：外部类.this.成员变量
         * 显式访问内部类成员变量2语法：this.成员变量
         */
        public void showName(){
            String name="localname";
            System.out.println(name);
            System.out.println(this.name);//this代指内部类对象引用
            System.out.println(OuterClass.this.name);//StaticOuterClass.this代指外部类对象引用
        }
    }





    public static void main(String[] args) {

        //实例成员内部类构造方法想象成外部类的一个普通方法,静态方法内不能直接访问普通实例方法(可以访问外部类构造方法)
        //InnerClass in=new InnerClass();


        //通过外部类对象直接创建内部类对象
        //这里等价于 StaticOuterClass.InnerClass innerClass2 = new StaticOuterClass().new InnerClass()，外部类内部声明内部类对象时候会自动添加上外部类限制符
        InnerClass innerClass = new OuterClass().new InnerClass();

        innerClass.showName();

    }
}
