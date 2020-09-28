package com.demo.lambda;
/**
 * lambda可以用来创建函数型接口对象，这个对象可以赋值给某个引用变量 或者 作为实参传给方法 或者 作为方法的返回值
 */
//无参有返回
public interface ICar3 {
    int count();//被重写的接口方法需要返回值
}


class TestCar{
    //如果大括号内有且仅有一个语句且需要返回值，那么可以同时省略大括号、return关键字及语句分号
    ICar3 car=()-> 10;

    //或者完整写法
    ICar3 car2=()-> {return 10;};

}


