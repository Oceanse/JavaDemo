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
        command.add("cmd.exe");
        command.add("/c");
        command.add("ipconfig -all");

        ProcessBuilder pb = new ProcessBuilder(command);
        process = pb.redirectErrorStream(true).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Throwable t) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
    }

    @Test
    public void test() throws Exception {
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

        System.out.println("process.isAlive(): " + process.isAlive());
        System.out.println("process==null: " + process == null);
        process.destroy();
        System.out.println("process.isAlive(): " + process.isAlive());
        System.out.println("process==null: " + process == null);


        /*while (process.isAlive()){
        System.out.println("process.isAlive()");
        Thread.sleep(1000);
        }*/
    }


    @Test
    public void test2() throws Exception {
        List<String> command = new ArrayList<>();
        //command= Arrays.asList("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\lync.exe");//skype
        command = Arrays.asList("C:\\Program Files (x86)\\Netease\\CloudMusic\\cloudmusic.exe");//wangyiyun

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true).start();
    }


    @Test
    public void tests2() throws Exception {
        List<String> command = new ArrayList<>();
        command = Arrays.asList("C:\\Windows\\System32\\calc.exe");//wangyiyun

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true).start();
    }

    @Test
    public void tests3() throws Exception {
        List<String> command = new ArrayList<>();
        command = Arrays.asList("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.EXE", "C:\\Users\\epanhai\\Desktop\\a.docx");//wangyiyun

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true).start();
    }

    @Test
    public void tests4() throws Exception {
        //command= Arrays.asList("prom-plot -f cmd/prom-plot/metrics.yaml -offset 15m");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "C:\\Users\\epanhai\\Desktop\\GoDemo.exe");
        Process process = processBuilder.redirectErrorStream(true).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Throwable t) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
            System.out.println("process.exitValue()==========" + process.exitValue());
        }
    }


    @Test
    public void tests5() throws Exception {
        List<String> command = new ArrayList<>();
        //command= Arrays.asList("prom-plot -f cmd/prom-plot/metrics.yaml -offset 15m");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "C:\\Users\\epanhai\\Desktop\\prom-plot\\main.exe -f C:\\Users\\epanhai\\Desktop\\prom-plot\\cmd/prom-plot/metrics.yaml -offset 15m -addr http://192.168.56.102:9090");
        Process process = processBuilder.redirectErrorStream(true).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Throwable t) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
            process.waitFor();
            System.out.println("process.exitValue()==========" + process.exitValue());
        }
    }

    @Test
    public void test6() throws Exception {
        Integer port = 10086;
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process process = processBuilder.command("cmd.exe", "/c", "netstat -ano |findstr " + port).start();
        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String pid=null;
        /*  List：
         *   TCP    0.0.0.0:10086          0.0.0.0:0              LISTENING       32140
         *   TCP    127.0.0.1:10086        127.0.0.1:55873        ESTABLISHED     32140
         *    ...
         * */
        List<String> list = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
            list.add(line);
        }
        //判断是否存在指定端口
        if (list.size() == 0) {
            System.out.println("指定端口没有被使用！");
        } else {
            for (String str : list) {
                // str= TCP    0.0.0.0:10086          0.0.0.0:0              LISTENING       32140
                // ip=0.0.0.0:10086
                String ip = str.split(" +")[2];
                int beg = ip.lastIndexOf(':') + 1;
                int end = ip.length();
                Integer destport = Integer.parseInt(ip.substring(beg, end));
                if (destport.equals(port)) {
                    System.out.println(str.split(" +")[5]);
                    pid = str.split(" +")[5];
                    break;
                }
            }
        }
        if(pid ==null){
            System.out.println("没有对应端口没有被使用！");
        }else{
            //kill port
           // String  command ="cmd /c taskkill /pid "+port+" /F";
            try {
                processBuilder.command("cmd.exe", "/c", "taskkill /f /pid " + pid).start();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                System.out.println("以杀掉占用程序");
            }
        }


    }


}
