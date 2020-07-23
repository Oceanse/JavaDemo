package com.demo.others;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.util.ClassPath;
import org.apache.bcel.util.SyntheticRepository;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 官网：https://commons.apache.org/proper/commons-bcel/
 *
 *
 * The Byte Code Engineering Library (Apache Commons BCEL™) is intended to give users a convenient way to analyze,
 * create, and manipulate (binary) Java class files
 *
 *
 * <dependency>
 * <groupId>org.apache.bcel</groupId>
 * <artifactId>bcel</artifactId>
 * <version>6.2</version>
 * </dependency>
 */

@ClassAno("hello")
@ClassAno2("hello2")
public class LoadClassDemo2<Color> {

    public static void main(String[] args) {
        System.out.println(Test.class.getName());
    }

    @Test
    public void test() throws ClassNotFoundException {
        String path = "C:/Program Files/Java/jdk1.8.0_201/jre/lib/rt.jar/";
        //String path = "C:/Program Files/Java/jdk1.8.0_201/jre/lib/";//rt.jar父路径也可以

        //把path路径下的所有文件加入到classpath,而且该path十分灵活，可以是指定的具体某个文件或者该文件所在的父目录
        SyntheticRepository repo = SyntheticRepository.getInstance(new ClassPath(path));
        Repository.setRepository(repo);

        //Repository会在classpath下寻找加载指定的类
        JavaClass javaClass = Repository.lookupClass("java.lang.String");

       //获取全类名
        System.out.println(javaClass.getClassName());//java.lang.String
        System.out.println();


        //获取本类所有属性
        Field[] fields = javaClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }


        //获取本类所有方法
        Method[] methods = javaClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    @Override
    public String toString() {
        return "LoadClassDemo2{}";
    }



    @Test
    public void test2() throws ClassNotFoundException {
       // String path = "C:\\Users\\epanhai\\Documents\\git\\JavaDemo\\target\\classes";
        String path= "C:\\Users\\epanhai\\Documents\\git\\JavaDemo";//classes父路径也也可以
        SyntheticRepository repo = SyntheticRepository.getInstance(new ClassPath(path));
        Repository.setRepository(repo);
        JavaClass javaClass = Repository.lookupClass("com.demo.others.LoadClassDemo2");

        AnnotationEntry[] annotationEntries = javaClass.getAnnotationEntries();//获取类注解
        for (AnnotationEntry annotationEntry : annotationEntries) {

            //@Lcom/demo/others/ClassAno;(value=hello)格式
            System.out.println(annotationEntry);

           //注解类型相关
            System.out.println(annotationEntry.getAnnotationType());//Lcom/demo/others/ClassAno;格式
            String substring = annotationEntry.getAnnotationType().replace("/", ".").replace(";", "").substring(1);
            System.out.println(substring);//com.demo.others.ClassAno格式

            //注解值相关
            ElementValuePair[] elementValuePairs = annotationEntry.getElementValuePairs();
            for (ElementValuePair elementValuePair : elementValuePairs) {
                System.out.println("key:value=" + elementValuePair.getNameString() + ":" + elementValuePair.getValue().stringifyValue());
            }
            System.out.println();
        }
    }


    @Test
    public static void test3() throws Exception {
        String path = "C:\\Users\\epanhai\\.m2\\repository\\se\\ericsson\\jcat\\jcat-demo\\R6C0022\\jcat-demo-R6C0022-jar-with-dependencies.jar";
        SyntheticRepository repo = SyntheticRepository.getInstance(new ClassPath(path));
        Repository.setRepository(repo);
        JarFile jarFile = new JarFile(new File(path));

        //List<JarEntry> collect = jarFile.stream().collect(Collectors.toList());
        //List<String> collect1 = jarFile.stream().map(jarEntry -> jarEntry.toString()).collect(Collectors.toList());

        List<String> classfile = jarFile.stream().filter(jarEntry -> jarEntry.toString().endsWith(".class"))
                .filter(jarEntry -> jarEntry.toString().contains("ericsson"))
                .map(jarEntry -> jarEntry.toString().replace("/", ".").replace(".class", ""))
                .collect(Collectors.toList());

        List<Method> methods = new ArrayList<>();
        classfile.stream().map(file -> LoadClassDemo2.loadClass(file))
                .filter(Objects::nonNull)
                .forEach(javaClass -> methods.addAll(LoadClassDemo2.getMyMethods(javaClass)));
        System.out.println(methods.size());
        for (Method method : methods) {
            System.out.println(method);
        }
    }


    @Test
    public static void test4() throws Exception {
        String path = "C:\\Users\\epanhai\\.m2\\repository\\se\\ericsson\\jcat\\jcat-demo\\R6A0121-SNAPSHOT\\jcat-demo-R6A0121-SNAPSHOT-jar-with-dependencies.jar";
        //String path= "C:\\Users\\epanhai\\Documents\\git\\myproject\\JavaDemo";也可以
        SyntheticRepository repo = SyntheticRepository.getInstance(new ClassPath(path));
        Repository.setRepository(repo);
        // LoadClassDemo2.loadClass("se.ericsson.cat2.traffic.DemoTrafficManager$DemoStats")
        JavaClass javaClass = LoadClassDemo2.loadClass("se.ericsson.cat2.traffic.DemoTrafficManager$DemoStats");
        //JavaClass javaClass = Repository.lookupClass("se.ericsson.cat2.traffic.DemoTrafficManager$DemoStats");
        System.out.println(javaClass.getClassName());
        Method[] methods = javaClass.getMethods();
        System.out.println(Arrays.toString(methods));


    }

    private static JavaClass loadClass(String clazzName) {

        JavaClass javaClass = null;
        try {
            javaClass = Repository.lookupClass(clazzName);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return javaClass;
    }


    public static List<Method> getMyMethods(JavaClass javaClass) {
        AnnotationEntry[] annotationEntries = javaClass.getAnnotationEntries();
        if (isAnnotationPresent(annotationEntries, Test.class.getName())) {
            Method[] methods = javaClass.getMethods();
            return Arrays.asList(methods);
            //return Arrays.stream(methods).collect(Collectors.toList());
        } else {
            Stream<Method> stream = Arrays.stream(javaClass.getMethods());
            return stream.filter(method -> isAnnotationPresent(method.getAnnotationEntries(), Test.class.getName()))
                    .collect(Collectors.toList());

        }

    }

    public static String cleanAnnotationType(AnnotationEntry entry) {
        String type = entry.getAnnotationType();
        type = type.replaceAll("/", ".").replace(";", "");
        return type.substring(1, type.length());
    }

    public static boolean isAnnotationPresent(AnnotationEntry[] entries, String annotation) {
        for (AnnotationEntry entry : entries) {
            String cleanedEntry = cleanAnnotationType(entry);
            if (cleanedEntry.equals(annotation)) {
                return true;
            }
        }
        return false;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface ClassAno {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface ClassAno2 {
    String value();
}
