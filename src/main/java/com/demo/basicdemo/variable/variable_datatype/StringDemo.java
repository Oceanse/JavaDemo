package com.demo.basicdemo.variable.variable_datatype;

import org.testng.annotations.Test;

import java.util.Arrays;

/*
 * 对象性(object)：
 * Strings, which are widely used in Java programming, are a sequence of characters and are stored as char[].
 *
 * 不可变(immutable)：
 * 字符串对象一旦被创建，其内容是不可变的
 * The String class is immutable, so that once it is created a String object cannot be changed. If there is a necessity to make
 * a lot of modifications to Strings of characters, then you should use String Buffer & String Builder Classes.
 *
 * 底层存储：final char[]
 *
 * String是一个引用类型，它本身也是一个class；String类型变量通常保存的是某个字符串的地址(堆内存地址或者常量池地址)，由于是引用类型变量，所以也可以保存null这个特殊的引用类型的变量值
 * 常量对象：字符串常量对象是用双引号括起的字符序列
 * 字符串的字符使用Unicode字符编码(utf-16,详见char类型变量)，一个字符占两个字节
 */
public class StringDemo {


    /**
     * 字符串四种构造方式
     */
    @Test
    public void test() {
        String names = "Tom";//这里在常量池创建了一个字符串对象， 栈中的局部变量保存着常量池对象的地址
        String color = new String("red");//String(String original) 创建String对象
        String letter = new String(new char[]{'x', 'y', 'z'});//String(char value[])， 字符串底层就是通过一个char[]数组进行存储
        String number = new String(new byte[]{65,97});//解码
        System.out.println(names);
        System.out.println(color);
        System.out.println(letter);
        System.out.println(number);
    }


    /**
     * 不可变性：immutable
     */
    @Test
    public void test2() {
        String s = "Hello";
        String s2 = s.toUpperCase();//这里不是直接改变"Hello"的内容，猜测是复制一份作为副本，然后进行转变，然后存储位新的字符串对象
        System.out.println(s);
        System.out.println(s2);
    }





    /**
     * 详见内存分配图
     */
    @Test
    public void test3() {

        //== 是operator,比较的是两个变量中存储的值
        //常量池中相同的字符串直接量只有一个， 不会存在多个副本，自然str1和str2的引用就是相同的。
        //
        String str1 = "jcat";//str1存放"jcat"在常量池中的地址
        String str2 = "jcat";//str2存放"jcat"在常量池中的地址
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println();

        //equals()是一个方法
        //Object中equals用于判断两个变量是否是对同一个对象的引用,String类中对equals()进行了override,比较的是两个字符串的content
        String str3 = "jcats";//str3存放"jcats"在常量池中的地址
        String str4 = new String("jcats");//str4存放堆内存变量的地址，这个堆内存变量保存着"jcats"在常量池中的地址
        System.out.println("str3.equals(str4): " + str3.equals(str4));
        System.out.println("str3 == str4: " + (str3 == str4));
        System.out.println();

        String str5 = "abc" + "def";
        String str6 = "abcdef";
        System.out.println("str7.equals(str8): " + str5.equals(str6));
        System.out.println("str7 == str8: " + (str5 == str6));
        System.out.println();

        /*//待理解
        String s7 = "hello";
        String s8 = "HELLO".toLowerCase();//
        System.out.println("s7.equals(s8): "+s7.equals(s8));
        System.out.println("s7==s8: "+(s7 == s8));*/

       /* //待理解
        System.out.println("4===============");
        String str11="abc";
        String str22="def";
        String str33=str11+str22;
        String str44="abc"+"def";
        System.out.println(str33.equals(str44));
        System.out.println(str33==str44);*/
    }


    /**
     *  对象性： 有自己的方法
     * 常用方法
     */
    @Test
    public void test4() {
        String str = "nbacba_$!@-123NBACBA";
        System.out.println("str.length(): " + str.length());
        System.out.println("first character: " + str.charAt(0));
        System.out.println("last character: " + str.charAt(str.length() - 1));
        System.out.println();

        System.out.println("str.indexOf('a'): " + str.indexOf('a'));//字符a第一次出现的index
        System.out.println("str.indexOf(\"ba\"): " + str.indexOf("ba"));//字符串"ab"第一次出现的index
        System.out.println("str.lastIndexOf('a'): " + str.lastIndexOf('a'));//字符a最后一次出现的index
        System.out.println("str.lastIndexOf(\"ba\"): " + str.lastIndexOf("ba"));//字符串"ab"最后一次出现的index
        System.out.println("str.IndexOf('('): " + str.lastIndexOf('('));//字符串不包含此字符则返回-1
        System.out.println("str.IndexOf(\"()\"): " + str.lastIndexOf("()"));//字符串不包含此子字符串则返回-1
        System.out.println();

        String str2 = "ab\nCDab";
        System.out.println("str.toUpperCase(): " + str.toUpperCase());
        System.out.println("str.toUpperCase(): " + str.toLowerCase());
        System.out.println();

        System.out.println("str2.startsWith(\"ab\"): " + str2.startsWith("ab"));
        System.out.println("str2.endsWith(\"ab\"): " + str2.endsWith("ab"));
        System.out.println();

        System.out.println("str2.contains(\"\\n\"): " + str2.contains("\n"));
        System.out.println("str2.contains(\"ab\")： " + str2.contains("ab"));
        System.out.println();

        //trim()去除首尾空白字符,空白字符包括" "，\t，\n, \r
        String str3 = "\tabc\t";
        System.out.println("head" + str3 + "tail");
        System.out.println("head" + str3.trim() + "tail");//这里实际并没有改变" abc\t"内容，而是创建了一个新的String对象

        System.out.println();
        String str4 = "abc\r";
        System.out.println(str4.trim() + "tail");

    }



    /**
     * replace的参数是char和CharSequence，即可以支持字符的替换，也支持字符串的替换并且是全部替换
     * 关于字符串替换replaceAll与replace()替换字符串的效果是一样，都是全部替换，但是replaceAll()支持正则表达式的替换
     */
    @Test
    public void test5() {
        String str = "11aaabbCCDDaa22";

        //新字符替换全部的旧字符
        System.out.println("str.replace('a', 'A'): " + str.replace('a', 'A'));

        //新字符串替换全部旧字符串
        System.out.println("str.replace(\"aa\", \"AA\"): " + str.replace("aa", "AA"));//String replace(CharSequence target, CharSequence replacement)，其中String implemwnt CharSequence

        //新字符串替换全部旧字符串
        System.out.println("str.replaceAll(\"aa\", \"AA\"): " + str.replaceAll("aa", "AA"));//String replaceAll(String regex, String replacement)


        System.out.println("str.replaceAll(\"\\\\d\", \"*\"): " + str.replaceAll("\\d", "*")); //把一个字符串所有的数字字符都换成星号; 正则表达式中\d代表的意思是匹配数字
        System.out.println("str.replaceAll(\"\\\\w\", \"*\"): " + str.replaceAll("\\w", "#")); //把一个字符串所有的字母及数字字符都换成星号; 正则表达式中\w代表的意思是匹配大小写字母数字和下划线 相当于([0-9a-zA-Z])
    }



    @Test
    public void test6() {
        String str = "Z-a-bcde ";
        String[] split = str.split("-");
        System.out.println(str.split("-")[0]);
        System.out.println(str.split("-")[1]);
        System.out.println(str.split("-")[2]);
        System.out.println(Arrays.toString(split));
        System.out.println();


        //split with dot
        String str2 = "C:\\Users\\EPANHAI\\Documents\\git\\myproject\\JavaDemo\\pom.xml";
        String[] split1 = str2.split(".");//It doesn't work
        System.out.println(Arrays.toString(split1));
        System.out.println();

        //"." is a special character in java regex engine, so you have to use "\\." to escape this character:
        String[] split2 = str2.split("\\.");
        System.out.println(Arrays.toString(split2));
        System.out.println();

        //use "\\|" to escape this character:
        String str3 = "a|b";
        String[] split3 = str3.split("\\|");
        System.out.println(Arrays.toString(split3));
    }


    @Test
    public void test7() {
        System.out.println("abcdefg".substring(3));
        System.out.println("asdgmklrt".substring(1, 3));//substring(int beginIndex, int endIndex)     [beginIndex,endIndex)
    }


    /**
     * isEmpty()  字符串长度等于0，返回true; 否则返回false
     *
     */
    @Test
    public void test8() {
        //String str="" 是一个空串(str(存在栈内存)指向堆内存空间，但是堆空间值为空)，空串不是null
        //String str2=null 会对引用变量str(存在栈内存)赋值为null,但是不会开辟堆空间
        String str = "";
        String str2 = null;

        System.out.println("str.length(): " + str.length());
        System.out.println("str.isEmpty(): " + str.isEmpty());
        System.out.println("str == null: " + (str == null));

        System.out.println("str2 == null: " + (str2 == null));
        System.out.println("str2.isEmpty(): " + str2.isEmpty());//NPE
        System.out.println("str2.length(): " + str2.length());//NPE

    }



    /**
     * string.format(String format, Object... args)函数来生成具有特定格式的字符串, 函数的第一个参数是格式(formatstring),
     * 之后是对应格式中每个代号的各种数据,使得产生的长字符串可读性大大提高了
     * <p>
     * If there are more arguments than format specifiers, the extra arguments are ignored
     * 参数多余格式化控制符，多余的参数将会被忽略
     * <p>
     * %s - 接受一个字符串
     * %d - 接受整数类型（十进制）
     * %c - 接受字符类型（十进制）
     */
    @Test
    public void test9() {

        //两个%s可以将后面的两个参数格式化(%s和后面的参数一一对应)
        String out = String.format("-D%s=%s", "name", "ocean");
        System.out.println(out);

        String out4 = String.format("I hope %s"+" good "+"%s", "ocean", "luck");
        System.out.println(out4);

        //多余的参数将会被忽略
        String out2 = String.format("name=%s", "ocean", "qq");
        System.out.println(out2);

        //三个%s可以将后面的三个参数格式化(%s和后面的参数一一对应)
        String out3 = String.format("I hope %s %s %s", "ocean", "good", "luck");
        System.out.println(out3);



        String out5 = String.format("Hi,%s %s %s", "小超", "是个", "大帅哥");
        System.out.println(out5);


        String out6 = String.format("字母c的大写是：%c", 'C');
        System.out.printf(out6);
    }


    /**
     * String<--->数组相互转换</>
     */
    @Test
    public void test10() {
        String str = "goodluck海阳";

        //String转成char数组,字符串内部是通过一个char[]数组表示
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));
        //char数组转成String
        System.out.println(new String(chars));
        System.out.println();

        //String转成byte数组,本质是对字符串进行编码，就是把每个字符转成对应的编号(二进制/十进制。。。)
        byte[] bytes = str.getBytes();//中文字符占用空间要超过一个字节
        System.out.println(Arrays.toString(bytes));
        //byte数组转成String， 本质是解码还原字符串
        System.out.println(new String(bytes));

        //java只支持字符串和字符/字节数组的相互转换
        int[] a = {1, 2, 3};
        System.out.println(Arrays.toString(a));
    }



    /**
     * 其他类型====>String类型:
     *
     * 1 String.valueOf()
     * 2 追加空串"",此时+是连接符
     * 3 引用类型 toString()
     */
    @Test
    public void test3x() {

        //String valueOf(Object obj){ return (obj == null) ? "null" : obj.toString();}
        //int、double、boolean、char、float、long、Object类型数据转换成String
        System.out.println(String.valueOf(12.0f));
        System.out.println(String.valueOf('c'));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(new Object()));

        System.out.println(123+"");//ctrl+点击println会发现println接受的字符串类型变量
    }


    /**
     * 字符串转换为其他基本类型
     */
    @Test
    public void test12() {

        //String转成int
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换,255
        System.out.println(n1);
        System.out.println(n2);
        System.out.println();



    }





    /**
     * A thread-safe, mutable sequence of characters
     */
    @Test
    public void test13() {
        StringBuffer sb = new StringBuffer();
        sb.append("123").append("abc");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

    /**
     *  A mutable sequence of characters
     *  可变 高效
     */
    @Test
    public void test13_2() {
        StringBuilder sb = new StringBuilder();
        sb.append("abc").append("123");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

    @Test
    public void test13_3() {
        StringBuilder sb = new StringBuilder();
        StringBuffer s = new StringBuffer();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            sb.append(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("timeBuilder=" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s.append(i);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("timeBuffer=" + (end2 - start2));
    }

}
