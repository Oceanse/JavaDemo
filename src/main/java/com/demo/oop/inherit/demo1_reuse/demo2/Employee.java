package com.demo.oop.inherit.demo1_reuse.demo2;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ocean
 * @version 1.3-SNAPSHOT 2021-03-13
 */
public class Employee {

    private String name;
    private int id;
    private static int nextId;
    public static final Map<Integer, String> idNameInfo;
    public static final Map<Integer, Double> idSalaryInfo;
    private double salary;

    static {
        nextId = 1;
        idNameInfo = new HashMap<>();
        idSalaryInfo = new HashMap<>();
    }

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = nextId;
        nextId++;
        idNameInfo.put(id, name);
        idSalaryInfo.put(id, salary);
    }


    /**
     * 加薪
     *
     * @param byPercent
     */
    public void raiseSalary(double byPercent) {
        this.salary = salary + salary * byPercent / 100;
        idSalaryInfo.put(id, salary);
    }


    /**
     * 获取薪水
     *
     * @return
     */
    public double getSalary() {
        return this.salary;
    }


    /**
     * 获取id
     *
     * @return
     */
    public int getId() {
        return id;
    }


    /**
     * 获取name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 获取下一个将要入职的新员工的id,该方法返回值和前对象无关，所以设置为静态
     *
     * @return
     */
    public static int getNextId() {
        return nextId;
    }



    /**
     * 根据id获取name,该方法返回值和当前对象无关，所以设置为静态
     *
     * @param id
     * @return
     */
    public static String getNameById(int id) {
        return idNameInfo.get(id);
    }


    /**
     * 根据id获取salary，该方法返回值和当前对象无关，所以设置为静态
     *
     * @param id
     * @return
     */
    public static double getSalaryById(int id) {
        return idSalaryInfo.get(id);
    }


    public static void main(String[] args) {
        Employee e = new Employee("ocean", 30000);
        System.out.println(e.getId());
        System.out.println(e.getName());
        System.out.println(e.getSalary());

        //员工e加薪10%
        e.raiseSalary(10);
        System.out.println(e.getSalary());

        //员工e2加薪10%
        Employee e2 = new Employee("phy", 60000);
        System.out.println(e2.getSalary());
        e2.raiseSalary(10);
        System.out.println(e2.getSalary());


        System.out.println("根据id查询指定员工的name和salary");
        System.out.println(Employee.getNameById(1));
        System.out.println(Employee.getNameById(2));
        System.out.println(Employee.getSalaryById(1));
        System.out.println(Employee.getSalaryById(2));

        //查询未来将要入职的新员工的id
        System.out.println(Employee.getNextId());

    }
}
