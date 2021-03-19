package com.demo.basicdemo.keywords.statics.static_variable;


import org.testng.annotations.Test;


/**
 * static关键字主要用于内存管理。我们可以应用java static关键字在变量，方法，块和嵌套类中； static关键字属于类，而不是类的实例
 *
 * 静态变量
 * 定义：static关键字修饰的变量，叫类变量或者静态变量,是类级别或者模板级别的变量，被所有对象所共享(和具体的对象无关)
 *      注意：类变量只能定义在类内方法外,即使是类方法内部也不能定义静态变量
 *
 * 存储位置：方法区中的静态区,被类的所有实例共享,可以节省内存，使程序存储器高效
 *
 * 初始化：
 * JVM会在加载字节码文件的时候静态变量进行空间分配以及初始化(参考饥饿单例模式)，当系统创建该类的对象时，系统不会再为类变量分配内存， 也不会
 * 再次对类变量进行初始化
 *
 * 生存时间：静态全局变量随着类的字节码文件加载而加载产生，随着字节码文件的消失而消失(取决于类的生命周期)，生存时间比类的对象还要长；
 *
 * 使用：类名.类变量或者对象.类变量访问，但是建议类名.类变量, 因为类变量(包括类方法)和对象是无关的
 *      另外在当前类调用时候可以省略类名或者对象名
 *
 *
 * 用途：比如常用一个布尔型静态成员变量做控制符；计数器(统计对象数量)； 若所有对象共享相同的属性(员工公司名称，学生所在的大学名称)，建议定义为静态属性
 *
 * 注意：
 * 对static关键字而言，有一条非常重要的规则：类成员（包括成员变璧、方法、初始化块、内部类和内部枚举）
 * 不能访问实例成员（包括成员变量、方法、初始化块、内部类和内部枚举）
 */
public class People {

    //实例变量和对象绑定， 不同的对象拥有自己单独的一套实例变量
    private String name;
    private int age;


    //所有对象共享这个静态变量，或者说任何一个对象修改这个静态变量，产生的结果对所有的对象是等价的
    private static String nation = "China";
    private static int count;


    public People() {
        System.out.println("People() is invoked");
        count++;//等价于this.count++; this用在构造方法时候表示正在创建的对象
    }

    //static variable和具体对象无关，所以一般不会出现构造方法中
    public People(String name, int age) {
        System.out.println("People(String name, int age) is invoked");
        this.name = name;
        this.age = age;
        count++;//等价于this.count++; this用在构造方法时候表示正在创建的对象
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

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        People.nation = nation;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        People.count = count;
    }

    public void  display(){
        System.out.println(name + " is " + age + " and comes from " + nation);
    }



    @Test
    public static void test() {
        People p = new People("phy", 31);
        People p2 = new People("mxz", 55);

        //s和s2共享类变量nation
        p.display();
        p2.display();

        //通过对象(引用)访问静态变量nation
        System.out.println(p.nation);//对象访问,这里本质还是用对象所属的类名进行访问：People.nation
        System.out.println(p2.nation);//对象访问,这里本质还是用对象所属的类名进行访问：People.nation
        if ((p.getNation() == p2.getNation())) {
            System.out.println("s.getNation()==s2.getNation()");
        } else {
            System.out.println("s.getNation()!=s2.getNation()");
        }

        //这里本质还是用对象所属的类名进行访问：People.nation，所以依然可以正常访问到nation,不会出现空指针异常，也说明了静态变量不需要依赖对象的存在
        p2 = null;
        System.out.println(p2.nation);

        //类名访问
        System.out.println(People.nation);

        //当前类中可以省略类名访问静态变量
        System.out.println(nation);


        //任何一个对象修改这个静态变量，产生的结果对所有的对象是等价的
        p.nation = "USA";
        System.out.println(p2.nation);
    }


    /**
     * test2方法执行之前会首先通过空参构造创建Peo[le对象，然后在开始执行test2方法,所以一共会创建三个对象
     */
    @Test
    public void test2() {
        People s = new People("ocean", 100);
        People s2 = new People("ocean", 120);
        System.out.println("The count of the instance of People is " + People.getCount());
    }

    /**
     * TestNG测试方法执行前会首先创建当前类对象，即使是当前方法test2_2()是static method
     */
    @Test
    public static void test2_2() {
        People s = new People("ocean", 100);
        People s2 = new People("ocean", 120);

        //test2方法执行之前会首先通过空参构造创建StaticVariable对象，然后在开始执行test2_2方法
        System.out.println("The count of the instance of People is " + People.getCount());
    }


}
