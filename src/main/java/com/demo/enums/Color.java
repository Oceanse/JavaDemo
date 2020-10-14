package com.demo.enums;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * https://www.toutiao.com/a6764240507808776715/
 *
 * 枚举类型是Java 5中新增特性的一部分，它是一种特殊的数据类型，因为它既是一种类(class)类型却又比类类型多了些特殊的约束，
 * 但是这些约束的存在也造就了枚举类型的简洁性、安全性以及便捷性
 *
 * 创建enum时，编译器会为你生成一个相关的类，这个类继承自 java.lang.Enum。
 *
 * 定义：
 * [public] enum 枚举类名 [implements 接口名]
 * 使用的关键字是enum，与class关键字类似，只不过前者是定义枚举类型，后者是定义类类型。
 */


public enum Color {
    //枚举类的类体部分是常量的定义，值一般是大写的字母，多个值之间以逗号分隔，最后以分号结束；
    //枚举表示的类型其取值是必须有限的，也就是说每个值都是可以枚举出来的
    //常量定义时候会自动调用枚举类的构造方法(如果没有定义，默认提供一个空参构造方法，这里就是空参构造方法)，所以每个常量相当于枚举类的一个实例对象
    RED,
    GREEN,
    BLUE;

    public static void test(){
        //枚举类名.常量名
        Color red = Color.RED;
        Color green = Color.GREEN;
        Color blue = Color.BLUE;
        System.out.println(red);
        System.out.println(green);
        System.out.println(blue);
        System.out.println();

    }


    /**
     * values()方法和valueOf(String name)方法是编译器生成的static方法
     */
    public static void test2(){
        //values()方法的作用就是获取枚举类中的所有变量，并作为数组返回
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));

        //据String名称获取枚举变量
        Color green = Color.valueOf("GREEN");
        System.out.println(green);

        //No enum constant com.demo.enums.Color.BLACK
        //Color black = Color.valueOf("BLACK");
        //System.out.println(black);
        System.out.println();
    }

    public static void test3(){

        //据String名称获取枚举变量
        Color green = Color.valueOf("GREEN");

        String name = green.name();//Returns the name of this enum constant
        System.out.println(name);

        String name2 = green.toString();//Returns the name of this enum constant
        System.out.println(name2);
        System.out.println();


    }

    public static void test3x(){
        Object o = new Object();//不能传入switch
        Color color = Color.RED;

        switch (color) {//switch支持枚举类
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case GREEN:
                System.out.println("green");
                break;
            default:
                break;
        }

    }
    public static void main(String[] args) {
        test();
        test2();
        test3();


    }
}



  enum WeekDay {
      //如果枚举类定义了成员变量，则需要提供一个带参构造方法为该成员变量赋值，此时需要在常量名后使用“( )”括起参数
      //常量的定义需要放在前头，之后才能是成员变量、构造方法、方法等的定义
      MONDAY("星期一", 1),
      TUESDAY("星期二", 2),
      WEDNESDAY("星期三", 3),
      THURSDAY("星期四", 4),
      FRIDAY("星期五", 5),
      SATURDAY("星期六", 6),
      SUNDAY("星期日", 7);//记住要用分号结束


      //成员变量：枚举类成员变量的定义与类成员变量的定义相同。由于枚举类这一结构的初衷是设置常量，建议把枚举类成员变量都定义为私有变量，且只提供对应的getter方法，不提供对应的setter方法。
      private String desc;//文字描述
      private Integer code; //对应的代码

      /**
       * 构造方法：枚举类不支持通过程序来创建新实例，其构造方法的访问限制符只能为private，或者不加访问限制符
       * @param desc
       */
      private WeekDay(String desc, Integer code) {
          this.desc = desc;
          this.code = code;
      }

      /**
       * 定义方法,返回描述,跟常规类的定义没区别
       *
       * @return
       */
      public String getDesc() {
          return desc;
      }

      /**
       * 定义方法,返回代码,跟常规类的定义没区别
       *
       * @return
       */
      public int getCode() {
          return code;
      }

      public static void main(String[] args) {

          WeekDay monday = WeekDay.MONDAY;

          //获取常量名
          String s = monday.toString();//Returns the name of this enum constant
          System.out.println(s);
          String name = monday.name();//Returns the name of this enum constant
          System.out.println(name);
          System.out.println();

          //理解为获取常量对象的属性
          System.out.println(monday.getDesc());
          System.out.println(monday.getCode());
          System.out.println();

          WeekDay[] days = WeekDay.values();
          for (WeekDay day : days) {
              System.out.println("name:" + day.name() +
                      ",desc:" + day.getDesc());
          }
      }
  }