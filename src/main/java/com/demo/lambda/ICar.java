package com.demo.lambda;

//无参无返回
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

    public void test(){
        ICar car=new ICarImpl();
        car.drive();
    }


    public void test2(){
        ICar car=new ICarImpl(){
            @Override
            public void drive() {
                System.out.println("BMW");
            }
        };
        car.drive();
    }



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

