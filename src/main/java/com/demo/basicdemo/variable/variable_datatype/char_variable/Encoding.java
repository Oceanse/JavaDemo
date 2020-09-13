package com.demo.basicdemo.variable.variable_datatype.char_variable;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Java虚拟机规范中明确说明了java的char类型使用的编码方案是UTF-16
 * UTF-16 的编码长度要么是 2 个字节（U+0000 到 U+FFFF），要么是 4 个字节（U+010000 到 U+10FFFF）;
 *
 * Java中常见的char基本位于unicode表的BMP平面，码点(编号)范围是从十进制：0~65535；十六进制：0x0000~0xFFFF； 二进制16个0~16个1
 * 所以char字符的编码统一使用unicode码点(编号)的16位二进制(不足用0补齐)作为存储编码。
 * 简单来说就是字符编号就是其存储编码.
 * char强制转化为int数值就是其对应的十进制编号转化成二进制后高位补零。
 *
 *
 * 编译时：
 * javac -encoding utf-8 xxx.java设置javac编译器读取xxx.java文件时使用的编码方式   .java源文件-----(编码)----->二进制编码存储----(解码)---->.java源文件
 * <p>
 * 运行时：
 * System.getProperty(“file.encoding”)是java程序运行时(加载解释class文件)与操作系统打交道时使用的编码方式，可以通过java -Dfile.encoding=xxx test 进行设置！
 * .class文件二进制存储-------(解码)------>.class文件
 */
public class Encoding {


    /**
     * java采用unicode编码(utf-16)，所以方法名可以是中文
     */
    @Test
    public void 测试() {
        System.out.println(System.getProperty("file.encoding"));//这个属性是启动jvm时可以设置的，默认是操作系统的编码方式
        System.out.println(Charset.defaultCharset());
        System.out.println(Character.SIZE);

    }


    /**
     * 信息在计算机网络中传输是以字节(8位二进制)的形式。那么如何变为字节？这就是编码的过程。
     * 计算机接收了这个编码，如何让使用者认识呢？那必须要将字节转换为人所识别的字符串形式，这就是解码的过程。
     * <p>
     * 编码：将字符串转换为 byte 数组
     * 解码：把 byte 数组转换为 字符串
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str = new String("Aa中国");

        //编码操作 GBK编码
        byte[] byteArray = str.getBytes("GBK");
        System.out.println(Arrays.toString(byteArray));//[65, 97, -42, -48, -71, -6]

        //解码操作 编码和解码格式不一致：ASCII解码
        //注意编码的字符集和解码的字符集格式必须一致（是其扩展字符集也可以），否则会乱码
        String str2 = new String(byteArray, "ASCII");
        System.out.println(str2);//乱码

        //解码操作 编码和解码格式一致：GBK解码
        //注意编码的字符集和解码的字符集格式必须一致（是其扩展字符集也可以），否则会乱码
        String str3 = new String(byteArray, "GBK");
        System.out.println(str3);
    }


    @Test
    public void test2x() throws UnsupportedEncodingException {

        //Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.
        String str = new String("中国");
        byte[] array = str.getBytes();
        System.out.println(Arrays.toString(array));//[65, 97]

        //Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array.
        String str2 = new String("Aa");
        byte[] strASCII = str2.getBytes("ASCII");
        System.out.println(Arrays.toString(strASCII));//[65, 97]

        String str3 = new String("中国");
        byte[] strASCII2 = str3.getBytes("ASCII");
        System.out.println(Arrays.toString(strASCII2));

        String str4 = new String("中国");
        byte[] strASCII3 = str4.getBytes("GBK");
        System.out.println(Arrays.toString(strASCII3));//[65, 97]
    }


}
