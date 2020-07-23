package com.demo.testNG.group;

import org.testng.annotations.Test;


/**
 * 分组测试
 */
public class GroupDemo {
    @Test(groups={"driver"})//定义该方法属于driver组
    public void driverWork(){
        System.out.println("car1's driver is driving");
    }

    @Test(groups={"boss"})//定义该方法属于boss组
    public void bossWork(){
        System.out.println("car1's boss is talking");
    }
}



 class GroupDemo2 {
     @Test(groups={"driver"})//定义该方法属于driver组
     public void driverWork(){
         System.out.println("car2's driver is driving");
     }

     @Test(groups={"boss"})//定义该方法属于boss组
     public void bossWork(){
         System.out.println("car2's boss is talking");
     }
}

