package com.demo.basicdemo.operator;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;


/**
 *   算术运算符: + - * / % ++ --
 *   ++ --是单目运算符，++或者--结束后，变量的值会自增或者自减1
 * */
public class Operator {


    /**
     * + - * /
     */
    @Test
    public void test1(){

        int i = 1;
        int i2=2;
        System.out.println(i+i2);
        System.out.println(i-i2);
        System.out.println(i*i2);
        System.out.println(i/i2);//结果和参与运算变量类型一致
        System.out.println();

        double d=1.0;
        System.out.println(d/2);//int类型2先自动转换为double类型

        //System.out.println(1/0);//java.lang.ArithmeticException: / by zero
        System.out.println(1/0.0);
        System.out.println(-1.0/0);//被除数或者除数有一个是小数，那么除数可以为0，结果为无穷大

        //-除了作为减号外，还可以是求负运算符
        int po=1;
        int na=-po;
        System.out.println(na);

    }


    /**
     * 取模运算 *
     */
    @Test
    public void test1_2(){
        //取模运算符号看左边
        System.out.println(5%2);
        System.out.println(5%-2);
        System.out.println(-5%2);
        System.out.println(-5%-2);

        int i=2;
        if(i%2==0){
            System.out.println(i+"是偶数");
        }
    }

/**
 *  ++ --都是单目运算符，只能有一个操作数
 *  ++a,--a： 先进行自增或者自减运算，再进行赋值运算；
 *  a++,a--: 先进行赋值运算，再进行自增或者自减运算

 * 自增自减运算只能操作变量，不能操作常量或者表达式
*/
    @Test
    public void test1_3(){

        int i = 1;
        int i2 = 2*i++;
        System.out.println("i=" + i);
        System.out.println("i2=" + i2);

        int i3 = 3;
        int i4 = 2*++i3;
        System.out.println("i3=" + i3);
        System.out.println("i4=" + i4);

        //int i5=1++;不能对常量进行自增自减

        //赋值表达式的结果是最左边变量的值，但是不能对表达式进行自增自减
        System.out.println(i=100);
        //System.out.println((i=100)++);
    }


    /**
     * java.lang.Math 类提供的工具方法可以完成求幂、开方、绝对值等运算
     */
    @Test
    public void test1_4() {
        System.out.println(Math.abs(-1.2));//|-1.2|
        System.out.println(Math.pow(2, 3));//2^3
        System.out.println(Math.sqrt(4));
        System.out.println(Math.random());//0~1随机数
    }




    /*
    * 关系运算符用于用来比较判断两个变量或常量的大小,当运算符对应的关系成立时，运算结果是 true，否则是 false
    * = 和 != 可以应用于基本数据类型和引用类型。
    * 当用于引用类型比较时，比较的是两个引用是否指向同一个对象;
    * 当用于基本数据类型比较，比较的是他们的值
    *
    * */
    @Test
    public void test3_1(){
        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );//大于或者等于
        System.out.println("b <= a = " + (b <= a) );//小于或者等于

        //常量比较大小
        System.out.println("10>=10: "+(10>=10));
        System.out.println("10==10: "+(10.0==10));//基本数据类型比较，比较的是他们的值

        //引用变量比较
        Integer i1=new Integer(10);
        Integer i2=new Integer(20);
        System.out.println("i1=i2: "+(i1==i2));//i1和i2存储的是对象的堆内存地址，这里是不相等的

        //布尔变量比较
        System.out.println("true==false: "+(true==false));

        //int和char比较
        System.out.println("'a'==97: "+('a'==97));
    }


    @Test
    public void test3_2() {
        //注意==和=
        boolean b = false;
        if (b = true){
            System.out.println("zhen.....");
        }
        else{
            System.out.println("jia...");
        }
    }



/**
逻辑运算符用于连接两个结果布尔类型的变量/常量/表达式，用于执行多个判断，
判断的结果是 true 或 false。
*/
    @Test
    public void test4(){
        // &&和||短路
        // 所谓短路，就是当参与运算的一个操作数已经足以推断出这个表达式的值的时候，另外一个操作数（有可能是表达式）就不会 执行

        int i=2;
        boolean b=true;
        if((b=false) & (i++)>0){//i++会被执行
        }
        System.out.println("b: "+b);
        System.out.println("i: "+i);


        int i2=2;
        boolean b2=true;
        if ((b2=false) && (i2++>0)) {//i2++不会被执行
        }
        System.out.println("b2: "+b2);
        System.out.println("i2: "+i2);


        int i3=2;
        boolean b3=true;
        if((b3) | (i3--)>0){
        }
        System.out.println("b3: "+b3);
        System.out.println("i3: "+i3);


        int i4=2;
        boolean b4=true;
        if((b4) || (i4--)>0){
        }
        System.out.println("b4: "+b4);
        System.out.println("i4: "+i4);
    }


    /**
     *  //!单目运算符，只需要一个操作数；操作数是结果为布尔类型的变量/常量/表达式
     *  操作数为true,则返回false;操作数为false,则返回true
     */
    @Test
    public void test4_2(){
        System.out.println("!true: "+!true);
        System.out.println("!(2>1): "+!(2>1));
    }


    /**
     * 异或：两个操作数不同时返回true,相同时返回false
     */
    @Test
    public void test4_3(){
        System.out.println(true ^ true);
        System.out.println(('c'>'a')^(1>2));

    }






    @Test
    public void test5() {

        byte s = 0;
        s += 22555;
        System.out.println("s="+s);  //s += 22555隐含了一个强制类型转换,将22555转换为byte，然后相加赋值给byte类型变量s,此过程不改变数据类型实现运算
        //相当于
        byte b=(byte)22555+0;
        System.out.println("b="+b);

        int a=2;
        double d=2;
        System.out.println(a+=0.1);  //隐含了一个强制类型转换,a和0.1类型不一致，所以0.1->0,a类型不变
        System.out.println(d+=0.1); //d和0.1类型一致，所以不需要强转
    }






    /*条件运算符（？：）也称为三元运算符

      语法：表达式（返回结果为boolean）？ 表达式 1 ： 表达式 2

      返回结果为 true 则执行 表达式 1 ，为 false 则执行 表达式 2*/
    @Test
    public void test7(){
        int i=1;
        int j=2;
        System.out.println((i > j) ? i : j);
    }



    /*instanceof 用来测试一个对象是否为一个类的实例,用法为：
    * boolean result = obj instanceof Class
    * 其中 obj 为一个对象，Class 表示一个类或者一个接口，
    * 当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
    *
    * */

    @Test
    public void test8_1(){

        int i=1;
        //System.out.println(i instanceof Integer); instanceof 运算符只能用作对象的判断，obj必须是引用数据类型

        System.out.println(null instanceof Object);// java对 instanceof 运算符的规定就是：如果 obj 为 null，那么将返回 false

        String name = "James";
        System.out.println(name instanceof String);// 由于 name 是 String 类型，所以返回true

        Collection c=new ArrayList();
        System.out.println(c instanceof ArrayList);
    }


    @Test
    public void test9(){
        /*
        * 赋值运算符分为：基本赋值运算符=和扩展赋值运算符+= -+ *= /= %=
        * 赋值运算符优先级：先执行右边的表达式，再将结果赋值给左边变量
        * */

        byte b=100;
        //b=b+1;  不能将int赋值给byte

        b+=1;//相当于b=b+(byte)1

    }


}
