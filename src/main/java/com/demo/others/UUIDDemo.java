package com.demo.others;

import org.testng.annotations.Test;

import java.util.UUID;

public class UUIDDemo {
    @Test
    public void test(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String s = uuid.toString().replaceAll("-", "");
        System.out.println(s);
    }
}
