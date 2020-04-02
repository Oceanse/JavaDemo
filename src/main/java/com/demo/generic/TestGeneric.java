package com.demo.generic;

import org.testng.annotations.Test;

import java.util.*;

/*泛型，即“参数化类型（类型参数化，实参就是具体的类型）”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。那么参数化类型怎么理解呢？

顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。

泛型的类型参数只能是引用类型（包括自定义类），不能是基本数据类型

泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型

带泛型的属性方法必须出现在泛型类中; 泛型方法或者泛型属性和泛型类无关，他们可以出现在非泛型类中

Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制


*/


class Demo{
    public static void main(String[] args) {
        //ArrayList不带泛型可以存放任意数据类型程，所以导致序运行后会发生ClassCastException
        ArrayList a=new ArrayList();
        a.add("abc");
        a.add("efg");
        a.add(123);
        for (Object o : a) {
            String str=(String)o;//父类引用指向子类实例是才可以进行强转
        }


        ArrayList<Boolean> b=new ArrayList<>();
        b.add(true);
        //b.add(123);  在编译阶段，编译器就会报错

        Map<String,Integer> map=new HashMap<>();
        map.put("ocean",28);
        //map.put("ocean",27.5)   在编译阶段，编译器就会报错
    }

}




//实例化泛型类指名泛型类型T，所有使用泛型的地方都要替换成指明的类型，若没有指明T默认为Object
public class TestGeneric<T> {//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型

    //使用泛型T的成员变量,T的类型由外部实例化时指定
    T t;
    List<T> list;
    String OrderName;
    int Orderid;

    public TestGeneric(){

    }

    //使用泛型的方法
    public TestGeneric(T t){
        this.t=t;
    }

    public void setT(T t){
        this.t=t;
    }

    public T getT(){
        return t;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public int getOrderid() {
        return Orderid;
    }

    public void setOrderid(int orderid) {
        Orderid = orderid;
    }


    //声明泛型方法，泛型方法在调用方法的时候指明泛型的具体类型
    //<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
    public <E>E getE(E e){
        return e;
    }

    //数组复制到list
    public <E> List<E> fromArrayToList(E[] e,List<E> list){
        for(E e1 : e){
            list.add(e1);
        }
        return list;
    }

    @Override
    public String toString() {
        return "TestGeneric{" +
                "t=" + t +
                ", list=" + list +
                ", OrderName='" + OrderName + '\'' +
                ", Orderid=" + Orderid +
                '}';
    }

    public static void main(String[] args) {












    }

    @Test
    public void test(){
        TestGeneric t=new TestGeneric();
        Object t1 = t.getT();//实例化时不传入泛型类型实参，T默认是Object


        //如果实例化时不传入泛型类型实参的话，T默认是Object,
        //因此在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        TestGeneric t22=new TestGeneric(123);
        TestGeneric t3=new TestGeneric(true);
        Object o = t22.getT();//实例化时不传入泛型类型实参，因此类中的T编译时类型就是Object，运行时类型可以理解为Integer类型
        int t6 = (Integer) t22.getT();
    }


    @Test
    public void test2(){
        //在实例化对象的时候如果传入泛型实参，
        // 则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用
        TestGeneric<String> t4=new TestGeneric<>("abc");
        TestGeneric<Double> t5=new TestGeneric<>(1.2);
        String str = t4.getT();//实例化时传入泛型类型String，因此类中的T类型就是String
        Double t7 = t5.getT();//实例化时传入泛型类型Double，因此类中的T类型就是Double
    }


    @Test
    public void test3(){
        //在实例化对象的时候如果传入泛型实参，
        // 则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用
        TestGeneric<String> t4=new TestGeneric<>("abc");
        TestGeneric<Double> t5=new TestGeneric<>(1.2);
        String str = t4.getT();//实例化时传入泛型类型String，因此类中的T类型就是String
        Double t7 = t5.getT();//实例化时传入泛型类型Double，因此类中的T类型就是Double
    }


    @Test
    public void test4(){
        //在实例化泛型类时，必须指定T的具体类型
        TestGeneric<Boolean> t2=new TestGeneric<>();
        List<Boolean> list=new ArrayList<>();
        t2.setList(list);
        t2.setT(true);
        t2.list.add(t2.getT());
        System.out.println(t2.getList());
        System.out.println(t2.getT());
    }


    @Test
    public void test5(){
        //在实例化泛型类时，必须指定T的具体类型
        TestGeneric<Boolean> t=new TestGeneric<>();

        //使用声明的泛型方法 public <E>E getE(E e){return e}
        //泛型方法不受泛型类的影响，它都可以脱离泛型类而存在
        Date date=t.getE(new Date());
        Integer i = t.getE(123);

        List<Integer> l=new ArrayList<>();
        l.add(1);
        List<Integer> integers = t.fromArrayToList(new Integer[]{1, 2, 3}, new ArrayList<Integer>());
    }
}





//泛型方法可以出现在非泛型类中
class Gene{

    public <T> T get(T t){
        return t;
    }


    //静态泛型方法
    public static <T> T get2(T t){
        return t;
    }

    //泛型方法打印数组
    public <T> void printArray(T[] arrays){
            System.out.println(Arrays.toString(arrays));
    }




    public static void main(String[] args) {

        //调用泛型方法时指明泛型类型，<T>是泛型方法的声明
        Integer integer = new Gene().get(123);
        String jcat = new Gene().get("jcat");

        //调用静态方法
        Integer integer1 = Gene.get2(123);
        String jcat1 = Gene.get2("jcat");

        new Gene().printArray(new String[]{"aa","bb","cc"});
        new Gene().printArray(new Integer[]{1,2,3});

    }
}


class Class2{
    //T t;  无法解析，带泛型的属性方法必须出现在泛型类中
    public <T> T get(T t){
        return t;
    }
}