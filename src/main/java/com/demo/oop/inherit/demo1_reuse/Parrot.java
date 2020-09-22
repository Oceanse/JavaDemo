package com.demo.oop.inherit.demo1_reuse;

public class Parrot extends Bird {

    String language;

    public Parrot() {
        System.out.println(" public Parrot() is invoked");
    }

    //Parrot类拥有本类和Bird类、Animal类全部的属性
    public Parrot(String species,String food,String swingsShape, String language) {
        this.species=species;
        this.food=food;
        this.swingsShape=swingsShape;
        this.language=language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void say() {
        System.out.println("Imitate human speech...");
    }

    public static void main(String[] args) {
        //一定是先调用父类构造器，再调用本类构造器
        Parrot parrot=new Parrot("parrot","grain","triangle","chinese");

        //Parrot类拥有本类和Bird类、Animal类全部的方法
        //注意这里parrot调用的是自己的方法
        System.out.println(parrot.getSpecies());
        System.out.println(parrot.getFood());
        System.out.println(parrot.getSwingsShape());
        System.out.println(parrot.getLanguage());
        parrot.eat();
        parrot.fly();
        parrot.say();
    }


}
