package com.demo.thread;


/*new 接口名(){
实现接口方法
 }*/

public interface Niming{
    public void say();
}

 class Demo {
     public static void main(String[] args) {
         new Niming(){
             @Override
             public void say() {
                 System.out.println("good luck");
             }
         };
     }
}
/*初看上去，就好象在“不提供接口实现的情况下，直接new了一个接口实例”
* 还好这只是假象，观察bin目录下的class输出，会发现有一个类似Program1.class的文件，
* 如果反编译观察一下，发现原来是编译器自动生成一个类Program1.class的文件，如果反编译观察一下，
* 发现原来是编译器自动生成一个类Program1:
* package jimmy;
 2
 3 import contract.ISay;
 4 import java.io.PrintStream;
 5
 6 class Program$1
 7   implements ISay
 8 {
 9   public void sayHello()
10   {
11     System.out.println("Hello java!");
12   }
13 }*/