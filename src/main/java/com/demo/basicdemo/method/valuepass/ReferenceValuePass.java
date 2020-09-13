package com.demo.basicdemo.method.valuepass;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ReferenceValuePass {


    /**
     * 引用变量保存的值是堆内存地址，所以参数是引用变量时传递的就是地址
     *
     * 类比：
     * User user=new USer();
     * User user2=user;
     */
    @Test
    public void test(){
        User user = new User();//user引用类型变量保存着对象在堆内存地址
        user.setAge(30);//通过手柄操作(修改)对象
        System.out.println("main-beforeAddAge: "+user.getAge());//通过手柄操作(访问)对象
        //这里会把user变量值，也就是对象堆内存地址传递给被调方法的参数变量，然后被调方法的参数变量也会保存着上面User对象在堆内存地址, 和user变量所指向相同的对象
        addAge(user);
        System.out.println("main-afterAddAge: "+user.getAge());

        String[] myHobby={"code","basketball","health"};
        user.setHobby(myHobby);//这里User的hobby属性和上面的myHobby指向同一数组对象，所以myHobby手柄修改数组对象时候，User的hobby属性引用的数组对象也随之发生改变
        System.out.println(Arrays.toString(user.getHobby()));
        myHobby[1]="sing";
        System.out.println(Arrays.toString(user.getHobby()));

    }

    public static void addAge(User user){
        user.setAge(user.getAge()+1);
        System.out.println("addAge: "+user.getAge());
    }
}

class User {
    private int age;

    String[] hobby;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
