package com.demo.basicdemo.variable;

import com.demo.basicdemo.code_block.construct_block.demo1.Person;
import com.demo.oop.aggregation.Address;
import com.demo.oop.inherit.demo2_this_super.Human;
import org.testng.annotations.Test;

import java.util.*;


/**
 * 变量定义：本质是申请一块特定类型及名字的内存(memory)存储特定类型的数据；
 * 格式：数据类型 变量名(DataType identifier;)
 * <p>
 * 变量三要素：数据类型 变量名 变量值
 * 变量类型: 决定内存空间大小；
 *
 *
 * 变量名：
 * 标识符(identifier)本意是标识某个实体的符号，可以划分为普通标识符和特殊标识符
 * 特殊标识符就是关键字，对Java编译器具备特殊意义的符号(特殊标识符)，不能用作 变量名、方法名等普通标识符。
 * 标识符通常是指普通标识符，java中所有自己命名的位置所用的都是普通标识符: 包名 接口名 类名 方法名 变量名 参数名
 * 标识符命名规则：字母，0-9 ，_或 $，不能以数字开头，普通标识符不能是关键字
 * 变量名就是这块内存空间的名字(同一个作用域内，变量名不能相同)，属于普通标识符的一种
 * 变量名命名：驼峰命名法(第一个单词以小写字母开始；从第二个单词开始以后的每个单词的首字母都采用大写字母)；
 *           变量名要尽量见明知意
 *           变量名不能是关键字
 *
 * 变量值
 * 变量值就是变量内存空间存储的内容；
 * Java语言是强类型语言，变量和变量值都具备类型属性，特定类型的变量只能存储特定类型的变量值，也就是变量和变量值要匹配，float f=1;
 *
 *
 * 变量赋值及多次赋值：
 * 变量赋值严格来说是把特定类型的变量值/数据存储到特定类型的变量空间(内存空间)中， 这里变量和变量值都具备类型属性，
 * 基本类型变量存储字面值(包括基本类型数值以及字符串)，引用类型变量存储对象的引用(地址)；
 * 变量空间运行期可以反复写入赋值，所以称之为变量；另外后面写入的值会覆盖前面的值。
 * <p>
 * <p>
 * 变量的作用：编程的本质就是对内存数据进行访问和修改。程序运行时候所有的数据及保存在内存当中，所以会通过变量这一机制对内存中的数据进行访问和修改
 * <p>
 * <p>
 * 变量分类：
 * 按类型：八种基本数据类型(Primitive Data Type：数值型，字符型，布尔型)   三种引用数据类型(Reference Data Type:类似于指针，包括Object及其子类 接口 数组)
 * 关于null：null可以看作一种特殊的引用类型变量值，不能赋值给基本类型变量，可以赋值给任意引用类型的变量(null可以属于任何引用类型数据)，可以理解为内存空间存储着null这种不指向任何位置的特殊数据
 * 按作用域：局部变量 全局变量
 * <p>
 * 变量类型转换：
 * 本质是对变量空间存储的变量值/数据的副本进行类型转换，变量类型(接收的数据类型)和变量存储的变量值的类型并没有发生改变
 * 数据类型的转换是在所赋值的数值类型(变量值类型)和变量接收的数据类型(变量类型)不一致时发生的，它需要从一种数据类型转换成另一种数据类型；
 * 数据类型转换的本质是对数据进行强转，包括栈内存和堆内存中数据
 * 自动类型转换和强制类型转换  向上转型/向下转型 装箱/拆箱 其他类型<==>字符串
 */
public class VariableDemo {


    /**
     * 变量的声明和初始化：开辟内存空间，存储数据
     */
    @Test
    public void test() {
        //先声明，后初始化 You can declare a variable without assigning the value, and assign the value later
        int age;  //声明只是分配内存空间，但是内存空间没有存储值，并起名为a
        age = 30;    //给变量名为a的内存空间赋值1
        System.out.println(age);//这里进行值传递，把变量值30传递给System.out.println()，打印变量a存储的值

        Person person;
        person=new Person();
        System.out.println(person);


        // 同时声明多个同类型变量，然后再初始化
        String username, city, phone;
        username = "ocean";
        city = "Shanghai";
        phone = "18800203512";
        System.out.println("My name is " + username + " and come from " + city + " and my phone no is " + phone);

        Human human1,human2;
        human1=new Human();
        human2=new Human();




        //同时声明初始化 declare a variable called b of type double and assign it the value 1.0 meanwhile:
        double score = 99.5;//声明double类型变量的同时赋值为1.0
        System.out.println(score);

        Address address=new Address("Shandong","Weifang");


        //同时声明初始化多个同类型变量 To declare more than one variable of the same type, use a comma-separated list:
        int x = 5, y = 6, z = 50;
        System.out.println(x + y + z);

        Address address1=new Address("Qinghai","Xining"), address2=new Address("Guangdong","Shenzhen");



        //多次赋值(修改变量的值)
        //变量值可以反复修改 Note that if you assign a new value to an existing variable, it will overwrite the previous value:
        char letter = 'a';//声明char类型变量的同时赋值为'a'
        letter = 'b';     //将变量c存储的值重新赋值为'b'
        System.out.println(letter);

        Human parent = new Human("mother", 54);//parent指向母亲对象
        parent = new Human("father", 64);//parent重新指向父亲对象
        parent.info();


        //方法体中的代码自上而下执行,  Java 中的变量需要先声明后使用
        //System.out.println(hobby);
        String[] hobby = {"coding","reading"};

        //List hobby;   //在同一个栈作用域内，变量名不能相同
    }


    /**
     * 变量分类
     */
    @Test
    public void test1() {

        //八种基本数据类型：数值型 字符型 布尔型； 或者数值型和布尔型(字符型可以看作是数值型)
        //所有的基本数据类型的大小（所占用的字节数）都已明确规定，在各种不同的平台上保持不变，这一特性有助于提高 Java 程序的可移植性。
        byte b = 123;   //byte占有内存1个字节（8bit）,取值范围-2^7~2^7-1也就是-128~127(2^8=256)  Save memory when you are certain that the value will be within -128 and 127:
        short s = 256;  //2字节 取值范围-2^15~2^15-1
        int i = 456888; //4字节 取值范围-2^31~2^31-1
        long l = 234L;  //8字节 取值范围-2^63~2^63-1
        float f = 1.0F; //4字节, 数值后面紧跟F或者f
        double d = 2.0; //8字节
        char sex = '女';   //2字节(2^16=65536: 0~65535, \u0000~\uffff)
        boolean flag = true;//1 bit

        //三种引用数据类型接口类型 类类型 数组类型
        //引用类型变量存储对象的引用(地址)
        String myName = "ocean";
        Map<String, String> envVariable = new HashMap<>();
        String[] nameList = {"Tom", "Marry"};

    }




    /**
     * 变量类型转换：本质是对变量空间存储的变量值复制一份然后进行类型转换(对变量值的副本进行转换)，变量本身(变量类型和变量值类型)并没有发生改变
     */
    @Test
    public void test2_1() {

        //这里本质是对变量old存储的变量值"1"进行自动类型转换，变量old的类型和存储的值并没有改变；  可以理解为读取变量old存储的变量值"1"，然后复制一份，然后对副本进行类型转换
        int old = 1;
        double result = old / 1.0;
        int news = old; //这里说明old变量值类型是int，所以old变量类型也是int
        System.out.println(old);//old变量类型和存储的变量值都没有变(ctrl + 点击println验证)
        System.out.println(result);//ctrl + 点击println验证result是double类型


        //这里本质是对变量old2存储的变量值"1.1"进行强制类型转换， 变量old2的类型和存储的值并没有改变； 可以理解为读取变量old2存储的变量值"1.2"，然后复制一份，然后对副本进行类型转换
        double old2 = 1.1;
        int result2 = (int) old2 / 1;
        System.out.println(old2);//ctrl + 点击println验证old2是doouble类型
        System.out.println(result2);//ctrl + 点击println验证result2是int类型
    }


    /**
     * 自动类型转换(赋值或者运算时发生)
     * 变量空间存储的变量值复制一份然后进行类型转换，变量本身(变量类型和变量值)并没有发生改变
     * 容量小的类型自动转换为容量大的数据类型byte、short、char-->int-->long-->float-->double(也可以跨越转换)
     * byte,short,char之间不会相互转换,他们三者在计算时首先转换为int类型，即使是同类型间计算也会先转换成int再计算
     * 有多种类型的数据混合运算时， 系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算
     * <p>
     * 自动类型转换场景：
     * 1： 赋值
     * 2：算术运算
     */
    @Test
    public void test2_2() {

        System.out.println("1==========================");
        long l = 1;//1首先会自动类型转换为long类型，然后赋值给l
        float f=1;//1首先会自动类型转换为float类型，然后赋值给f
        double d=1;//1首先会自动类型转换为double类型，然后赋值给d
        f=l;//首先l存储的变量值会自动类型转换为float类型，然后赋值给f
        int i = '中';//把字符'中'的十进制编号自动转换成int类型后赋值给整型变量

        System.out.println("2==========================");
        //若参与运算的数据类型不同，则先自动转换成同一类型，然后进行运算。
        System.out.println(12 / 5);
        System.out.println(12.0f / 5);
        System.out.println(12.0 / 5L);//long自动转为double(5->5.0),然后进行运算

        System.out.println("3==========================");

        //byte,short,char三者在计算时首先转换为int类型, 再进行计算，即使是同类型之间的运算;
        byte b = 1;
        short s = 2;
        char c = 'a';
        int bb = b + b;
        int ss = s + s;
        int cc = c + c;
        int sum = b + s + c;
        System.out.println(sum);

        System.out.println("4==========================");
        //任何基本类型的值和字符串值进行连接运算时(+)，基本类型的值将自动转化为字符串类型。
        System.out.println('a' + 1 + "Hello!");//第一个+是运算符，第二个+是字符串连接符
        System.out.println("Hello!" + 'a' + 1);//这里的两个+都是字符串连接符

    }


    /**
     * 强制类型转换:强制显示的把一个数据类型转换为另外一种数据类型,也称之为“narrow conversion”:缩小转换
     * 变量空间存储的变量值复制一份然后进行类型转换，变量本身(变量类型和变量值)并没有发生改变
     * 语法：（targetType）value
     * 被强转对象可以是对象或者该对象对应的引用变量；也可以是基本类型数据或者基本类型数据对应的变量
     */
    @Test
    public void test2_3(){

        //float f=2.1;  double类型数据不能直接赋值给float变量
        double d=2.1;
        float f = (float) d;//double变量存储的变量值2.1复制一份，然后强转成float类型，再赋值
        System.out.println(d);   //ctrl + 点击println验证
        System.out.println(f);   //ctrl + 点击println验证
    }



    public static void main(String[] args) {
        System.out.println("good luck!");
    }

}


