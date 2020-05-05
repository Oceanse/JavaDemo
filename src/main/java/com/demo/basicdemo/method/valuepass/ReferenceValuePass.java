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
        User user = new User();
        user.setAge(30);
        System.out.println("main: "+user.getAge());
        //这里传递的是user引用变量保存的堆内存地址，也就是对象地址，这里会把对象堆内存地址传递给被调方法的参数变量
        //被调方法的参数变量也会指向user所指向的对象
        addAge(user);

        System.out.println("main2: "+user.getAge());

        String[] hobby={"code","basketball","health"};
        user.setHobby(hobby);
        System.out.println(Arrays.toString(user.getHobby()));
        hobby[1]="sing";
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
