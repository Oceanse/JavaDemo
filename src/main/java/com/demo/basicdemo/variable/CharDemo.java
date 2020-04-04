package com.demo.basicdemo.variable;

import org.testng.annotations.Test;


/**
 * 字符集可以理解成各种字符和对应编号的关系对照表，编号可以是十进制(0~65535), 二进制(16位0~16位1), unicode码('\u0000'~'\uffff')
 * Java使用十六位的Unicode字符集作为编码方式，可以一共支持65536种字符
 *
 * 字符型值三种表示形式：
 * 1 单个符号 'A', '1' '@'
 * 2 转义字符\+被转义字符 '\t', '\n', '\\'， '\"', '\''
 * 3 Unicode值： \uaaaa 其中aaaa代表十六进制整数，取值范围： '\u0000'~'\uffff'
 * 这里四位十六进制整数相当于16位二进制整数，以一共支持65536种字符,其中前256个字符('\u0000'~'\u00ff')和ASCII中的字符完全相同
 *
 *
 *计算机底层保存的是字符的编号(unicode码)，相当于十六位无符号整数，可表示0~65535，因此它可以作为整型值参与加减乘除以及大小比较，
 *实际上都是运用字符对应的编码参与运算
 *
 *
 * 中英翻译：
 * 转义字符：escape character
 * \u1234: Unicode escape sequence
 * 即使在源代码注释中使用了非法unicode转义字符序列，编译器也会报错
 * if you have an illegal Unicode escape sequence in your source, it will be flagged as an error even though it's inside a comment
 *
 */
public class CharDemo {


    /**
     * 字符表示形式
     */
    @Test
    public void test(){

        //单个符号作为字符值
        char c='$';

        //转义字符\+被转义字符作为字符值
        char c1='\t';

        //unicode码作为字符值
        char c2='\u12ab';
    }


    /**
     * 字符参与四则运算 大小比较，本质是字符编号参与运算
     */
    @Test
    public void test1(){
        char c='a';
        char c2='b';
        System.out.println(c);
        System.out.println((int)c);
        System.out.println(c+1);//c先转成int再参与计算
        System.out.println(c+1.1);//c先转成int再转成float再参与计算
        System.out.println(c>c2);
    }


    /**
     * int类型直接赋值给char,个人理解系统会自动把int整数转成char字符然后赋值给变量
     */
    @Test
    public void test2(){
        char c=97;
        System.out.println(c);
       // char c2=65536;  超过char编号范围(0~65535)

        int i='中';//把字符'中'的编号(unicode码)赋值给整型变量
        System.out.println(i);

    }





    // 反斜杠\单独存在时是具有转义功能的转移字符
    // 反斜杠出现在特殊字符之前，会将特殊字符转成普通字符，或者说会和后面的特殊字符组成一个新意义的字符
    // 两个反斜杠\\一起出现，那么第一个\是转义字符，会把第二个\转义成不具备转义功能的普通反斜杠字符，两个字符组成一个新意义的字符：普通反斜杠

    @Test
    public void testx() {
        System.out.println('\'');
        System.out.println('\"');
        System.out.println(".");
        System.out.println('"');
        System.out.println("\'hello world\'");
        System.out.println("\"hello world\"");

        //char c='\';   这里编译器会把\和后面的'一起配对，把后面的'转义成没有任何特殊含义的的普通单引号字符，导致整个字符好像少了一个结束单引号
        System.out.println('\\'); //这里第一个\是转义字符，会把第二个\转义成不具备转义功能的普通反斜杠字符,也就是\单独存在时是具有转移功能的反斜杠；java中两个\\代表一个普通反斜杠字符

    }


    /**
     * "\n"和'\n'是一样的,都表示一个回车符.不同得是"\n"的引号中还可以继续加别的内容,比如"\n132455"
     * 而'\n'单引号内不能再加别的内容,原因是单引号内只能有一个字符;而'\n'单引号内不能再加别的内容,原因是单引号内只能有一个字符
     * \为转义字符，转变了后面字符n的原义，两个符号组成了一个新的字符，代表换行
     * 另外 + 碰上字符串时候表示连接符，而不是运算符
     */

    @Test
    public void test2x() {

        System.out.println("1==========================");
        System.out.println("dd" + '\n' + "dd");
        System.out.println("ee" + "\n" + "ee");
        System.out.println("aa" + "\t" + "aa");//"\t和'\t'都表示一个制表符，"\n"和'\n'都是换行符
        System.out.println("aa" + '\t' + "aa");//println后面会输出一个换行

        System.out.println("2==========================");
        System.out.println('d' + '\t' + 'd');//三个字符用+连接，这里的+是运算符
        System.out.println('e' + "\t" + 'e');//"\t"是字符串，所以这里的+是连接符
        System.out.println(12 + "\n");//int+字符串，这里+是连接符
        System.out.println(12 + '\n');//int+char,首先转char换成int,再相加，这里+是运算符

        System.out.println((int) '\n');
        System.out.println((int) '\t');
    }

    public void test3() {
        //char c ='';
        //char c2=''';
    }

}
