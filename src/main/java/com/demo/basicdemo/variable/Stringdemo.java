package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Stringdemo {
    /*常量对象：字符串常量对象是用双引号括起的字符序列
    字符串的字符使用Unicode字符编码，一个字符占两个字节
    String是一个final类，代表不可变的字符序列
    一个字符串对象一旦被配置，其内容是不可变的。
    底层使用char[]存放
    */

    public static void main(String[] args) {
        String str="asadvjbsASDFdjd a ";
        String str2="";//空字符串 String str2=" "是空格字符串
        String str3=null;
        String str4="Z-a-bcde ";

        System.out.println("1================================");
        //String转成数组
        char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();
        String[] split = str4.split("-");
        String s = str4.split("-")[0];
        String s1 = str4.split("-")[1];
        String s2 = str4.split("-")[2];

        //数组转成String,
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(split));
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);


        System.out.println(new String(chars));
        System.out.println(new String(bytes));
        int[] a={1,2,3};
        Arrays.toString(a); //不支持 new String(int[] arr)


        System.out.println();
        System.out.println("2================================");
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.startsWith("asa"));
        System.out.println(str.endsWith("a "));

        //大小写转换
        System.out.println("3======================");
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        String ss="as\nd\n"; //这里的\n是一个字符
        System.out.println(ss.replace('\n','w'));
        String ss2="ababab";
        System.out.println(ss2.replace("a", "c"));

        System.out.println("4======================");
        //判断字符或者字符串首次出现的index,没有返回-1
        System.out.println("str.indexOf('a'):   "+str.indexOf('a'));
        System.out.println("str.indexOf('sa'):   "+str.indexOf("sa"));


        //str2="" 是一个空串(str指向堆内存空间，但是堆空间值为空)，空串不是null
        //String str=null会对引用变量str(存在栈内存)赋值为null,但是不会开辟堆空间
        System.out.println("5======================");
        System.out.println("".isEmpty());//Empty是判断字符串是否为空串
        System.out.println("" == null);//str==null或str!=null
        System.out.println(str);
        System.out.println(str.trim());
        System.out.println("6======================");
        System.out.println("asdgmklrt".substring(3));
        System.out.println("asdgmklrt".substring(1,3));//substring(int beginIndex, int endIndex)     [beginIndex,endIndex)
        System.out.println();
    }

    @Test
    public void test(){
        System.out.println("1===============");
        String str1="jcat";
        String str2="jcat";
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);

        System.out.println("2===============");
        String str3="jcats";
        String str4=new String("jcats");
        System.out.println(str3.equals(str4));
        System.out.println(str3==str4);

        System.out.println("3===============");
        String str5="abc";
        String str6="def";
        String str7="abc"+"def";
        String str8="abcdef";
        System.out.println(str7.equals(str8));
        System.out.println(str7==str8);

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
    public void test2(){
        StringBuffer sb=new StringBuffer();
        sb.append("123").append("abc");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

    @Test
    public void test3(){
        StringBuilder sb=new StringBuilder();
        sb.append("abc").append("123");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

    @Test
    public void test4(){
        StringBuilder sb=new StringBuilder();
        StringBuffer s=new StringBuffer();
        long start1=System.currentTimeMillis();
        for(int i = 0; i < 20000; i++) {
            sb.append(i);
        }
        long end1=System.currentTimeMillis();
        long timeBuilder=end1-start1;
        System.out.println("timeBuilder="+timeBuilder);

        long start2=System.currentTimeMillis();
        for(int i = 0; i < 20000; i++) {
            s.append(i);
        }
        long end2=System.currentTimeMillis();
        long timeBuffer=end2-start2;

        System.out.println("timeBuffer="+timeBuffer);
    }

    @Test
    public void test5() {

        //  \使得 " 不再是双引号的一部分，而是单纯的符号
        String str="\"abc\"";
        System.out.println(str);

        //如果我们想输出 ",需要借助转义
        //String str2=""";  编译不通过
        String str2="\"";
        System.out.println(str2);

            }

    @Test
    public void test6() {

        //contains()方法判断字符串str中是否有子字符串。如果有则返回true，如果没有则返回false
        String str = "Hello World !";
        System.out.println(str.contains("world"));
        System.out.println(str.contains("World"));
        System.out.println(str.contains("o W"));
        System.out.println(str.contains("ddd"));

    }


    /**
     * string.format(String format, Object... args)函数来生成具有特定格式的字符串, 函数的第一个参数是格式(formatstring),
     * 之后是对应格式中每个代号的各种数据,使得产生的长字符串可读性大大提高了
     *
     * If there are more arguments than format specifiers, the extra arguments are ignored
     * 参数多余格式化控制符，多余的参数将会被忽略
     *
     * %s - 接受一个字符串
     * %d - 接受整数类型（十进制）
     * %c - 接受字符类型（十进制）
     */
    @Test
    public void test7() {

        //两个%s可以将后面的两个参数格式化(%s和后面的参数一一对应)
        String out = String.format("-D%s=%s", "name", "ocean");
        System.out.println(out);


        //多余的参数将会被忽略
        String out2 = String.format("name=%s","ocean","qq");
        System.out.println(out2);

        String out3 = String.format("I hope %s %s %s","ocean","good","luck");
        System.out.println(out3);

        String out4 = String.format("I hope %s,%s,%s","ocean","good","luck");
        System.out.println(out4);

        String out5=String.format("Hi,%s %s %s", "小超","是个","大帅哥");
        System.out.println(out5);


        String out6=String.format("字母c的大写是：%c", 'C');
        System.out.printf(out6);

    }



}
