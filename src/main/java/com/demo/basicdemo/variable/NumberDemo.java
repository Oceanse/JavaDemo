package com.demo.basicdemo.variable;

import java.util.ArrayList;

public class NumberDemo {

    public static void printChar(char c){
        System.out.println(c);
    }
    public static void printCharacter(Character c){
        System.out.println(c);
    }


    public static void main(String[] args) {
          /*基本类型的包装类
        int --> Integer
        byte --> Byte
        short --> Short
        long --> Long
        char --> Character
        float --> Float
        double --> double
        boolean --> Boolean*/

          //基本类型和包装类之间的转换
        Integer i = new Integer(100);//手动装箱
        Character character=new Character('p');//手动装箱
        int j=i.intValue();  //手动拆箱
        char ch= character.charValue();  //手动拆箱
        printChar(character);//Java编译器自动拆箱
        printCharacter(ch);//Java编译器自动装箱
        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);//Java编译器自动装箱




        //JDK5.0的一个新特性是自动装箱和自动拆箱
        Double dd=new Double(1.0);
        double m=dd;//自动拆箱  包装类对象自动转换成基本数据类型 本质上是，编译器编译时自动添加double m=dd.doubleValue()
        Double n=1.1; //自动装箱  基本类型就自动地封装到与它相似类型的包装中 本质上是，编译器编译时自动添加：Double n =Double.valueOf(n);






        //String--->基本类型
        //当String类型数据 要转换成int、double、float、long等数据类型时，其数据必须由数字构成，
        String st = "789";
        int ii = Integer.valueOf(st);
        double d = Double.valueOf(st);
        long l = Long.valueOf(st);
        float f = Float.valueOf(st);
        //当String类型数据值为true/false时,可转换为boolean
        String s2 = "true";
        boolean bb = Boolean.valueOf(s2);


           /*其它类转字符串
           1 使用包装类的 toString() 方法
           2使用String类的 valueOf() 方法
           3用一个空字符串加上基本类型*/

           int c=1;
           String strc=new Integer(c).toString();
           String strc2=String.valueOf(c); //public static String valueOf(Object obj)
           String strc3=c+"";
        //String转成相应的数组
        char[] chars1 = st.toCharArray();
        byte[] bytes = st.getBytes();
    }

}
