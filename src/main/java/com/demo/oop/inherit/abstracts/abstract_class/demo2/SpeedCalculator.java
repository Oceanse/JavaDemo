package com.demo.oop.inherit.abstracts.abstract_class.demo2;

import static java.lang.Math.PI;


/**
 * 线速度=转速x周长
 * 父类的求线速度的普通方法依赖求周长的抽象方法，这个抽象方法推迟到子类去实现，这也是一种典型的模板模式
 * 父类的构造方法主要是供子类去调用实例化子类，特别是对于一些父类中的private属性
 */
public abstract class SpeedCalculator {

    private int turnRate;


    /**
     * 父类的构造方法主要是供子类去调用实例化子类，特别是对于一些父类中的private属性
     * @param turnRate
     */
    public SpeedCalculator(int turnRate) {
        this.turnRate = turnRate;
    }

    /**
     * 抽象方法
     * @return
     */
    public abstract double perimeter();

    /**
     * 父类的求线速度的普通方法依赖求周长的抽象方法
     * @return
     */
    public double speedCal(){
        return turnRate*perimeter();//线速度=转速x周长
    }
}


/**
 * 子类继承抽象父类以后，头脑中首先要有子类完全拥有了父类的所有属性和方法，只是对于私有的属性或者方法不能直接进行访问或者修改
 * 这里就是子类拥有了 转速turnRate 属性，但只能通过父类构造器初始化；
 * 子类还拥有计算周长的perimeter方法，但是需要对其进行实现
 * 子类还拥有计算线速度的speedCal方法
 */
class  CarSpeedCalculator extends SpeedCalculator{

    private double radius;


    /**
     * 继承实现父类的perimeter方法
     * @return
     */
    @Override
    public double perimeter() {
        return 2*PI*radius;
    }

    public CarSpeedCalculator(double radius, int turnRate) {
        super(turnRate);//通过父类构造器初始化本类的turnRate属性
        this.radius = radius;
    }

    public static void main(String[] args) {
        CarSpeedCalculator c=new CarSpeedCalculator(2,10);
        System.out.println(c.speedCal());
    }
}
