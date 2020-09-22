package com.demo.oop.encapsulation.packageDemo;


import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
/**
 *  import可以避免书写过长的全类名(可以省略包名)，因此可以简化编程，
 *  当然import语句不是必需的，可以使用全类名替换import
 *
 *  通配符*可以导入某个包下的所有类，比如： import mypackage.*  注意这里的*只能代表类，不能代表包
 *  也就是import mypackage.* 只会导入mypackage包下直接的类，不会导入其子包下的类
 *
 *  静态导入：导入某个类的类变量或者类方法，然后可以省略类名，因此可以简化编程，
 *    语法：
 *    import static 全类名.静态变量
 *    import static 全类名.静态方法
 *    import static 全类名.*
 *    其中这里的通配符*只能匹配类变量或者类方法
 *
 *  java lang包下的类会自动被import,相当于import java.lang.*
 */
public class ImportDemo {
    public static void main(String[] args) {
        String str="java.lang.String会自动被import";
        Arrays.asList(1,2,3);//Arrays属于java.util包，不属于当前package,如果不想使用全类名，那么需要import


        //通过import static java.lang.System.* 和 import static java.lang.Math.*; 省略类名直接调用类变量或者类方法
        out.println(PI);



    }
}
