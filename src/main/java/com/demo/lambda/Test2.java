package com.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {
    /*使用() -> {} 替代匿名类
     new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println("no use com.demo.lambda");
              }
          }).start;

Thread t2 = new Thread(() -> System.out.println("use com.demo.lambda"));*/
    public static void main(String[] args) {
        for (int i = 0; i <100; i++) {
            new Thread(()-> System.out.println("com.demo.lambda....")).start();
            new Thread(()-> System.out.println("SAM....")).start();
        }
    }

}


class AcceptMethod {

   public static void  printValur(String str){
       System.out.println("print value : "+str);
   }

   public static void main(String[] args) {
       List<String> al = Arrays.asList("a","b","c","d");
       for (String a: al) {
           AcceptMethod.printValur(a);
       }
       //下面的for each循环和上面的循环是等价的
       al.forEach(x->{
           AcceptMethod.printValur(x);
       });


       /*al.forEach(new Consumer<String>() {
                      @Override
                      public void accept(String s) {
                          System.out.println(s);
                      }
                  }

       );*/







   }
}