package com.demo.basicdemo.operator;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Operator {

/*
*   算术运算符: + - * / % ++ --
*   ++ --是单目运算符，++或者--结束后，变量的值会自增或者自减1
* */
    @Test
    public void test(){
        /*
          ++a,--a： 先进行自增或者自减运算，再进行赋值运算；
          a++,a--: 先进行赋值运算，再进行自增或者自减运算
        */

        int i = 1;
        int i2 = 2*i++;
        System.out.println("i=" + i);
        System.out.println("i2=" + i2);

        int i3 = 3;
        int i4 = 2*++i3;
        System.out.println("i3=" + i3);
        System.out.println("i4=" + i4);
    }

    @Test
    public void test2(){
        System.out.println(5/2);//结果和参与运算变量类型一致
        System.out.println(5/2.0);//先自动转换

        //取模运算符号看左边
        System.out.println(5%2);
        System.out.println(5%-2);
        System.out.println(-5%2);
        System.out.println(-5%-2);

    }



    /*
    * 关系运算符用于用来比较判断两个变量或常量的大小,当运算符对应的关系成立时，运算结果是 true，否则是 false
    * = 和 != 可以应用于基本数据类型和引用类型。
    * 当用于引用类型比较时，比较的是两个引用是否指向同一个对象;当用于基本数据类型比较，比较的是他们的值
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
        System.out.println("b >= a = " + (b >= a) );
        System.out.println("b <= a = " + (b <= a) );

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



/*
逻辑运算符用于连接两个条件表达式或布尔类型的变量，用于执行多个判断，
判断的结果是 true 或 false。
*/

    @Test
    public void test4(){
        // &&和||短路
        // 所谓短路，就是当参与运算的一个操作数已经足以推断出这个表达式的值的时候，另外一个操作数（有可能是表达式）就不会 执行
        int i=2;
        int i2=2;
        int i3=2;
        int i4=2;
        boolean b=true;
        boolean b2=true;
        boolean b3=true;
        boolean b4=true;


        if((b=false) & (i++)>0){//i++会被执行
        }
        System.out.println(b);
        System.out.println(i);

        if ((b2=false) && (i2++>0)) {//i2++不会被执行
        }
        System.out.println(b);
        System.out.println(i2);

        if((b3) | (i3--)>0){
        }
        System.out.println(b3);
        System.out.println(i3);

        if((b4) || (i4--)>0){
        }
        System.out.println(b4);
        System.out.println(i4);


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
