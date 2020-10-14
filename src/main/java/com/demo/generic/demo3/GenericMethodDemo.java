package com.demo.generic.demo3;

import org.testng.annotations.Test;

import java.util.*;


/**
 *  声明泛型方法: 修饰符 <代表泛型的变量> 返回值类型 方法名(参数){ }  <E>表明该方法将使用泛型类型E，此时才可以在方法中使用泛型类型E。
 * 泛型方法可以出现在非泛型类中(一定成都上和泛型类无关)
 * 所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔）,该类型参数声明部分在方法返回类型之前
 * 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
 * 泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）
 */
public class GenericMethodDemo {

    // 你可以声明一个泛型方法，该方法在调用时可以接收不同类型的参数。根据传递给泛型方法的参数类型，编译器适当地处理每一个方法调用
    // 在调用泛型方法的时候指明泛型的具体类型
    // 泛型方法可以出现在非泛型类中
    public static <E> void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.print(element+" ");
        }
    }

    @Test
    public void test(){
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        this.printArray(intArray); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        this.printArray(doubleArray); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        this.printArray(charArray); // 传递一个字符型数组
    }



    //泛型方法
    public static <E> E returnElement( E e )
    {
        return e;
    }

    @Test
    public void test2(){
        //在调用泛型方法的时候指明泛型的具体类型
        Integer integer = returnElement(1);
        Boolean aBoolean = returnElement(true);
        Character character = returnElement('c');
    }


    //数组复制到list
    public <E> List<E> fromArrayToList(E[] e,List<E> list){
        for(E e1 : e){
            list.add(e1);
        }
        return list;
    }


    @Test
    public void test3(){
        //在调用泛型方法的时候指明泛型的具体类型
        List<Integer> l=new ArrayList<>();
        List<Integer> integers = fromArrayToList(new Integer[]{1, 2, 3}, new ArrayList<Integer>());
        System.out.println(integers);
    }


    //静态泛型方法
    public static <T> T getT(T t){
        return t;
    }

    @Test
    public void test4(){
        //调用静态方法
        Boolean t = getT(true);
        System.out.println(t);
    }
}