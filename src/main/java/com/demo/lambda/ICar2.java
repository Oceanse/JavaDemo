package com.demo.lambda;


/**
 * lambda可以用来创建函数型接口对象，这个对象可以赋值给某个引用变量 或者 作为实参传给方法 或者 作为方法的返回值
 */
//函数型接口：有参无返回
public interface ICar2 {
    void show(String brand);
}

class ICar2Iml implements ICar2 {
    @Override
    public void show(String brand) {
        System.out.println("The brand of car is： "+brand);
    }
}

class CarTest2{

    /**
     *  通过实现类创建实现类对象
     */
    public void test(){
        ICar2 car=new ICar2Iml();
        car.show("Benz");
    }

    /**
     * 创建匿名内部类对象，不需要显式定义实现类
     */
    public void test2(){
        ICar2 car=new ICar2(){
            @Override
            public void show(String brand) {
                System.out.println("The brand of car is： "+brand);
            }
        };
        car.show("Benz");
    }

    /**
     * lambda表达式创建接口对象，但是只适合创建函数型接口对象
     * 函数型接口：有参无返回
     */
    public static void test3(){
        ICar2 car=(brand->System.out.println("The brand of car is： "+brand));
        car.show("Benz");
    }


    public static void test4(ICar2 car, String brand){
        car.show(brand);
    }

    public static void main(String[] args) {
        //test3();
        test4((brand ->System.out.println("The brand of car is： "+brand)),"BYD");
    }

}