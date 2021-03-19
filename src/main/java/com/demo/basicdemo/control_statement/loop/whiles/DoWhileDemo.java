package com.demo.basicdemo.control_statement.loop.whiles;

import org.testng.annotations.Test;

 /**
  初始条件
  do {
      循环体;
   } while(条件表达式) ;

 do-while循环结构会先执行循环体，然后再判断表达式的值
 do-while循环的循环体至少执行一次。
 * */
public class DoWhileDemo {


    @Test
    public void test() {

        int i = 10;
        while (i > 100) {
            System.out.println(i--);
        }


        do {
            System.out.println(i--);
        }
        while (i > 100);


    }

}
