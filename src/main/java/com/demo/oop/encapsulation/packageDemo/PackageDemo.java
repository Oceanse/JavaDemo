package com.demo.oop.encapsulation.packageDemo;


/**
 * 定义：  package packageName
 *
 * 用途：
 *  1 package可以解决类名冲突：
 *      不同软件厂商开发的众多类可能会包含重名的情况，所以oracle允许在类名前加一个前缀限定这个类，这个前缀就是package
 *       某个类想使用另一个类时候可以使用全类名或者通过import导入这个类
 *  2 package可以进行类文件管理：比如可以把功能类似的类放在同一个包下
 *
 *
 *  命名：package建议全部小写
 *       oracle建议采用公司域名的反写作为package, 当然，还可以在这个包下以项目名建立子包，
 *       如果这个子包下还含有不同的组件，可以为不同的组件建立不同的子包，比如: com.crazy.elearning.frontend,
 *       这里com.crazy是公司域名反写，elearning是项目名，frontend是一个组件
 *
 *   使用：
 *      如果不使用import:
 *        调用同一个package下的某个类可以省略package,默认从当前包加载
 *        调用另一个package下的类需要使用全类名
 *
 *
 *  jvm会通过 classpath+package+.class 寻找加载class
 */
public class PackageDemo {
    public static void main(String[] args) {
        new Tools().toString();// 调用同一个package下的某个类可以省略package,默认从当前包加载
        new com.demo.oop.encapsulation.EncapsulationDemo1();//调用另一个package下的类需要使用全类名
    }
}

class Tools{}