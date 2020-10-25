package com.demo.others;


import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.util.ClassPath;
import org.apache.bcel.util.SyntheticRepository;
import org.testng.annotations.Test;

/**
 * 本类中SyntheticRepository  Repository  JavaClass可以用LoadClassDemo2.java中SyntheticRepository  Repository  JavaClass替换
 * */
public class LoadClassDemo {


    @Test
    public void test() throws ClassNotFoundException {
        JavaClass javaClass = Repository.lookupClass(LoadClassDemo.class);
        ClassGen classGen = new ClassGen(javaClass);
        Method[] methods = classGen.getMethods();   //import com.sun.org.apache.bcel.internal.classfile.Method

        //等价于
       /* Class clazz=LoadClassDemo.class;
        Method[] methods = clazz.getDeclaredMethods();   */


        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }


    @Test
    public void test2() throws ClassNotFoundException {
        String path = "C:/Program Files/Java/jdk1.8.0_201/jre/lib/rt.jar/";
        //String path = "C:/Program Files/Java/jdk1.8.0_201/jre/lib/";不可以

        //把path路径下的所有文件加入到classpath
        SyntheticRepository repo = SyntheticRepository.getInstance(new ClassPath(path));
        Repository.setRepository(repo);

        //Repository会在classpath下寻找加载指定的类
        JavaClass javaClass = Repository.lookupClass("java.lang.String");

        Method[] methods = javaClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }







}
