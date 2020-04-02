package com.demo.reflection;

import org.testng.annotations.Test;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * Java 反射机制在程序运行时，对于任意一个类， 都能够知道这个类的完整结构包括父类、父接口、属性、方法等相关信息并且能够创建对象；对于任意一个对象， 都能够调用它的任意一个方法和属性。
 * 这种 动态的获取信息 以及 动态调用对象的方法 的功能称为 java 的反射机制；反射机制很重要的一点就是“运行时”，其使得我们可以在程序运行时加载、探索以及使用编译期间完全未知的 .class 文件
 */


//反射获得的是运行时类（class文件加载到内存并被解释执行）的相关信息，所以注解的有效期是RUNTIME时才能获取到
@Color("red")
@Count(3)
public class Apples extends Fruit {
    public String name;
    double price;
    protected boolean sweet;
    private String area;

    public Apples() {
    }

    public Apples(String name, double price, boolean sweet, String area) {
        this.name = name;
        this.price = price;
        this.sweet = sweet;
        this.area = area;
    }

    @Color("green")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    boolean isSweet() {
        return sweet;
    }

    void setSweet(boolean sweet) {
        this.sweet = sweet;
    }

    @Override
    public String toString() {
        return "Apples{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sweet=" + sweet +
                ", area='" + area + '\'' +
                '}';
    }





    @Test
    //获取反射中的Class对象, 一个Class对象对应的是一个加载到JVM中的一个.class文件,无论获取不获取都会存在
    public void test() throws ClassNotFoundException {
        Class clz = new Apples().getClass();
        Class clz2 = Apples.class;
        Class clz3 = Class.forName("com.demo.reflection.Apples");

        //通过app类加载器获取Class对象
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clz4 = classLoader.loadClass("com.demo.reflection.Apples");
        System.out.println(clz == clz2 && clz2 == clz3);
    }


    //通过Class可以完整地得到一个类中的完整结构
    @Test
    public void test2() {
        Class clz = Apples.class;
        System.out.println(clz.getName());//全限定名
        System.out.println(clz.getPackage());//包名
        System.out.println(clz.getSimpleName());//类名
        System.out.println(clz.getSuperclass());//所有父类
        System.out.println(clz.getInterfaces());//所有父接口
        System.out.println(clz.getDeclaredFields());//本类所有属性
        System.out.println(clz.getDeclaredMethods());//本来所有方法
        System.out.println(clz.getAnnotations());//所有类注解
    }





    //获取构造器并通过反射创建类对象
    @Test
    public void test3() throws Exception {

        //获取所有构造器
        Class clz = Apples.class;
        Constructor[] constructors = clz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //通过空参构造器创建对象
        Constructor constructor = clz.getConstructor();
        Apples apples = (Apples) constructor.newInstance();

        //通过指定四参构造器创建对象
        Constructor constructor1 = clz.getConstructor(String.class, double.class, boolean.class, String.class);
        Apples apples2 = (Apples) constructor1.newInstance("hongfushi", 1, true, "yantai");
    }




    //反射获取字段相关信息
    @Test
    public void test4() throws NoSuchFieldException {
        //getFields()只能获取public的字段，包括父类的
        Class clz = Apples.class;
        Field[] Fields = clz.getFields();
        for (Field field : Fields) {
            System.out.print(field.getName() + " ");
        }
        System.out.println();

        //getDeclaredFields()只能获取本类所有权限的字段，不包括父类的
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField.getName() + " ");
        }


        System.out.println("\n"+"\n"+"获取属性权限修饰符:");
        //获取属性权限修饰符
        for (Field declaredField : declaredFields) {
            System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getName());
        }

        //获取属性类型
        System.out.println("\n"+"获取属性类型");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getType() + " " + declaredField.getName());
        }

        //获取特定属性
        System.out.println("\n"+"获取特定属性");
        Field fi = clz.getField("name");
        System.out.println(fi.getName());
        System.out.println(Modifier.toString(fi.getModifiers()));
        System.out.println(fi.getType());
    }







    //反射获取调用指定方法
    @Test
    public void test5() throws Exception {
        Class clz = Apples.class;
        Apples a = (Apples) clz.newInstance();

        //获取本类及其父类的public方法
        System.out.println("获取本类及其父类的public方法");
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + " ");
        }

        //获取本类的所有权限的方法，不包括父类
        System.out.println("\n"+"\n"+"获取本类的所有权限的方法，不包括父类");
        Method[] declaredMethod = clz.getDeclaredMethods();
        for (Method method : declaredMethod) {
            System.out.print(method.getName() + " ");
        }



        Method getArea = clz.getMethod("getArea");

        //获取getArea()方法权限修饰符
        System.out.println("\n"+"获取方法权限修饰符");
        String s = Modifier.toString(getArea.getModifiers());
        System.out.println(s);


        //获取getArea()方法返回值
        System.out.println("\n"+"获取getArea()方法返回值");
        Class<?> returnType = getArea.getReturnType();
        System.out.println(returnType.getName());


        //获取setName参数类型
        System.out.println("\n"+"获取setName参数");
        Method setName = clz.getMethod("setName", String.class);
        Class<?>[] parameterTypes = setName.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType.getName());
        }


        //获取getArea方法上的所有注解
        System.out.println("\n"+"\n"+"获取getArea方法上的所有注解");
        Annotation[] annotations = getArea.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取getArea方法上指定注解的值
        System.out.println("\n"+"获取getArea方法上指定注解的值");
        Color annotation = getArea.getAnnotation(Color.class);
        System.out.println(annotation.value());

        //调用public方法
        System.out.println();
        Method m = clz.getMethod("setName", String.class);//方法名和参数决定方法对象
        System.out.println(m.getName());
        m.invoke(a, "红富士");//传入对象及方法参数

        Method getName = clz.getDeclaredMethod("getName");
        String name = (String)getName.invoke(a); //getName虽然是private,但是由于实在同一个类中，所以这里可以直接调用
        System.out.println(name);


        /*
        如果是在另一个类中调用getName ,需要如下处理
        getName.setAccessible(true);
        String name = (String)getName.invoke(a);*/

    }


    @Test
    public void test7() throws ClassNotFoundException {
        Class clz = Apples.class;

        //应用程序类加载器(Application ClassLoader， AppClassLoader):这个类加载器负责加载用户类路径(CLASSPATH)下的类库,
        // 一般我们编写的java类都是由这个类加载器加载,也称之为系统类加载器
        //获取Apples的类加载器
        ClassLoader classLoader = clz.getClassLoader();//我们编写的java类由AppClassLoader负责加载
        System.out.println(classLoader);

        //扩展类加载器(Extendsion ClassLoader， ExtClassLoader)这个类加载器负责加载\lib\ext目录下的类库
        ClassLoader exet = classLoader.getParent();
        System.out.println(exet);

        //启动类加载器(Bootstrap ClassLoader)该加载器无法直接获取.加载java核心类库
        //比如C:\Program Files\Java\jdk1.8.0_201\jre\lib\rt.jar
        ClassLoader bootstrap = exet.getParent();
        System.out.println(bootstrap);


        //启动类加载器无法直接获取
        ClassLoader bootstrap2 = Class.forName("java.lang.Object").getClassLoader();//系统核心类库由(Bootstrap ClassLoader负责加载核心类库
        System.out.println(bootstrap2);

    }


    //获取类注解
    @Test
    public void test3x() {
        Class clz = Apples.class;
        Annotation[] annotations = clz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println();
        Annotation annotation = clz.getAnnotation(Color.class);
        Color color = (Color)clz.getAnnotation(Color.class);
        System.out.println(annotation);
        System.out.println(color);
    }
}



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface Color {
    String value();
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface Count {
    int value();
}

class Fruit {
    public String kind;

    public String getKind() {
        return kind;
    }

    void setKind(String kind) {
        this.kind = kind;
    }
}

