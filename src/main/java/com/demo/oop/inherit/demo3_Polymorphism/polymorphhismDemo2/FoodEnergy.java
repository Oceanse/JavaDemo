package com.demo.oop.inherit.demo3_Polymorphism.polymorphhismDemo2;

public class FoodEnergy {
    public static void main(String[] args) {
        // 求出指定重量的Fruit,Meat,Grain类食物的总能量
        Food[] foods = new Food[] {
                new Fruit(100),
                new Grain(100),
                new Meat(100)
        };
        System.out.println(getTotalEnergy(foods));
    }

    /**
     * 用多态，totalEnergy()方法只需要和Food打交道，它完全不需要知道Fruit,Meat,Grain的存在，
     * 就可以正确计算出总的税能量。如果我们要新增一种食物，只需要从Food派生，然后正确覆写getEnergy()方法就可以,
     * 把新的类型传入getTotalEnergy()，不需要修改任何代码。
     * 多态具有一个非常强大的功能，就是允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码
     * @param foods
     * @return
     */
    public static double getTotalEnergy(Food... foods) {
        double totalEnergy = 0;
        for (Food food: foods) {
            totalEnergy = totalEnergy + food.getEnergy();
        }
        return totalEnergy;
    }
}

/**
 * 普通收入
 */
class Food{
    private double weight;

    public Food(double weight) {
        this.weight = weight;
    }

    public double getEnergy() {
        return 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

/**
 * 水果能量
 */
class Fruit extends Food {

    public Fruit(double weight) {
        super(weight);
    }

    @Override
    public double getEnergy() {
        return (this.getWeight())*0.01;
    }
}


/**
 * 谷物能量
 */
class Grain extends Food {

    public Grain(double weight) {
        super(weight);
    }

    @Override
    public double getEnergy() {
        return (this.getWeight())*0.02;
    }
}


/**
 * 肉类能量
 */
class Meat extends Food {

    public Meat(double weight) {
        super(weight);
    }

    @Override
    public double getEnergy() {
        return (this.getWeight())*0.03;
    }
}
