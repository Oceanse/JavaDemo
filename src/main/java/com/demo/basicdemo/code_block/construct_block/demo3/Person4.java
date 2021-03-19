package com.demo.basicdemo.code_block.construct_block.demo3;

/**
 * Person类中存在若干个包含相同代码逻辑的构造函数，存在很多重复代码，
 * 可以将这部分共同的代码抽取出来，使用构造代码块取代
 *
 * 构造代码块
 * 使用场景：如果多个构造器包含相同的代码，且这些代码无需接受参数，可以把他们抽取出来放在构造代码块中
 *
 * 作用：给对象进行初始化，提高代码的复用性和可维护性
 *
 * 特点：1 代码块是没有独立运行的能力，没法通过类或者对象去调用，运行时候必须依附一个载体，编译器会将代码块按照他们的顺序(假如有多个代码块)插入到所有的构造函数的最前端，
 *        所以Person2的代码等同于Person的代码， 这样就能保证不管调用哪个构造函数都会执行所有的构造代码块
 *      2 假如有多个代码块,自上而下顺次执行；因为每个代码块都会被执行，所以建议把多个代码块合并成一个代码块
 *      3 不接受任何参数
 *      4 初始化顺序：属性初始值/代码块(取决于两者代码先后顺序)-->构造器
 */
public class Person4 {

//构造代码块和属性初始值执行的顺序取决两者在代码中的先后顺序，谁在前，谁先执行

    {
        name="oceanblock";
    }
    String name="ocean";



    int age=30;
    {
        age = 31;
    }


    public Person4() {
        System.out.println("Person4() is called");
    }

    public Person4(String name, int age) {
        System.out.println("Person4(String name, int age) is called");
        this.name = name;
        this.age = age;
    }


}


class BlockTest4{
    public static void main(String[] args) {
        //构造代码块和属性初始值执行的顺序取决两者在代码中的先后顺序，谁在前，谁先执行
        System.out.println(new Person4().name+": "+new Person4().age);

        //初始化顺序：属性初始值/代码块(取决于两者代码先后顺序)-->构造器
        System.out.println(new Person4("haiyang", 32).name+": "+new Person4("haiyang", 32).age);
    }
}