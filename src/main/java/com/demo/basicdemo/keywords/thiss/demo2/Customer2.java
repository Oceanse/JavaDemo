package com.demo.basicdemo.keywords.thiss.demo2;


public class Customer2 {

    String name;


    public String getName() {
        return name;
    }


    /**
     * 这里的this不能省略如果省略；
     * this.name中的name是成员变量name,   第二个name是形参变量name
     * 如果省略，根据就近原则这里的两个name都是指形参变量
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * 省略this，根据就近原则这里的两个name都是指形参变量
     * 那么效果就是形参变量给形参变量赋值
     * @param name
     */
    public void setName2(String name) {
        name = name;
    }





    public static void main(String[] args) {

        Customer2 xm = new Customer2();
        xm.setName("ocean");
        System.out.println(xm.getName());


        Customer2 xh = new Customer2();
        xh.setName2("ocean");//这里实际上没有给成员变量赋值，而是形参变量给形参变量赋值
        System.out.println(xh.getName());

        //System.out.println(this); this不能出现在静态方法中，因此调用静态方法时候对象可能还不存在

    }


}
