package com.demo.basicdemo.operator;

import org.testng.annotations.Test;


/**
 * 我们计算一个表达式的时，java会优先考虑操作符的优先级, 运算过程中操作符的优先级是一样的情况下，那么就需要考虑操作符的结合性了
 * 运算符的结合性是指相同优先级的运算符在同一个表达式中，且没有括号的时候，运算符和操作数的结合方式，通常有从左到右结合和从右到左结合两种方式
 * 结合性：至少要有两个运算符，且优先级相同
 *
 * eg1: 表达式a+b+c： +是从左向右结合（左结合）的，那么该表达式被解析为 (a+b)+c
 * eg2: 表达式a=b=c： =是从右向左结合（右结合）的，那么该表达式被解析为a=(b=c)
 * eg3: 表达式a>0 ? "positive" : a<0 ? "negative" : "zero"   三目运算是从右向左结合（右结合）的，那么该表达式被解析为a>0 ? "positive" : (a<0 ? "negative" : "zero")
 *
 * 赋值表达式遵循右结合：先执行右边的表达式，再将结果赋值给左边变量
 * 赋值表达式同其他表达式一样具有自己的值，赋值表达式的值就是最左边变量存储的值
 *
 * 变量=表达式/数值
 * 赋值运算符分为：基本赋值运算符=和扩展赋值运算符+= -+ *= /= %=
 *
 * */

public class AssignmentOperatorDemo {

    @Test
    public void test(){
        int i;
        int j;
        int k;
        System.out.println(i=1);//赋值表达式的值就是左边变量存储的值

        //赋值表达式是右结合
        System.out.println(k=j=i);//等价于  System.out.println(k=(j=i));
    }


    @Test
    public void test2(){
        byte b=100;
        //b=b+1;  不能将int赋值给byte

        b+=1;//相当于b=b+(byte)1
    }



    @Test
    public void test3() {

        byte b = 0;
        b += 22555;
        //b += 22555隐含了一个强制类型转换,将22555转换为byte，然后相加赋值给byte类型变量s,此过程不改变数据类型(+=左边的变量)实现运算
        System.out.println("b="+b);
        //相当于
        byte b2=(byte)22555+0;
        System.out.println("b2="+b2);

        int a=2;
        double d=2.1;
        System.out.println(a+=0.1);  //隐含了一个强制类型转换,a和0.1类型不一致，所以0.1->0,a类型不变
        System.out.println(d+=0.1); //d和0.1类型一致，所以不需要强转
    }

    @Test
    public void test4() {
        int i=10;
        int j=i;//这里为j分配一块栈内存,并把变量i保存的字面值10传递给了变量j;

        Object o1=new Object();//这里o1保存的是堆内存地址
        Object o2=o1;//这里重新分配一块栈内存,并把变量o1保存的地址值传递给了变量o2
    }

}
