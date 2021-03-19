package com.demo.oop.inherit.demo1_reuse.demo2;

/**
 * Manager 继承扩展 Employee
 */
public class Manager extends Employee{
    private double bonus;//奖金

    public Manager(String name, double salary, double bonus) {
        super(name, salary);//父类的私有属性name和salary只能通过super初始化
        this.bonus = bonus;
    }


    /**
     * 设置奖金
     * @param bonus
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }



    /**
     * 获取奖金
     * @return
     */
    public double getBonus() {
        return bonus;
    }



    /**
     * 经理还有年终奖，所以要重写父类方法
     * @return
     */
    @Override
    public double getSalary() {
        Manager.idSalaryInfo.put(this.getId(),this.bonus+super.getSalary());
        return this.bonus+super.getSalary();
    }

    public static void main(String[] args) {
        Manager manager = new Manager("mxz", 1000000, 300000);
        System.out.println(manager.getId());
        System.out.println(manager.getName());
        System.out.println(manager.getBonus());
        System.out.println(manager.getSalary());
        System.out.println(Employee.getNameById(1));
        System.out.println(Employee.getSalaryById(1));    }
}
