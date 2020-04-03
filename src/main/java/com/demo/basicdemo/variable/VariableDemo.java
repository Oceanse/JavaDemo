package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.*;

public class VariableDemo {
    //标识符：字母，0-9 ，_或 $，数字不可以开头；java中所有命名的位置所用的都是标识符

    //变量就是申请内存来存储值。
    //变量包含三部分：数据类型 变量名 字面值(变量值)

    //当声明定义变量的时候，为该变量分配一块栈内存，变量类型决定内存空间大小，变量名就是这块内存空间的名字(同一个作用域内，变量名不能相同)
    //初始化赋值时时会让内存空间会存储这个值,基本类型变量存储字面值，引用类型变量存储对象的引用(地址); 另外变量指向的内存可以重新赋值，所以称之为变量

    //按类型：八种基本数据类型   三种引用数据类型(Object及其子类 接口 数组)
    //按作用域：局部变量 全局变量

    //变量类型转换：自动类型转换和强制类型转换  向上转型/向下转型 装箱/拆箱 其他类型<==>字符串

    //Java 中的变量需要先声明后使用

    //变量方法命名：驼峰命名法(第一个单词以小写字母开始；从第二个单词开始以后的每个单词的首字母都采用大写字母)


    /**
     * 变量的声明和初始化
     */
    @Test
    public void test(){
        int a;  //声明只是分配内存空间，但是内存空间没有存储值，并起名为a
        a=1;    //给变量名为a的内存空间赋值1
        System.out.println(a);//打印变量a存储的值


        double b=1.0;//声明double类型变量的同时赋值为1.0
        System.out.println(b);//打印变量d存储的值



        char c='a';//声明char类型变量的同时赋值为'a'
        c='b';     //将变量c存储的值重新赋值为'b'
        System.out.println(c);



        //方法体中的代码自上而下执行,  Java 中的变量需要先声明后使用
        //System.out.println(d);
        int d=0;


        //int d=1;   在同一个作用域内，变量名不能相同

    }




    /**
     * 变量分类
     */
    @Test
    public void test1() {


        //八种基本数据类型
        byte b = 123;   //byte占有内存1个字节（8bit）,取值范围-2^7~2^7-1也就是-128~127
        short s = 256;  //2字节
        int i = 456888; //4字节
        long l = 234L;  //8字节
        float f = 1.0F; //4字节
        double d = 2.0; //8字节
        char c = 'n';   //2字节(0~65535)

       //Java中还允许使用转义字符‘\’来将其后的字符转变为特殊字符型常量。 例如：'\n'是一个字符，表示换行符; '\t'是一个字符，表示制表符
        char c2 = '\n';
        char c3 = '\t';
        boolean bl = true;//1 bit

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.SIZE);
        System.out.println();

        /*Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少次方。
        比如3.14E3就是3.14 × 103 =3140，3.14E-3 就是 3.14 x 10-3 =0.00314。*/
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.SIZE);


        //三种引用数据类型接口类型 类类型 数组类型
        //引用类型变量存储对象的引用(地址)
        Object o;
        String myName = "ocean";

        Map map;
        List ls;
        Set set;

        String[] nameList;
    }






    /**
       自动类型转换
       容量小的类型自动转换为容量大的数据类型byte、short、char-->int-->long-->float-->double
       byte,short,char之间不会相互转换,他们三者在计算时首先转换为int类型，即使是同类型间计算也会先转换成int再计算
       有多种类型的数据混合运算时， 系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算
    */
    @Test
    public void test2() {

        byte b = 1;
        short s = 2;
        char c1 = 'a';

        //以下运算都是讲各变量首先转换成int,再进行计算，即使是同类型之间的运算
        int bb=b+b;
        int ss=s+s;
        int c11=c1+c1;
        int sum=b+s+c1;

        System.out.println("1==========================");
        System.out.println(sum);

        //若参与运算的数据类型不同，则先自动转换成同一类型，然后进行运算。
        System.out.println("2==========================");
        System.out.println(12 / 5);
        System.out.println(12.0f / 5);
        System.out.println(12.0/5L);//long自动转为double(5->5.0),然后进行运算

        //任何基本类型的值和字符串值进行连接运算时(+)，基本类型的值将自动转化为字符串类型。
        System.out.println("3==========================");
        System.out.println('a' + 1 + "Hello!");//char占2字节，int4字节，char-->int
        System.out.println("Hello!"+'a'+1);

        //向上转型可以看作是一种自动类型转换
        List<String> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        Number[] numbers=new Integer[]{1,2,3};

    }


    /**
    * 强制类型转换:强制显示的把一个数据类型转换为另外一种数据类型。
    * 语法：（强转类型）被强转对象
    * 被强转对象可以是对象或者该对象对应的引用变量；也可以是基本类型数据或者基本类型数据对应的变量
    * */
    @Test
    public void test3() {
        //强转可能损失精度
        int i = 22555;//   0101 1000 0001 1011  前面16位全是0
        byte bt = (byte) i;//强转会从最高位开始截，转成byte,截掉前面三个字节，只剩0001 1011，十进制为27
        byte bt2=(byte)22555;
        System.out.println("bt:" + bt);
        System.out.println("bt2:" + bt2);

        //浮点数到整数的转换是通过舍弃小数得到,可以强转常量值
        System.out.println((int)23.5);
        System.out.println((int)-23.5f);


        //向下转型可以看成一种强制类型转换
        Object obj = new String("spring-boot");
        String str = (String) obj;
        System.out.println(str);
    }


    /**
     * 其他类型====>String类型
     * 1 String.valueOf()
     * 2 追加空串""
     * 3 引用类型 toString()
     */
    @Test
    public void test4() {

        //int、double、boolean、char、float、long、Object类型数据转换成String,String.valueof
        System.out.println(String.valueOf(12.f));
        System.out.println(String.valueOf('c'));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(new Object()));
        System.out.println(String.valueOf(new Object().toString()));
        System.out.println(1+""+2);//空串是一个已经实例化之后的对象，是有堆内存空间的，只不过内存空间中存储的值为空。
    }


}


