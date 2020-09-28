package com.demo.exception.try_catch_finally.finallyDemo;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 *
 * 在try(xxx)语句中自动关闭声明的资源，不再需要在finally里手动关闭资源
 * 关闭资源的对象必须实现java.lang.AutoCloseable或者java.io.Closeable接口, java7之后的几乎所有的资源都是先了这连个接口
 *
 * try()括号里可以声明多个资源对象，形如：
 * try(
 *    InputStream is = new FileInputStream("...");
 *    OutputStream os = new FileOutputStream("...");
 *    )
 *
 * 该语法的出现，简化了对于try语句块中必须要关闭的资源的写法，不需要再在finally块内显示关闭，
 * 但try()括号内的资源需要符合其要求(实现了java.lang.AutoCloseable或者java.io.Closeable接口)
 *
 * Java的语法越来越追求简洁，如此try语句以及函数式编程等方向的局部改动，希望后面越来越好用
 *
 */
public class FinallyDemo2 {


    /**
     * finally中关闭资源
     */
    @Test
    public void test() {
        String path = "none";
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void test2() {

        String path = "none";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * You may declare one or more resources in a try-with-resources statement. The following example retrieves the names of
     * the files packaged in the zip file zipFileName and creates a text file that contains the names of these files:
     *
     * @param zipFileName
     * @param outputFileName
     * @throws java.io.IOException
     */
    @Test
    public void test2(String zipFileName,
                      String outputFileName) throws java.io.IOException {

        java.nio.charset.Charset charset =
                java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
                java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (
                java.util.zip.ZipFile zf =
                        new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer =
                        java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries =
                 zf.entries(); entries.hasMoreElements(); ) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry) entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }

    }


}
