package com.demo.serviceloader.serviceloaderImpl;

import com.demo.serviceloader.serviceloaderInterface.IMyServiceLoader;

public class MyServiceLoaderImpl2 implements IMyServiceLoader {
   @Override
   public String sayHello() {
       return "hello2";
   }

   @Override
   public String getName() {
       return "name2";
   }
}
