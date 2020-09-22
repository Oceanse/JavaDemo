package com.demo.lambda;

/**
 * lambda可以用来创建函数型接口对象，这个对象可以赋值给某个引用变量 或者 作为实参传给方法 或者 作为方法的返回值
 */
//函数型接口：无参无返回
public interface ICar {
    void drive();
}

class ICarImpl implements ICar {

    @Override
    public void drive() {
        System.out.println("BMW");
    }
}


class CarTest{

    /**
     *  通过实现类创建实现类对象
     */
    public void test(){
        ICar car=new ICarImpl();
        car.drive();
    }


    /**
     * 创建匿名内部类对象，不需要显式定义实现类
     * 函数型接口：无参无返回
     */
    public void test2(){
        ICar car=new ICarImpl(){
            @Override
            public void drive() {
                System.out.println("BMW");
            }
        };

        car.drive();
    }


    /**
     * lambda表达式创建接口对象，但是只适合创建函数型接口对象
     *
     */
    public void test3(){
        ICar car=()->{
            System.out.println("BMW");
        };
        car.drive();
    }




    public static void driveCar(ICar car){
        car.drive();
    }

    public static void main(String[] args) {
        //driveCar(接受一个接口实现类对象，可以用lambda构造SAM接口对象);
        driveCar(()-> System.out.println("BMW"));

    }

}

