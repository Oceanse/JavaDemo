package com.demo.lambda;


/**
 * lambda可以用来创建函数型接口对象，这个对象可以赋值给某个引用变量 或者 作为实参传给方法 或者 作为方法的返回值
 */
//有参有返回
interface ICar4{
    int add(int a,int b);
}

class TestCar2{
    // 当代码块中只有一条语句时候，即使该表达式需要返回值，也可以省略return关键字(然也可以省略花括号)，这行语句的返回值将作为代码块的返回值当
    ICar4 car=(a,b)->a+b;//等价于 ICar4 car2=(a,b)->{return a+b;};
}
