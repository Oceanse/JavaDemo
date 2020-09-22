package com.demo.lambda;
/**
 * lambda可以用来创建函数型接口对象，这个对象可以赋值给某个引用变量 或者 作为实参传给方法 或者 作为方法的返回值
 */
//无参有返回
public interface ICar3 {
    int count();
}


class TestCar{
    //被重写的接口方法需要返回值，所以这里等价于ICar3 car=()->{return 10;};
    // 当代码块中只有一条语句时候，即使该表达式需要返回值，也可以省略return关键字(然也可以省略花括号)，这行语句的返回值将作为代码块的返回值当
    ICar3 car=()-> 10;

}


