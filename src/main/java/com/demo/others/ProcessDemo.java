package com.demo.others;

import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ProcessBuilder类是Java 1.5在java.lang中新添加的一个新类，此类用于创建操作系统进程
 * new ProcessBuilder(CountDownLatchcommand).start()相当于开启了一个新的子进程
 */

public class ProcessDemo {
    public static void main(String[] args) throws IOException {

        Process process;
        List<String> command = new ArrayList<String>();
        command.add( "cmd.exe" );
        command.add( "/c" );
        command.add( "ipconfig -all" );

        ProcessBuilder pb = new ProcessBuilder(command);
        process = pb.redirectErrorStream(true).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
            String line = null;

            while ( ( line = bufferedReader.readLine() ) != null ) {
                System.out.println( line );
            }
        }
        catch ( Throwable t ) {
        }
        finally {
            try {
                bufferedReader.close();
            }
            catch ( IOException e ) {
            }
        }
    }

    @Test
    public void test() throws Exception{
        List<String> paramList = new ArrayList<>();
        //使用 cmd 命令 ping 远程主机
        //第一个参数必须是可执行程序,cmd也是一个可执行程序，位于 C:/Windows/System32目录下
        paramList.add("cmd");
        paramList.add("/c");
        paramList.add("ping www.taobao.com");//也可以是ip，如 paramList.add("ping 114.114.114.114");

        /** 创建ProcessBuilder对象，设置指令列表*/
        ProcessBuilder processBuilder = new ProcessBuilder(paramList);

        //返回此流程构建器的标准输出目标,意思是将来输出信息全部放在这个目标中
        processBuilder = processBuilder.redirectOutput(new File("out.txt"));
        Process process = processBuilder.start();//启动进程构建器

        System.out.println("process.isAlive(): "+process.isAlive());
        System.out.println("process==null: "+process==null);
        process.destroy();
        System.out.println("process.isAlive(): "+process.isAlive());
        System.out.println("process==null: "+process==null);


        /*while (process.isAlive()){
        System.out.println("process.isAlive()");
        Thread.sleep(1000);
        }*/
    }


    @Test
    public void test2() throws Exception{
        List<String> command=new ArrayList<>();
        //command= Arrays.asList("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\lync.exe");//skype
        command= Arrays.asList("C:\\Program Files (x86)\\Netease\\CloudMusic\\cloudmusic.exe");//wangyiyun

        ProcessBuilder processBuilder=new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true).start();
    }


    @Test
    public void tests2() throws Exception{
        List<String> command=new ArrayList<>();
        command= Arrays.asList("C:\\Windows\\System32\\calc.exe");//wangyiyun

        ProcessBuilder processBuilder=new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true).start();
    }

    @Test
    public void tests3() throws Exception{
        List<String> command=new ArrayList<>();
        command= Arrays.asList("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.EXE","C:\\Users\\epanhai\\Desktop\\a.docx");//wangyiyun

        ProcessBuilder processBuilder=new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true).start();
    }


}
