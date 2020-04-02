package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

public class Char {

    // 反斜杠\单独存在时是具有转义功能的转移字符
    // 反斜杠出现在特殊字符之前，会将特殊字符转成普通字符，或者说会和后面的特殊字符组成一个新意义的字符
    // 两个反斜杠\\一起出现，那么第一个\是转义字符，会把第二个\转义成不具备转义功能的普通反斜杠字符，两个字符组成一个新意义的字符：普通反斜杠

    @Test
    public void test() {
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
    public void test2() {

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
