package com.demo.lambda;

//lambda构造函数型接口的实例对象作为函数返回值

//无返回值带参数
 interface Actions{
    void walk(String foot);
}

public class Test3 {


     //传统写法
    public Actions getAction1(){
        return new Actions() {
            @Override
            public void walk(String foot) {
                System.out.println(foot);
            }
        };
    }


    //lambda写法
    public Actions getAction2(){
        return foot ->
                System.out.println(foot);// 等价于{System.out.println(foot);};
    }

}


//有返回值带参数
interface ElectricityGenerate{
     String eleGenerate(String str);
}

class WindGene {


     //传统方式
     public ElectricityGenerate getWay(){
         return new ElectricityGenerate(){
             @Override
             public String eleGenerate(String str) {
                 return str;
             }
         };
     }



    public ElectricityGenerate getWay2(){
        return way-> {return way;};  //不能写成  return way-> return way;
    }


}