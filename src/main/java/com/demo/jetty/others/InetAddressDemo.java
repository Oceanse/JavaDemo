package com.demo.jetty.others;

import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args)throws Exception {
        //一个InetAddress对象代表一个ip Address
        InetAddress inet = InetAddress.getByName("www.baidi.com");
        System.out.println(inet);
        System.out.println(inet.getHostAddress());//返回百度服务器的IP地址
        System.out.println(inet.getHostName());//域名

        System.out.println("1===========================");
        System.out.println(inet.getLocalHost());
        System.out.println(inet.getLocalHost().getHostName());//输出计算机名
        System.out.println(inet.getLocalHost().getHostAddress());//返回本机IP地址

        System.out.println("2===========================");
        inet=InetAddress.getByName("47.254.33.193");
        System.out.println(inet.getHostAddress());
        System.out.println(inet.getHostName());//如果ip地址存在，并且DNS给你解析就会输出,不给你解析就会返回这个IP本身；
    }
}
