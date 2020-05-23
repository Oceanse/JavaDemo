package com.demo.basicdemo.variable;

import com.demo.oop.inherit.demo2_this_super.Human;
import org.testng.annotations.Test;

import java.util.*;


/**
 * 标识符(identifier)本意是标识某个实体的符号，可以划分为普通标识符和特殊标识符
 * 标识符通常是指普通标识符，java中所有自己命名的位置所用的都是普通标识符: 接口名 类名 方法名 变量名
 * 特殊标识符就是关键字，对Java编译器具备特殊意义的符号(特殊标识符)，不能用作 变量名、方法名等普通标识符。
 * 标识符可以是字母，0-9 ，_或 $，不能以数字开头，普通标识符不能是关键字；
 * <p>
 *
 *  字面值: A literal is the source code representation of a fixed value  without requiring computation, 包括基本类型数值以及字符串
 * <p>
 * 变量定义：本质是申请一块特定类型及名字的内存(memory)存储特定类型的数据；格式：数据类型 变量名(DataType identifier;)
 *
 * 变量三要素：数据类型 变量名 变量值
 * <p>
 * 变量赋值：把数据存入指定的内存空间，基本类型变量存储字面值( A literal is the source code representation of a fixed value  without requiring computation)，引用类型变量存储对象的引用(地址)；
 * 变量赋值严格来说是把特定类型的变量值/数据存储到特定类型的变量空间中， 也就是说变量值也是具备类型的
 * 变量空间运行期可以反复写入赋值，所以称之为变量；另外后面写入的值会覆盖前面的值。
 * <p>
 * 变量特点：Java语言是强类型语言，包括两层含义：所有的变量必须先声明、后使用(使用的含义包括赋值)； 指定类型的变量只能接受与之匹配的数值
 * <p>
 * <p>
 * 变量的作用：编程的本质就是对内存数据进行访问和修改。程序运行时候所有的数据及保存在内存当中，所以会通过变量这一机制对内存中的数据进行访问和修改
 * 变量类型决定内存空间大小，变量名就是这块内存空间的名字(同一个作用域内，变量名不能相同)
 * <p>
 * 变量方法命名：驼峰命名法(第一个单词以小写字母开始；从第二个单词开始以后的每个单词的首字母都采用大写字母)；变量名不能是关键字
 * <p>
 * null：null可以堪称是一种特殊的引用类型变量值，不能赋值给基本类型变量，可以赋值给任意引用类型的变量，可以理解为内存空间存储着null这种不指向任何位置的特殊数据
 * <p>
 * <p>
 * <p>
 * 分类：
 * 按类型：八种基本数据类型(Primitive Data Type：数值型，字符型，布尔型)   三种引用数据类型(Reference Data Type:类似于指针，包括Object及其子类 接口 数组)
 *  按作用域：局部变量 全局变量
 *
 * 变量和变量存储的数据(变量值)都具备类型这一属性，特定类型的变量只能存储特定类型的数据
 * <p>
 * <p>
 * <p>
 * 变量类型转换：本质是对变量空间存储的变量值/数据进行类型转换，变量类型(接收的数据类型)并没有发生改变
 * 数据类型的转换是在所赋值的数值类型和变量接收的数据类型不一致时发生的，它需要从一种数据类型转换成另一种数据类型；
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

        // 同时声明多个变量，然后再初始化
        String username,address,phone;
        username="ocean";
        address="Shanghai";
        phone="18800203512";


        //同时声明初始化 declare a variable called b of type double and assign it the value 1.0 meanwhile:
        double score = 99.5;//声明double类型变量的同时赋值为1.0
        System.out.println(score);

        //同时声明初始化多个变量 To declare more than one variable of the same type, use a comma-separated list:
        int x = 5, y = 6, z = 50;
        System.out.println(x + y + z);


        //变量值可以反复修改 Note that if you assign a new value to an existing variable, it will overwrite the previous value:
        char letter = 'a';//声明char类型变量的同时赋值为'a'
        letter = 'b';     //将变量c存储的值重新赋值为'b'
        System.out.println(letter);

        //declare a variable called mother of reference type and assign it the value which is the "address" of the object :
        Human parent = new Human("mother", 54);//parent指向母亲对象
        parent = new Human("father", 64);//parent重新指向父亲对象


        //方法体中的代码自上而下执行,  Java 中的变量需要先声明后使用
        //System.out.println(d);
        int d = 0;

        //int d=1;   在同一个作用域内，变量名不能相同
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
        float f = 1.0F; //4字节
        double d = 2.0; //8字节
        char sex = '女';   //2字节(2^16=65536: 0~65535, \u0000~\uffff)
        boolean flag = true;//1 bit


        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.SIZE);
        //byte b=128; 128超出其byte取值范围, 128会被认为是int类型
        System.out.println();

        /*浮点型数据包括单精度浮点型（float）和双精度浮点型（double），代表有小数精度要求的数字，
          之间的区别主要是所占用的内存大小不同；双精度类型 double 比单精度类型 float 具有更高的精度和更大的表示范围
          浮点数有两种表达方式：小数和科学计数法
          Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少次方。
          比如3.14E3就是3.14 × 103 =3140，3.14E-3 就是 3.14 x 10-3 =0.00314。*/
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.SIZE);
        System.out.println();
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.SIZE);
        System.out.println();


        //三种引用数据类型接口类型 类类型 数组类型
        //引用类型变量存储对象的引用(地址)
        Object o;
        String myName = "ocean";

        Map<String, String> envVariable = new HashMap<>();
        List<String> vmargsList = new ArrayList<>();
        Set set = new HashSet();

        String[] nameList = {"Tom", "Marry"};

    }




    /**
     * 对于不带任何后缀的整数:
     * 1 如果将一个在byte/short/char范围内的整数赋值给byte/short/char变量，那么系统会自动把这个数当成byte/short/char类型
     * 2 其他情况下把任意一个整数赋值给int/long/float/double变量,系统会把这个变量当成int
     * 3 如果直接使用不带后缀的整型常量，这个整型常量会被当作int
     *
     *对于不带任何后缀的浮点数：
     * 都是double类型数据
     *
     */
    @Test
    public void test1_2 () {
        byte b = 127; //这里127是byte类型数据,因为int类型不能自动转换为byte，所以这里127不是int类型，
        short s=127; //这里127是short类型数据,因为int类型不能自动转换为short，所以这里127不是int类型，
        char c=127;//这里127是char类型数据，因为int类型不能自动转换为char，所以这里127不是int类型，
        int i=127; //这里127是int类型数据
        long l = 127;//这里127是int类型是数据，127会自动转换成long类型127L
        long l2 = 127L;//这里127L是long类型是数据
        float f = 127;//这里127是int类型是数据，127会自动转换成float类型127.0f
        double d = 127;//这里127是int类型是数据，127会自动转换成double类型127.0

        //byte b=128; 超出其byte取值范围, 128会被认为是int类型
        //long l3=9999999999;//系统会把9999999999当作是int类型，但是又超出了int的取值范围，会报 Integer Number too large
        long l4 = 9999999999L;//9999999999L表示long类型数据

        //这里的1和(1+1)结果的类型都是int
        //cntrl + 点击println验证
        System.out.println(1);
        System.out.println(1+1);

        //这里的1.1和(1+1.1)结果的类型都是double
        //cntrl + 点击println验证
        System.out.println(1+1.1);
        System.out.println(1.1);

    }







    /**
     * 变量类型转换：本质是对变量空间存储的变量值进行类型转换，变量类型并没有发生改变
     */
    @Test
    public void test2_1() {

        //这里本质是对变量old存储的变量值"1"进行自动类型转换，变量old的类型和存储的值并没有改变；  可以理解为读取变量old存储的变量值"1"，然后复制一份，然后对副本进行类型转换
        int old = 1;
        double result = old / 1.0;
        int news = old; //说明old变量类型没有变，没有自动转换成double类型
        System.out.println(old);//变量old存储的值没有变


        //这里本质是对变量old2存储的变量值"1.1"进行强制类型转换， 变量old2的类型和存储的值并没有改变； 可以理解为读取变量old2存储的变量值"1.2"，然后复制一份，然后对副本进行类型转换
        double old2 = 1.1;
        int resul2t = (int) old2 / 1;
        //int news2 = old2; //说明old2变量没有自动转换成int类型
        System.out.println(old2);
    }


    /**
     * 自动类型转换
     * 容量小的类型自动转换为容量大的数据类型byte、short、char-->int-->long-->float-->double
     * byte,short,char之间不会相互转换,他们三者在计算时首先转换为int类型，即使是同类型间计算也会先转换成int再计算
     * 有多种类型的数据混合运算时， 系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算
     */
    @Test
    public void test2_2() {

        System.out.println("1==========================");
        //以下运算都是把各变量存储的值首先转换成int,再进行计算，即使是同类型之间的运算
        //注意：变量b s c的类型本身并没有改变
        byte b = 1;
        short s = 2;
        char c = 'a';

        int bb = b + b;
        int ss = s + s;
        int cc = c + c;
        int sum = b + s + c;
        System.out.println(sum);

        long l = b;//byte类型数据可以跨级自动转换成log(猜测byte--->int--->long)

        //若参与运算的数据类型不同，则先自动转换成同一类型，然后进行运算。
        System.out.println("2==========================");
        System.out.println(12 / 5);
        System.out.println(12.0f / 5);
        System.out.println(12.0 / 5L);//long自动转为double(5->5.0),然后进行运算

        //任何基本类型的值和字符串值进行连接运算时(+)，基本类型的值将自动转化为字符串类型。
        System.out.println("3==========================");
        System.out.println('a' + 1 + "Hello!");//char占2字节，int4字节，char-->int
        System.out.println("Hello!" + 'a' + 1);

    }


    /**
     * 强制类型转换:强制显示的把一个数据类型转换为另外一种数据类型,也称之为“narrow conversion”:缩小转换
     * 语法：（targetType）value
     * 被强转对象可以是对象或者该对象对应的引用变量；也可以是基本类型数据或者基本类型数据对应的变量
     * 强转可能会引起溢出(Overflow)，造成数据丢失
     */
    @Test
    public void test2_3() {

        float f = 1.0f;
        int in = (int) f;//这里只是把变量f对应内存区域的数据拷贝一份，然后对副本进行强转，并不会改变变量空间类型以及存储的数值
        System.out.println("f=" + f);
        System.out.println("in=" + in);

        //浮点数到整数的转换是通过舍弃小数得到,可以强转常量值
        System.out.println((int) 23.5);
        System.out.println((int) -23.5f);

        /*
         * 强转可能损失精度;
         * 强转过程：
         * int类型 2255555底层以补码存储(正数原码反码补码一致)：00000000 00000000 01011000 00011011
         * 强转成byte,补码截取掉高位三个字节，保存低位一个字节进行保存  00011011
         * 00011011 最高位是0，表示正数，补码等于反码等于原码：00011011，转化成十进制就是27
         * */
        int i = 22555;
        byte bt = (byte) i;
        byte bt2 = (byte) 22555;
        System.out.println("i: " + i);//i的类型和保存的值并不会改变
        System.out.println("bt:" + bt);
        System.out.println("bt2:" + bt2);
        System.out.println();


        /*
         * 强转可能损失精度;
         * 强转过程：
         * int类型 233底层存储形式(补码)：00000000 00000000 00000000 11101001
         * 强转成byte,补码截取掉高位三个字节，保存低位一个字节进行保存   11101001
         * 11101000 最高位是1，表示负数；补码减1，得到反码：11101000
         * 反码除符号位外其它按位取反得到原码：10010111,其中最高位是符号位，所以转成十进制是-23
         * */
        int i2 = 233;
        byte bt3 = (byte) i2;
        byte bt4 = (byte) 233;
        System.out.println("i2: " + i2);//i的值并不会改变
        System.out.println("bt3:" + bt3);
        System.out.println("bt4:" + bt4);
    }

    /**
     * 向上转型可以看作是一种自动类型转换
     * 向下转型可以看成一种强制类型转换
     */
    @Test
    public void test2_4() {

        //向上转型可以看作是一种自动类型转换
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Number[] numbers = new Integer[]{1, 2, 3};

        //向下转型可以看成一种强制类型转换
        Object obj = new String("spring-boot");//编译时obj指向Object类型对象，运行时obj指向String类型对象
        String str = (String) obj;
        //String str2=obj; 这里说明obj的类型并没有转成String
        System.out.println(str);
    }



    /**
     * 其他类型====>String类型
     * 1 String.valueOf()
     * 2 追加空串"",此时+是连接符
     * 3 引用类型 toString()
     */
    @Test
    public void test3() {

        //int、double、boolean、char、float、long、Object类型数据转换成String,String.valueof
        System.out.println(String.valueOf(12.0f));
        System.out.println(String.valueOf('c'));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(new Object()));
        System.out.println(String.valueOf(new Object().toString()));

        //空串是一个已经实例化之后的对象，是有堆内存空间的，只不过内存空间中存储的值为空。
        System.out.println(1 + 2 + "");//第一个+是运算符，第二个+是连接符
        System.out.println("" + 1 + 2);//两个+都是连接符
    }



}


