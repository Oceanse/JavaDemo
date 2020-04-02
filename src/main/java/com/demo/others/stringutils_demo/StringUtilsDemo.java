package com.demo.others.stringutils_demo;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 *
 * org.apache.commons.lang3.StringUtils;
 * StringUtils 方法的操作对象是 Java.lang.String 类型的对象，是 JDK 提供的 String 类型操作方法的补充，
 * 并且是 null 安全的(即如果输入参数 String 为 null 则不会抛出 NullPointerException ，而是做了相应处理，
 * 例如，如果输入为 null 则返回也是 null 等，具体可以查看源代码)。
 *
 */
public class StringUtilsDemo {

    /**
     * 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
     */
    @Test
    public void test(){
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("   "));
        System.out.println(StringUtils.isEmpty("\t"));
        System.out.println(StringUtils.isEmpty("\n"));


        String str="ocean";
        if(StringUtils.isNotEmpty(str)){
            System.out.println("good");
        }
    }


    /**
     *  判断某字符串是否为空或长度为0或由空白符(whitespace) 构成
     *  isNotBlank比isNotEmpty判断更为严格
     */

    @Test
    public void test2(){
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank("  "));
        System.out.println(StringUtils.isBlank("\t"));
        System.out.println(StringUtils.isBlank("\n"));
        System.out.println();

        String str="ocean";
        if(StringUtils.isNotBlank(str)){
            System.out.println("good");
        }
    }

    /**
     * 下面案例中String自带的trim()和StringUtils.trim效果相同，都是去掉字段穿首尾两端的空白或者换行
     */
    @Test
    public void test3(){

        String str=" bb ";
        System.out.println( "aa"+str+"cc");
        System.out.println( "aa"+str.trim()+"cc");
        System.out.println( "aa"+StringUtils.trim(str)+"cc");

        System.out.println();
        String str2="\tbb\t";
        System.out.println( "aa2"+str2+"cc2");
        System.out.println( "aa2"+str2.trim()+"cc2");
        System.out.println( "aa2"+StringUtils.trim(str2)+"cc2");

        System.out.println();
        String str3="\nbb\n";
        System.out.println( "aa3"+str3+"cc3");
        System.out.println( "aa3"+str3.trim()+"cc3");
        System.out.println( "aa3"+StringUtils.trim(str3)+"cc3");

        System.out.println();
        String str4=null;
        System.out.println(StringUtils.trim(null));//返回null
        //System.out.println(str4.trim());会报NPE


        System.out.println();
        String str5="";
        System.out.println( "aa5"+str5+"cc5");
        System.out.println( "aa5"+str5.trim()+"cc5");
        System.out.println( "aa5"+StringUtils.trim(str5)+"cc5");


        System.out.println();
        String str6=" ";
        System.out.println( "aa6"+str6+"cc6");
        System.out.println( "aa6"+str6.trim()+"cc6");
        System.out.println( "aa6"+StringUtils.trim(str6)+"cc6");
    }




}
