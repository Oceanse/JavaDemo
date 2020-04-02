package com.demo.serviceloader.serviceloaderImple;

import com.demo.serviceloader.serviceloaderInterface.IMyServiceLoader;

public class MyServiceLoaderImpl1 implements IMyServiceLoader {
    @Override
    public String sayHello() {
        return "hello1";
    }

    @Override
    public String getName() {
        return "name1";
    }
}
