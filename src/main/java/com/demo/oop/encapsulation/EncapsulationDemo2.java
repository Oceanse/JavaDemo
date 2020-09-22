package com.demo.oop.encapsulation;

/**
 * private也可以对方法进行封装，不允许外部类对象调用
 * 类内部某个public方法可以调用private方法，然后把这个public方法对外开放
 */
public class EncapsulationDemo2 {

    /**
     * 对外开放average方法
     * @param i
     * @param j
     * @return
     */
    public  int average(int i, int j){
        int m= this.sum(i,j);
        return  m/2;
    }

    /**
     * private隐藏内部工具类方法，因为这些工具类方法主要供类内使用，不需要对外开放
     * @param i
     * @param j
     * @return
     */
    private  int sum(int i, int j){
        return i+j;
    }
}

class Test{

    public static void main(String[] args) {
        EncapsulationDemo2 e=new EncapsulationDemo2();
        System.out.println(e.average(4, 6));
    }
}