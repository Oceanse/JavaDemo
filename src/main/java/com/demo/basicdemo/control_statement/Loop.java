package com.demo.basicdemo.control_statement;

import org.testng.annotations.Test;

public class Loop {

   /*
   for(1初值表达式；2条件表达式；3更新表达式){
        4循环体
   }

   执行顺序：1-->2-->4--3>--2>-->4-->3--2------2不满足退出

   初始表达式最先被执行，且该表达式只被执行一次

   三个表达式都不是必须的，但是两个分号是必须的

   for循环中的变量作用域只是for循环体，循环结束后for内的变量就会释放内存空间

   for循环体 可以嵌套if switch for while.....
   */





    @Test
    public void test(){
        for(int i=1;i<10;i++){//把内层的for循环十遍
            for(int j=1;j<=i;j++){//内层的for看做普通代码块
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }


    //死循环
    @Test
    public void test2(){
       for(;;){
           System.out.println(Math.random());
       }
        //System.out.println("这里永远无法执行"); 这里放开会编译不通过，提示unreachable
    }


    @Test
    public void test3(){
        for(int i=100;i>0;i--){
            System.out.println(i);
        }
        //System.out.println(i); 这里已经超出i的作用域，编译错误
    }


    @Test
    public void test4(){
        int i=1;
        for(;i<10;i++){//i=10时跳出for
            System.out.println(i);
        }
        System.out.println("i="+i);
    }

    @Test
    public void test5(){
        int i;
        for(i=1;i<10;i++){//i=10时跳出for
            System.out.println(i);
        }
        System.out.println("i="+i);
    }

    @Test
    public void test6(){
        for(int i=1;i<10;i+=2){
            System.out.println(i);
        }
    }


    @Test
    public void test7(){
        for(int i=100;i>50;i-=10){
            System.out.println(i);
        }
    }


    @Test
    public void test8(){
        for(int i=1;i<10;){//缺少更新表达式会导致死循环
            System.out.println(i);
        }
    }


    @Test
    public void test9(){
        for(int i=1;i<10;){
            System.out.println(i);
            i++;//更新表达式可以放在这
        }
    }


    @Test
    public void test10(){

        int sum=0;//这里可以把sum理解成个框子
        for(int i=1;i<10;i+=2){
           sum+=i;
        }
        System.out.println(sum);
    }



    /*
    * while(条件表达式){
    *    循环体
    *  }
    *
    *  先判断条件表达式-->循环体-->条件表达式---.....
    *
    *
    *  初始化条件
    *  while(条件表达式){
     *    循环体(包含更新条件)
     *  }
    *
    * 循环体可能一次都不会执行
    * */




    //死循环
    @Test
    public void test11(){

       while (true){
           System.out.println(Math.random());
       }

        //System.out.println("这里永远无法执行"); 这里放开会编译不通过，提示unreachable
    }



    @Test
    public void test12(){

        int i=10;
        while (i>0){
            System.out.println(i--);//这里可以理解成System.out.println(int m=i--);
        }
        System.out.println("end i="+i);
    }


    @Test
    public void test13(){

        int count=0;
        int j=1;
        while(j<=10){
            if (j%2==0) {
                System.out.print(j+"\t");
                count++;
            }
            j++;
        }
        System.out.println();
        System.out.println("count:"+count);
    }




    /*
    * do {
        循环体;
     } while(表达式) ;
    *
    *
    * do-while循环结构会先执行循环体，然后再判断表达式的值
    *
    * do-while循环的循环体至少执行一次。
    * */





    @Test
    public void test14(){

        int i=10;
        while (i>100){
            System.out.println(i--);
        }



        do{
            System.out.println(i--);
        }
        while(i>100);


    }



    /*
    *使用break的场景有两种：一、switch语句中。二、循环语句
    *
    * break可以作为单独的java 语句
    *
    * 用在循环中可以直接强行退出当前的循环
    * */



    @Test
    public void test15(){
        for (int i = 0; i <10 ; i++) {
            if (i==5) {
                break;//i==5时跳出当前循坏
            }
            System.out.println(i);
        }
    }




    @Test
    public void test16(){

        for (int i = 0; i <3; i++) {
            for (int j = 0; j <10 ; j++) {
                if (j==5) {
                    break;//i==5时跳出当前循坏,当前循环是内层循环
                }
                System.out.println("i="+i+" "+"j="+j);
            }
        }

    }



    //给for起名
    @Test
    public void test17(){

        outter:for (int i = 0; i <3; i++) {
            inner:for (int j = 0; j <10 ; j++) {
                if (j==5) {
                    //break inner;  i==5时跳出内层循环inner,同test16
                    break outter;//i==5时跳出外层循环outter
                }
                System.out.println("i="+i+" "+"j="+j);
            }
        }

    }



    /*
    * continue是结束本次循环，进行下一次循环
    * continue可以作为单独的java 语句
    * */

    @Test
    public void test18(){
        for (int i = 0; i <10 ; i++) {
            if (i==5) {
                continue;//i==5时跳过本次循坏
            }
            System.out.println(i);
        }
    }




/*



    @Test
    public void test6(){
        Map<String,Integer> map=new HashMap<>();
        map.put("ocean",28);
        map.put("dahuang",24);

        Set set=map.keySet();
        for (Object o : set) {
            System.out.println(o+"--->"+map.get(o));
        }
    }
*/




}
