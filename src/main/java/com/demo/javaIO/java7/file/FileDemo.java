package com.demo.javaIO.java7.file;

import org.testng.annotations.Test;

import java.io.File;


/**
 * java.io.File类：文件和目录路径名的抽象表示形式,内存里面的一个磁盘文件或者目录的引用
 * 一个File对象代表硬盘中实际存在的一个文件或者目录(可能存在或者不存在)。File类构造方法不
 * 会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。
 * File 能新建、删除、重命名文件和目录，但 File 不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流。
 */
public class FileDemo {


    /**
     * File对象的创建
     * @param args
     */
    public static void main(String[] args) {

        //通过将给定的 文件相对路径名 来创建新的 File实例。
        File file = new File("testResource\\out.txt");//相对路径一定处在工程根目录之下

        //通过将给定的 文件绝对路径名 来创建新的 File实例。
        File file2 = new File("C:\\Users\\EPANHAI\\Documents\\git\\JavaDemo\\testResource\\out.txt");//相对路径一定处在工程根目录之下

        //通过将给定的 目录相对路径名 来创建新的 File实例。
        File file3 = new File("src\\main\\java");

        //通过将给定的 目录绝对路径名 来创建新的 File实例。
        File file4 = new File("C:\\Users\\EPANHAI\\Documents\\git\\JavaDemo\\testResource");


        //public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
        File file5 = new File("C:\\Users\\EPANHAI\\Documents\\git", "JavaDemo\\src\\main\\java\\io\\javaIO\\java7\\file\\FileTest.java");

        //public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
        File file6 = new File(file3, "io\\javaIO\\java7\\file\\FileTest.java");

    }

    //相对路径-文件
    @Test
    public void test() {
         // windows操作系统中，文件路径的分隔符是反斜杠（“\”）
        //  在linux操作系统中，文件的分隔符是斜杠（“/”）
        File f = new File("testResource\\dir\\out.txt");//相对路径一定处在工程根目录之下
        System.out.println(f.getName());//路径末级文件名
        System.out.println(f.getAbsolutePath());//绝对路径
        System.out.println(f.getParent());//路径末级文件名之上的全部路径
        System.out.println(f.exists());
        System.out.println(f.isDirectory());//f不存在，非目录
        System.out.println(f.isFile());//f不存在，非文件
        System.out.println(f.isAbsolute());
        System.out.println(f.length());//获取文件大小
    }


    //绝对路径-文件
    @Test
    public void test2() {
        File f = new File("C:\\Users\\EPANHAI\\Documents\\git\\JavaDemo\\testResource\\out.txt");//相对路径一定处在工程根目录之下
        System.out.println(f.getName());//路径末级文件名
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());//路径末级文件名之上的全部路径
        System.out.println(f.length());//获取文件大小
        System.out.println(f.exists());
        System.out.println(f.isAbsolute());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
    }

    //绝对路径-目录
    @Test
    public void test3() {
        File f = new File("C:\\Users\\epanhai\\git");
        System.out.println(f.getName());//路径末级文件名
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());//路径末级文件名之上的全部路径
        System.out.println(f.length());//
        System.out.println(f.exists());
        System.out.println(f.isAbsolute());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
    }

    //相对路径-目录
    @Test
    public void test4() {
        File f = new File("src\\main\\java");
        System.out.println(f.getName());//路径末级文件名
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());//路径末级文件名之上的全部路径
        System.out.println(f.length());//
        System.out.println(f.exists());
        System.out.println(f.isAbsolute());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());

    }


    @Test
    public void test5() {
        //  windows系统下分隔符是\,然后前面加上转义字符\,就变成了\\
        String separator = File.separator;//返回分隔符的String形式
        char separatorChar = File.separatorChar;//返回分隔符char形式
        System.out.println(separator);
        System.out.println(separatorChar);

        String path = "C:" + File.separator + "Users";
        String path2 = "C:" + File.separatorChar + "Users";
        System.out.println(new File(path).exists());
        System.out.println(new File(path2).exists());

    }


}
