package com.demo.lambda;

//有参无返回
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

    public void test(){
        ICar2 car=new ICar2Iml();
        car.show("Benz");
    }

    public void test2(){
        ICar2 car=new ICar2(){
            @Override
            public void show(String brand) {
                System.out.println("The brand of car is： "+brand);
            }
        };
        car.show("Benz");
    }

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