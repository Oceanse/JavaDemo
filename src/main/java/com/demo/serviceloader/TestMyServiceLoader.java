package com.demo.serviceloader;

import com.demo.serviceloader.serviceloaderInterface.IMyServiceLoader;

import java.util.ServiceLoader;


public class TestMyServiceLoader{

    /*
      1 在ServiceLoader.load的时候，根据传入的接口类，遍历META-INF/services目录下的该接口类的所有实现类，并实例化返回。

      2 META-INF/services/，是ServiceLoader中约定的接口与实现类的关系配置目录，文件名是接口全限定类名，内容是接口对应的具体实现类，如果有多个实现类，分别将不同的实现类都分别作为每一行去配置

      3 ServiceLoader实现了Iterable接口，所以可以通过ServiceLoader来遍历所有在配置文件中定义的类的实例。

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