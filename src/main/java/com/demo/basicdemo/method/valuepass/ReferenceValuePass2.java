package com.demo.basicdemo.method.valuepass;

import org.testng.annotations.Test;

public class ReferenceValuePass2 {


    /**
     * 引用变量保存的值是堆内存地址，所以参数是引用变量时传递的就是地址
     *
     * 类比：
     * User user=new USer();
     * User user2=user;
     */
    @Test
    public void test(){
        User2 user2=new User2();
        user2.setI(10);
        user2.setJ(20);
        System.out.println("test: "+user2.i+" "+user2.j);
        swap(user2);//把user2保存的地址复制一份传递给swap方法，之后test方法栈中的局部变量user2和swap方法栈中的局部变量指向同一个堆对象
        System.out.println("test: "+user2.i+" "+user2.j);
    }

    public static void swap(User2 user){
        System.out.println("swap1: "+user.i+" "+user.j);
        int temp=user.i;
        user.i=user.j;
        user.j=temp;
        System.out.println("swap2: "+user.i+" "+user.j);
    }
}

class User2 {
    public int i;

    public int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
