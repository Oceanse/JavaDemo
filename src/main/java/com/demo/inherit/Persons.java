package com.demo.inherit;

public class Persons {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info(){
        System.out.println("persons.....");
    }
}

class Stu extends Persons{
    double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void info(){
        System.out.println("stu.....");
    }
}


class Work extends Persons{
    String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public void info() {
        System.out.println("work.....");
    }
}

 class Test{

    public void print(Persons p){
        p.info();
    }

     public static void main(String[] args) {
         new Test().print(new Work());
         new Test().print(new Stu());
     }
}
