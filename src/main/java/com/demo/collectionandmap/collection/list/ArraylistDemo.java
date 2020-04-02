package com.demo.collectionandmap.collection.list;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import com.demo.pojo.TestResourceinfo;

import java.util.*;


/*原始类型	包装类型
boolean	Boolean
byte	Byte
char	Character
float	Float
int	Integer
long	Long
short	Short
double	Double

当表格中左边列出的基础类型与它们的包装类有如下几种情况时，编译器会自动帮我们进行装箱或拆箱.

进行 = 赋值操作（装箱或拆箱）
进行+，-，*，/混合运算 （拆箱）
进行>,<,==比较运算（拆箱）
调用equals进行比较（装箱）
ArrayList,HashMap等集合类 添加基础类型数据时（装箱）

我们看一段平常很常见的代码
public void testAutoBox() {
    List<Float> list = new ArrayList<>();
    list.add(1.0f);
    float firstElement = list.get(0);
}

list集合存储的是Float包装类型，我传入的是float基础类型，所以需要进行装箱，
而最后的get方法返回的是Float包装类型，我们赋值给float基础类型，所以需要进行拆箱，很简单，安排的明明白白
*/


public class ArraylistDemo {
    public static void main(String[] args) {


        //add 可能会涉及到自动装箱，list存放的是引用数据类型，Object及其子类
        Collection c = new ArrayList();
        c.add(1);  //元素都一次添加在list的尾部，此时插入效率较高
        c.add(2.0f);
        c.add(3.0);
        c.add('@');
        c.add(true);
        c.add(true);
        c.add("abc");
        c.add(new TestResourceinfo());
        //会把所有元素往后移动一位，新添加的位于第一位，所以ArrayList首位或者中间部分插入数据效率较低
        ((ArrayList) c).add(0, "first");
        ((ArrayList) c).add(1, "second");
        System.out.println("0============================");
        c.stream().forEach(ele -> System.out.println(ele + " "));


        Collection c2 = new ArrayList();
        c2.add(1);
        c2.add("ccc");

        //addAll
        c.addAll(c2);
        System.out.println("1============================");
        System.out.println("c after add is:" + c);

        //delete
        ((ArrayList) c).remove(0);
        c.remove(true);//两个true都被删掉
        Collection c3 = new ArrayList();
        c3.add(1);
        c3.add(2.0f);
        c3.add(3.0);
        c3.add(4);
        c.removeAll(c3);//两个1都会被删除
        //c.clear();
        System.out.println("2============================");
        System.out.println("c after remove is:" + c);

        //update
        ((ArrayList) c).set(0, "first");
        System.out.println("3============================");
        System.out.println("c after uppercase is:" + c);

        //query
        System.out.println("4============================");
        System.out.println("c.size:" + c.size());
        System.out.println("c.contains('@'):" + c.contains('@'));
        System.out.println("fisrt elem:" + ((ArrayList) c).get(0));
        System.out.println("last elem:" + ((ArrayList) c).get(c.size() - 1));
        System.out.println("@ of index:" + ((ArrayList) c).indexOf('@'));
        System.out.println("c2 clear:" + c2.isEmpty());
        c2.clear();
        System.out.println("c2 clear:" + c2.isEmpty());
        //不带泛型时默认返回都是Object
        Object o1 = ((ArrayList) c).get(0);


        //clone
        System.out.println("5============================");
        ArrayList ls = new ArrayList();
        ls.add(0, 123);
        ls.add(1, "xxx");
        Object clone = ls.clone();
        List list = (ArrayList) ls;
        System.out.println(list);

        //go through
        System.out.println("6============================");
        ArrayList ls2 = new ArrayList();
        ls2.add(true);
        ls2.add("ttt");
        ls2.add('!');


        System.out.println();
        for (int i = 0; i < ls2.size(); i++) {
            System.out.print(ls2.get(i) + " ");
        }


        System.out.println();
        for (Object o : ls2) {
            System.out.print(o + " ");
        }

        System.out.println();
        Iterator it = ls2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        ls2.forEach(ele -> System.out.print(ele + " "));

        System.out.println();
        ls2.forEach(System.out::print);
    }



    @Test
    public void test() {
        ArrayList list=new ArrayList();
        String s = list.toString();
        System.out.println(s);
        list.add(1);
        list.add(2);
        String s2 = list.toString();
        System.out.println(s2);
    }


    /**
     *
     <dependency>
         <groupId>com.google.guava</groupId>
         <artifactId>guava</artifactId>
         <version>25.1-jre</version>
     </dependency>
     */
    @Test
    public void test2() {
        List list=Arrays.asList(1,2,3);
        ArrayList list2 = Lists.newArrayList(list);
        System.out.println(list+"\n"+list2);
    }

}
