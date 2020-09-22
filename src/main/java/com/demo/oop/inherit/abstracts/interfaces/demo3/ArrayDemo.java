package com.demo.oop.inherit.abstracts.interfaces.demo3;

/**
 * 面向接口设计、实现，用接口和实现类封装某种行为
 * 生成工程生产实现类
 * 面向接口调用
 */
public class ArrayDemo {

public static void processArray(int[] numbers, Command command){
    for (int number : numbers) {
        command.process(number);
    }
}

    public static void main(String[] args) {
        Command doubles =CommandFactory.produceDoubleCommand();
        Command square =CommandFactory.produceSquareCommand();
        processArray(new int[]{1,2,3},doubles);
        processArray(new int[]{1,2,3},square);
    }

}


//处理行为接口规范
interface Command{
    void process(int element);
}


//实现1：翻倍
class Doubles implements Command{
    @Override
    public void process(int element) {
        System.out.println(2*element);
    }
}

//实现2：平方
class Square implements Command{
    @Override
    public void process(int element) {
        System.out.println(element*element);
    }
}

//实现类生成工厂
class CommandFactory{
    public static Command produceDoubleCommand(){
        return new Doubles();
    }

    public static Command produceSquareCommand(){
        return new Square();
    }
}