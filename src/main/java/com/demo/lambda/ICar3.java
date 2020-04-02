package com.demo.lambda;

//无参有返回
public interface ICar3 {
    int count();
}


class TestCar{
    ICar3 car=()-> 10;

}


//有参有返回
interface ICar4{
    int count2(int n);
}

class TestCar2{
    ICar4 car=(n)->{return n;};
}