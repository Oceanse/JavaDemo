package com.demo.oop.aggregation;

/**
 * 继承缺点：
 * 通过机继承可以复用父类的方法和属性，但是这在一定成都上破坏了父类的封装性，封装时提到：每个类都应该封装它内部信息和实现细节，
 * 而只暴露必要的方法给其他类使用。但在继承关系中， 子类可以直接访问父类的成员变量（内部信息）和方法， 从而造成子类和父类的严重耦合。
 * 从这个角度来看， 父类的实现细节对子类不再透明， 子类可以访问父类的成员变量和方法，并可以改变父类方法的实现细节（例如，
 * 通过方法重写的方式来改变父类的方法实现）， 从而导致子类可以恶意篡改父类的方法。比如Sparrow 继承Bird, 重写了Bird类的fly()方法，
 * 从而改变了fly()方法的实现细节。有如下代码：
 * Bird b = new Ostrich();
 * b. fly()
 * 对于上面代码声明的Bird引用变量， 因为实际引用一个Sparrow对象，所以调用b的fly()方法时执行的不再是Bird类提供的fly()方法，
 * 而是Sparrow类重写后的flyQ方法
 *
 * 使用继承的场景 ：
 * 到底何时需要从父类派生新的子类呢？不仅需要保证子类是一种特殊的父类，而且需要具各以下两
 * 个条件之一。
 * 1 父类和子类是is-a关系，即子类is父类
 *
 * 2 子类需要额外增加成员变量，而不仅仅是变量值的改变。例如从Person类派生出Student子类，
 * Person类里没有提供grade (年级）成员变量， 而Student类需要grade成员变量来保存Sn1dent
 * 对象就读的年级， 这种父类到子类的派生， 就符合Java 继承的前提。
 *
 * 3 子类需要增加自己独有的行为方式（包括增加新的方法或重写父类的方法）。例如从Person 类
 * 派生出Teacher类， 其中Teacher类需要增加一个teaching()方法， 该方法用千描述Teacher对象
 * 独有的行为方式： 教学。
 *
 * 复用：
 * 是把旧类对象作为新类的成员变量组合进来， 新类直接复用旧类的public方法通常需要在新类里使用private修饰被组合的旧类对象。
 *
 * HAS-A(组合或者聚合关系)：把一个类的对象作为另一个类的属性
 * a事物(羊毛)是b事物(绵羊)的一个部分、部件,或者说b事物由a食物组成
 *
 * 使用场景：
 * 如果两个类之间有明确的整体、部分的关系， 例如Person类需要复用Arm类的方法(Person对象由Arm对象组合而成），
 * 此时就应该采用组合关系来实现复用， 把Arm作为Person类的组合成员变量， 借助千Arm的方法来实现Person的方法， 这是一个不错的选择。
 *
 * 如果一个类有另一个类的实体引用(类中的类)，则它称为聚合/组合。 聚合表示HAS-A关系。
 *
 * 好处：当没有is-a关系时，通过聚合也能最好地实现代码重用。
 * 只有在所涉及的对象的整个生命周期内维持关系为is-a时，才应使用继承; 否则，聚合是最好的选择。
 */
public class AggregationTest {

    public static void main(String[] args) {
        Address address1 = new Address("广州", "广东");
        Address address2 = new Address("海口", "海南");

        Employee e = new Employee(111, "Wang", address1);
        Employee e2 = new Employee(112, "Zhang", address2);

        e.display();
        e2.display();

    }

}
