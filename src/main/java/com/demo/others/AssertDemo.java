package com.demo.others;


import org.eclipse.jetty.server.Server;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 断言是为了方便调试程序，并不是发布程序的组成部分。理解这一点是很关键的
 * 默认情况下，JVM是关闭断言的。因此如果想使用断言调试程序，需要手动打开断言功能。
 * 在命令行模式下运行Java程序时可增加参数-enableassertions或者-ea打开断言;可通过-disableassertions或者-da关闭断言(默认情况,可有可无)。
 *
 * 断言的使用：
 * 断言是通过关键字assert来定义的，一般的，它有两种形式。
 * 1. assert <bool expression>;       比如     boolean isStudent = false; assert isStudent;
 * 2. assert <bool expression> : <message>;    比如  boolean isSafe = false;  assert isSafe : "Not Safe at all";
 *
 *
 */
public class AssertDemo {
    @Test
    public void test2() throws Exception {
        boolean isSafe = false;
        assert isSafe;
        System.out.println("断言通过!");

    }}
