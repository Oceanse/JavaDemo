package com.demo.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Java允许我们自定义异常来表现程序中可能会遇到的特定问题，如果你用Java定义好的这些异常，比如会员登入，
 * 用户要登入你的这个会员，用户输入错误了如果提醒为空指针错误或者什么错误什么的，他不可能看得懂是什么意思。
 * 用户没有学过编程不知道什么是空指针错误什么什么是类型转换错误，所以Java在这方面就给我们程序员提供可以自己去定义异常方法。
 * 这样如果自己定义的异常，用户没有填写帐号或者密码就会提示输入帐号密码，如果这个会员不支持输入英文帐号就会提示不支持英文字母请输入数字帐号等等，
 * 这就是自定义方法的好处。所以我们今后的工程里面要用自定义异常，虽然这样工程有点麻烦不过能更加的清楚更加的定位错误到底是什么意思。
 *
 *
 * 自定义异常类一般都是以Exception结尾，说明该类是一个异常类
 *
 * 自定义异常类：
 * 必须继承Exception或者RuntimeException。
 * 继承Exception：自定义的异常类就是一个编译期异常，如果方法内部抛出编译期异常，就必须处理这个异常，要么throws，要么try……catch。
 * 继承RuntimeException：自定义的异常是一个运行期异常，无需处理，交给虚拟机处理
 *
 * 自定义异常时，应该提供多种构造方法
 * public class BaseException extends RuntimeException {
 *  public BaseException() {
 *  super();
 *  }
 *  public BaseException(String message, Throwable cause) {
 *  super(message, cause);
 *  }
 *  public BaseException(String message) {
 *  super(message);
 *  }
 *  public BaseException(Throwable cause) {
 *  super(cause);
 *  }
 * }
 *上述构造方法实际上都是原样照抄RuntimeException。这样，抛出异常的时候，就可以选择合适的构造方法
 *
 *
 * 一个常见的做法是自定义一个BaseException作为“根异常”，然后，派生出各种业务类型的异常。BaseException需要从一个适合的Exception派生，
 * 通常建议从RuntimeException派生
 */


/**
 *  编译时异常，也就是extends Exception 的异常需要在调用时try{}catch(){}或throws
 */
public class MyException extends Exception {

    //添加一个空参数的构造方法
    public MyException() {
         super();
    }

    //添加一个带异常信息的构造方法
    public MyException(String message){
        super(message);
    }


    public MyException(String message,Throwable cause){
        super(message,cause);
    }


}


/**
 * 运行时异常，也就是extends RuntimeException的异常编译时不用try{}catch(){}和throws
 */
class MyException2 extends RuntimeException {

    //添加一个空参数的构造方法
    public MyException2() {
    }


    //添加一个带异常信息的构造方法
    public MyException2(String message){
        super(message);
    }


    public MyException2(Throwable cause){
        super(cause);
    }


    public MyException2(String message,Throwable cause){
        super(message,cause);
    }
}




class Test {

    private static final Logger LOG = LogManager.getLogger(Test.class);

    public void test(){
        try{
            throw new MyException("自定义编译时异常");//MyException是编译时异常,必须显示的处理
        }catch (MyException e){
            e.printStackTrace();//打印出的信息包含e.getMessage()
            System.out.println("===============================");
            System.out.println(e.getMessage());
        }
    }




    public void test2(){
        throw new MyException2("自定义运行时异常");//MyException是运行时异常,可以暂时不处理
    }



    public void test3(){
        try{
            throw new MyException2("自定义运行时异常");//MyException是编译时异常,必须显示的处理
        }catch (MyException2 e){
            //LOG.error(e);
            throw new MyException2(e);
        }
    }


    public void test4(){
        try{
            throw new MyException2("自定义运行时异常");
        }catch (MyException2 e){
            //LOG.error("log 打印error:",e);
            throw new MyException2("自定义运行时异常");
        }
    }



    public void test5(){
        try{
            throw new MyException2("自定义运行时异常");
        }catch (MyException2 e){
            //LOG.error("log 打印error:",e);
            throw new MyException2("这是自定义运行时异常",e);
        }
    }


    public static void main(String[] args){

        Test t=new Test();
        t.test();
        //t.test2();
        //t.test5();
        //t.test2_2();


    }
}