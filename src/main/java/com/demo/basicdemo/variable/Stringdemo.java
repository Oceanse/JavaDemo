package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 常量对象：字符串常量对象是用双引号括起的字符序列
 * 字符串的字符使用Unicode字符编码，一个字符占两个字节
 * String是一个final类，代表不可变的字符序列
 * 一个字符串对象一旦被配置，其内容是不可变的。
 * 底层使用char[]存放
 */
public class Stringdemo {

    @Test
    public void test() {
        String str = "ab CDab";
        System.out.println("str.length(): " + str.length());

        System.out.println("str.charAt(0): " + str.charAt(0));
        System.out.println("str.charAt(2): " + str.charAt(2));

        System.out.println("str.indexOf('a'): " + str.indexOf('a'));//字符a第一次出现的index
        System.out.println("str.indexOf(\"ab\"): " + str.indexOf("ab"));//字符串"ab"第一次出现的index
        System.out.println("str.lastIndexOf('a'): " + str.lastIndexOf('a'));//字符a最后一次出现的index
        System.out.println("str.lastIndexOf(\"ab\"): " + str.lastIndexOf("ab"));//字符串"ab"最后一次出现的index
        System.out.println("str.IndexOf('x'): " + str.lastIndexOf('x'));//字符串不包含此字符则返回-1


        String str2 = "ab\nCDab";
        System.out.println("str.toUpperCase(): " + str.toUpperCase());
        System.out.println("str.toUpperCase(): " + str.toLowerCase());

        System.out.println("str2.startsWith(\"ab\"): "+str2.startsWith("ab"));
        System.out.println("str2.endsWith(\"ab\"): "+str2.endsWith("ab"));

        System.out.println("str2.contains(\"\\n\"): "+str2.contains("\n"));
        System.out.println("str2.contains(\"ab\")： "+str2.contains("ab"));

        String str3=" abc ";
        System.out.println("head"+str3+"tail");
        System.out.println("head"+str3.trim()+"tail");
    }


    /**
     * replace的参数是char和CharSequence，即可以支持字符的替换，也支持字符串的替换并且是全部替换
     * 关于字符串替换replaceAll与replace()替换字符串的效果是一样，都是全部替换，但是replaceAll()支持正则表达式的替换
     */
    @Test
    public void test2() {
        String str = "11aabbCCDDaa22";

        //新字符替换全部的旧字符
        System.out.println("str.replace('a', 'A'): "+str.replace('a', 'A'));

        //新字符串替换全部旧字符串
        System.out.println("str.replace(\"aa\", \"AA\"): "+str.replace("aa", "AA"));//String replace(CharSequence target, CharSequence replacement)，其中String implemwnt CharSequence

        //新字符串替换全部旧字符串
        System.out.println("str.replaceAll(\"aa\", \"AA\"): "+str.replaceAll("aa", "AA"));//String replaceAll(String regex, String replacement)

        //把一个字符串所有的数字字符都换成星号;
        System.out.println("str.replaceAll(\"\\\\d\", \"*\"): "+str.replaceAll("\\d", "*"));
    }


    @Test
    public void test3() {
        String str = "Z-a-bcde ";
        String[] split = str.split("-");
        System.out.println(str.split("-")[0]);
        System.out.println(str.split("-")[1]);
        System.out.println(str.split("")[2]);
        System.out.println(Arrays.toString(split));


        //split with dot
        String str2="C:\\Users\\EPANHAI\\Documents\\git\\myproject\\JavaDemo\\pom.xml";
        String[] split1 = str2.split(".");//It doesn't work
        System.out.println(Arrays.toString(split1));

        //"." is a special character in java regex engine, so you have to use "\\." to escape this character:
        String[] split2 = str2.split("\\.");
        System.out.println(Arrays.toString(split2));
    }



    @Test
    public void test4(){
        System.out.println("abcdefg".substring(3));
        System.out.println("asdgmklrt".substring(1, 3));//substring(int beginIndex, int endIndex)     [beginIndex,endIndex)
    }


    @Test
    public void test5(){
        //String str="" 是一个空串(str(存在栈内存)指向堆内存空间，但是堆空间值为空)，空串不是null
        //String str2=null 会对引用变量str(存在栈内存)赋值为null,但是不会开辟堆空间
        String str = "";
        String str2 = null;

        System.out.println("str.length(): "+str.length());
        System.out.println("str.isEmpty(): "+str.isEmpty());
        System.out.println("str == null: "+(str == null));

        System.out.println("str2 == null: "+(str2 == null));
        System.out.println("str2.isEmpty(): "+str2.isEmpty());//NPE
    }



    @Test
    public void test6(){

        String str = "abc";

        //String转成char数组和byte数组
        char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();

        //char数组和byte数组转成String
        System.out.println(new String(chars));
        System.out.println(new String(bytes));


        int[] a = {1, 2, 3};
        Arrays.toString(a); //不支持 new String(int[] arr)

    }


    @Test
    public void test7() {
        System.out.println("1===============");
        String str1 = "jcat";
        String str2 = "jcat";
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);

        System.out.println("2===============");
        String str3 = "jcats";
        String str4 = new String("jcats");
        System.out.println(str3.equals(str4));
        System.out.println(str3 == str4);

        System.out.println("3===============");
        String str5 = "abc";
        String str6 = "def";
        String str7 = "abc" + "def";
        String str8 = "abcdef";
        System.out.println(str7.equals(str8));
        System.out.println(str7 == str8);

        //待理解
        /*System.out.println("4===============");
        String str11="abc";
        String str22="def";
        String str33=str11+str22;
        String str44="abc"+"def";
        System.out.println(str33.equals(str44));
        System.out.println(str33==str44);*/
    }

    @Test
    public void test8() {
        StringBuffer sb = new StringBuffer();
        sb.append("123").append("abc");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

    @Test
    public void test9() {
        StringBuilder sb = new StringBuilder();
        sb.append("abc").append("123");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

    @Test
    public void test10() {
        StringBuilder sb = new StringBuilder();
        StringBuffer s = new StringBuffer();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            sb.append(i);
        }
        long end1 = System.currentTimeMillis();
        long timeBuilder = end1 - start1;
        System.out.println("timeBuilder=" + timeBuilder);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s.append(i);
        }
        long end2 = System.currentTimeMillis();
        long timeBuffer = end2 - start2;

        System.out.println("timeBuffer=" + timeBuffer);
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
    public void testx7() {

        //两个%s可以将后面的两个参数格式化(%s和后面的参数一一对应)
        String out = String.format("-D%s=%s", "name", "ocean");
        System.out.println(out);


        //多余的参数将会被忽略
        String out2 = String.format("name=%s", "ocean", "qq");
        System.out.println(out2);

        String out3 = String.format("I hope %s %s %s", "ocean", "good", "luck");
        System.out.println(out3);

        String out4 = String.format("I hope %s,%s,%s", "ocean", "good", "luck");
        System.out.println(out4);

        String out5 = String.format("Hi,%s %s %s", "小超", "是个", "大帅哥");
        System.out.println(out5);


        String out6 = String.format("字母c的大写是：%c", 'C');
        System.out.printf(out6);

    }


}
