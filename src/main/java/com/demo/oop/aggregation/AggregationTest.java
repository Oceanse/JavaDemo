package com.demo.oop.aggregation;

/**
 * HAS-A:这种事物(羊毛)隶属于那种事物(绵羊)，是它的一个部分、部件。
 * 如果一个类有一个类的实体引用(类中的类)，则它称为聚合。 聚合表示HAS-A关系。
 *
 * 好处：当没有is-a关系时，通过聚合也能最好地实现代码重用。
 *
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
