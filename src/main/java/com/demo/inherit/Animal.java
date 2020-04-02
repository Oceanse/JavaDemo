package com.demo.inherit;


/*继承可以使用 extends 和 implements 这两个关键字来实现继承
 * 当一个类没有继承的两个关键字，
 * 则默认继承object（这个类在 java.lang 包中，所以不需要 import）祖先类。*/


public class Animal {
    private String something;  //对子类不可见
    String species;
    int age;

    public Animal() {
        System.out.println("Animal空参构造");
    }

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
        System.out.println("Animal双参构造");
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("Animal eats food");
    }

    public void sleep() {
        System.out.println("Animal sleeps");
    }


}


//原封不动继承Animal,拥有父类的所有属性和方法
class Bird extends Animal {

    //如果子类的构造方法中没有显示地调用父类构造方法，则系统默认调用父类无参数的构造方法
    public Bird() {
        //super() 必须保证父类中有空参构造方法
    }

    ;


    //显示的调用父类参数的构造方法public Animal(String species,int age)
    public Bird(String species, int age) {
        super(species, age);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "species='" + species + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        //子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）
        //子类不能继承父类的构造方法，所以子类必须显示的定义好构造方法，才能去new子类对象
        Bird b = new Bird();
        System.out.println(b.toString());


        //子类的构造方法中显示地调用基类指定构造方法，则调用且只调用指定构造方法
        Bird b2 = new Bird("eagle", 33);//不再调用super()
        System.out.println(b2.toString());

        //new Bird(1,2,3) 报错，子类中无此构造方法

        //没有重写父类方法，默认调用父类的方法，对于sleep和eat, b和b2有着相同的实现
        b.sleep();
        b2.sleep();
        b.eat();
        b2.eat();
    }
}


class Human extends Animal {
    String thinking;

    public Human() {
        super();
    }

    public Human(String species, int age, String thinking) {
        super(species, age);    //显示调用父类双参
        this.thinking = thinking;
    }

    public String getThinking() {
        return thinking;
    }

    public void setThinking(String thinking) {
        this.thinking = thinking;
    }


    @Override
    public void eat() {
        System.out.println("human eat");
    }

    @Override
    public void sleep() {
        System.out.println("human sleep");
    }

    public void study() {
        System.out.println("people study");
    }

    @Override
    public String toString() {
        return "human{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", thinking='" + thinking + '\'' +
                '}';
    }


    public void test() {

        Animal a = new Animal();
        a.eat();
        a.sleep();

        Human h = new Human();
        h.eat();
        h.sleep();

        //this 调用当前类对象的方法
        this.eat();
        this.sleep();

        //super调用父类方法
        super.eat();
        super.sleep();


        //编译时是Animal类型，运行时是Human类型
        Animal a2 = new Human("human", 23, "smart");//向上转型
        a2.sleep();
        a2.eat();

        //a2.study();编译时是Animal类型，Animal类中没有study编译不通过，
        ((Human) a2).study();//强转之后可以调用Human独有方法



       /*
       这里不能把Animal转成Person，向上转型之后才能进行强转
       Animal a3 = new Animal();
        Human human=(Human)a3;
        ((Human) a3).study();*/


    }

    public static void main(String[] args) {
        new Human().test();
    }


}

