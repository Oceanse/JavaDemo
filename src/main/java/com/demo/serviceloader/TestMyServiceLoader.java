package com.demo.serviceloader;

import com.demo.serviceloader.serviceloaderInterface.IMyServiceLoader;

import java.util.ServiceLoader;


public class TestMyServiceLoader{

    /*在ServiceLoader.load的时候，根据传入的接口类，
    遍历META-INF/services目录下的以该类命名的文件中的所有类，并实例化返回。

    ServiceLoader实现了Iterable接口，所以可以通过ServiceLoader来遍历所有在配置文件中定义的类的实例。

   ServiceLoader：一个简单的服务提供者加载设施。服务 是一个熟知的接口和类（通常为抽象类）集合

   ServiceLoader也像ClassLoader一样，能装载类文件，但是使用时有区别，具体区别如下：
   （1） ServiceLoader装载的是一系列有某种共同特征的实现类，而ClassLoader是个万能加载器；
   （2）ServiceLoader装载时需要特殊的配置，使用时也与ClassLoader有所区别；
   （3）ServiceLoader还实现了Iterator接口。[如有错误或不到的地方敬请指出，互相学习：）]

    */

    public static void main(String[] args) {
        ServiceLoader<IMyServiceLoader> load = ServiceLoader.load(IMyServiceLoader.class);
        for (IMyServiceLoader iMyServiceLoader : load) {
            System.out.println(iMyServiceLoader.getClass().getSimpleName());
           // System.out.println(iMyServiceLoader.getName() +" "+ iMyServiceLoader.sayHello());
        }

    }

}