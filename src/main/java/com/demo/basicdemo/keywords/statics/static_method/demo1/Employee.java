package com.demo.basicdemo.keywords.statics.static_method.demo1;


import org.testng.annotations.Test;


/**
 * 定义：
 * 当一个类所有对象执行某个方法时产生的影响是相同的，我们可以把这个方法定义为静态方法；静态方法属于类级别的方法；
 * 比如name是成员变量，那么不同对象具有不同的name, getName应该是实例方法；nation是静态属性，所有的对象具有相同的nation, getNation应该是静态方法
 * <p>
 * 用途：
 * 静态方法适合工具类中方法的定义，方便编程使用；比如文件操作，日期处理，数值处理
 * 静态方法适合入口方法的定义；比如单例模式，因为从外部拿不到构造函数，所有定义一个静态的方法获取对象非常有必要；
 * <p>
 * 使用方式：
 * 1 类名.静态方法名(参数)
 * 2 对象.静态方法名(参数) 可以通过对象访问全局方法，但最终的结果其实和这个对象无关，本质还是通过这个对象所属的类访问的,所以还是建议通过类名访问
 * 3 静态方法名(参数) 调用本类的static方法时候可省略类名，编译器会从当前类中找这个方法
 * 4 在A类中通过静态导入B类的全局方法，就可以实现省略类名来调用B类的全局方法
 * <p>
 * 注意：
 * 1 静态方法只能访问调用静态成员和方法，不能直接访问或者通过this/super访问调用普通的非静态的方法和变量；（非静态方法可以任意的调用静态方法/变量）
 * 2 静态方法内部可以调用一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
 * 3 静态方法内部不能使用this和super关键字（静态方法属于类级别，此时可能还没有对象，故不能使用(this/super属于对象级别)
 *
 * <p>
 */
public class Employee {

    private String name;
    private double eid;
    private String role;
    private String department;
    private static String company="Ericsson";

    /**
     * 实例方法: name和具体的员工对象有关
     */
    public String getName() {
        return name;
    }

    /**
     * 实例方法: name和具体的员工对象有关
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 实例方法: eid和具体的员工对象有关
     */
    public double getEid() {
        return eid;
    }

    /**
     * 实例方法: eid和具体的员工对象有关
     */
    public void setEid(double eid) {
        this.eid = eid;
    }

    /**
     * 实例方法: role和具体的员工对象有关
     */
    public String getRole() {
        return role;
    }

    /**
     * 实例方法:role和具体的员工对象有关
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 实例方法: department和具体的员工对象有关
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 实例方法: department和具体的员工对象有关
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * 静态方法：所有员工对象共享类变量company, 所有对象调用这个方法的结果是相同的，所以该方法可以设计成静态方法
     * @return company
     */
    public static String getCompany(){
        return company;
    }

    /**
     * 静态方法：所有员工对象共享类变量company, 所有对象调用这个方法产生的效果是相同的，所以该方法可以设计成静态方法
     * @return company
     */
    public static void setCompany(String company) {
        Employee.company = company;
    }

    /**
     * 实例方法: toString的返回值中的name等属性值和具体的员工对象有关
     * @return
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", eid=" + eid +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    /**
     * 静态方法不能直接访问或者通过this/super访问实例变量和实例方法，
     * 但是静态方法可以访问一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
     */
    public static void test() {

        Employee.getCompany();//通过类访问静态方法
        new Employee().getCompany();//通过对象访问静态方法，本质还是通过当前对象的类名进行调用
        getCompany();//调用本类的静态方法时候可省略类名，编译器会从当前类中找这个方法

        String company = Employee.company;//通过类访问静态变量
        String company2 = new Employee().company;//通过对象访问静态变量，本质还是通过当前对象的类名进行调用
        String company3 = company;//调用本类的静态属性时候可省略类名，编译器会从当前类中找这个属性
    }


    /**
     * 静态方法内部不能使用this和super关键字（静态方法属于类级别，此时可能还没有对象，故不能使用(this/super属于对象级别)
     * this代表调用test4方法的当前对象，test4方法在执行时候可能还没有产生对象，所以this.test()或者this.PI会报错
     * <p>
     * 静态方法不能直接访问或者通过this/super访问实例变量和实例方法，
     * 但是静态方法可以访问一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
     */
    @Test
    public static void test2() {
        //getDepartment();  //getDepartment()是实例方法，前面默认有this
        //this.getDepartment()
        //System.out.println(this.department);
        //System.out.println(super.toString());
    }


    /**
     * 静态方法只能访问调用静态成员和方法，不能直接访问或者通过this/super访问实例变量和实例方法，
     * 这里直接访问getEid()就等价于this.getEid(), 因为此时test2_2方法在执行时候可能还没有产生对象，所以直接访问getEid()会报错
     */
    public static void test2_2() {
        //getEid(); //等价于this.getEid()
    }

    /**
     * 静态方法内部可以调用构造方法来new对象
     * 静态方法可以访问一种特殊的实例方法：构造方法，进而也可以通过构造方法产生的对象访问实例方法或者实例属性
     */
    public static void test3() {
        new Employee().getEid();
        System.out.println(new Employee().eid);
    }



    /**
     * 因为在程序开始执行时必须调用main() ，甚至在构造方法之前，所以它被声明为static。
     */
    public static void main(String[] args) {

    }

}


