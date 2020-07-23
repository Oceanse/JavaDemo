package com.demo.net;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetAddressDemo {
    public static void main(String[] args)throws Exception {
        //一个InetAddress对象代表一个ip Address
        InetAddress inet = InetAddress.getByName("www.baidu.com");
        System.out.println(inet);
        System.out.println(inet.getHostAddress());//返回百度服务器的IP地址
        System.out.println(inet.getHostName());//域名


        inet=InetAddress.getByName("180.101.49.11");
        System.out.println(inet.getHostAddress());
        System.out.println(inet.getHostName());//如果ip地址存在，并且DNS给你解析就会输出,不给你解析就会返回这个IP本身；
    }


    @Test
    public void test() throws IOException {
        InetAddress inet = InetAddress.getByName("localhost");
        System.out.println(inet);
        System.out.println(inet.getHostAddress());//返回百度服务器的IP地址
        System.out.println(inet.getHostName());//域名
    }

}
