package com.demo.generic.demo3;

public class TestGeneric<T> {

    //带泛型的属性
    private T t;

    //带泛型的方法
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //泛型方法
    public  <E> E getE(E e){
        return e;
    }
}


//继承时指名泛型类型T，所有使用泛型的地方都要替换成指明的类型
class SubTestGeneric3 extends TestGeneric<Integer>{
    public static void main(String[] args) {
        SubTestGeneric3 s=new SubTestGeneric3();
        s.setT(123);
        Integer e = s.getT();

        String health = s.getE("health");
    }




}

