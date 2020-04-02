package com.demo.basicdemo.method.valuepass;

public class MethodReferPass {

    //方法参数传递都是传递变量所保存的值，只不过基本类型变量保存的是字面值，传递的就是保存的字面值
    // 引用变量保存的值是堆内存地址，所以参数是引用变量时传递的就是地址
    public static void main(String[] args) {
        User user = new User();
        user.setAge(30);
        System.out.println("main: "+user.getAge());
        addAge(user);//这里传递的是user引用变量保存的堆内存地址，也就是对象地址，被调用的方法就会对这块地址对应的数据进行处理
        System.out.println("main2: "+user.getAge());
    }


    public static void addAge(User user){
        user.setAge(user.getAge()+1);
        System.out.println("addAge: "+user.getAge());
    }
}

class User {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
