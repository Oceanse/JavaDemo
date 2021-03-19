package com.demo.enums.demo1;


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




//关键字是enum，与class关键字类似，只不过前者是定义枚举类型，后者是定义类类型
public enum Direction {
    EAST, WEST, NORTH, SOUTH;

    public static void main(String[] args) {
        System.out.println(Direction.WEST);//Direction.WEST本质是当前类Direction类的一个对象的引用，
    }
}


/*
枚举是一个特殊的类，每一个枚举项本质上都是枚举类自身的实例。
一个枚举在经过编译器编译过后，变成了一个类，它继承了java.lang.Enum
final class Direction extends Enum{
    public final static Direction EAST = new Direction();
    public final static Direction WEST = new Direction();
    public final static Direction NORTH = new Direction();
    public final static Direction SOUTH = new Direction();
}

*/
