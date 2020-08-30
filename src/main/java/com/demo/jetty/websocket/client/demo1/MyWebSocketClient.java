package com.demo.jetty.websocket.client.demo1;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * java-websocket的开源项目，我们可以利用它来实现java版的websocket client。
 *
 * <dependency>
 * <groupId>org.java-websocket</groupId>
 * <artifactId>Java-WebSocket</artifactId>
 * <version>1.3.8</version>
 * </dependency>
 * <p>
 *
 *  自己测试发现（不一定准确）：
 * connect 状态过程:  成功连接过程： NOT_YET_CONNECTED---->CONNECTING---->OPEN
 * 失败连接过程： NOT_YET_CONNECTED---->CLOSING------>CLOSED
 * <p>
 * 当READYSTATE是OPEN状态时候就会触发client端onOpen方法和server端@OnWebSocketConnect注解的方法
 * 当server启动时，并且端口号之后的url出现错误，试图连接会产生WebsocketNotConnectedException，连接状态：NOT_YET_CONNECTED---->CLOSING------>CLOSED，并且会触发client的onClose方法
 * 当server未启动或者server启动，但是端口号开始出现错误，试图连接会产生ConnectException: Connection refused: connect，连接状态一直是NOT_YET_CONNECTED--->CLOSED，并且会触发client的onClose方法
 *  *
 *
 *
 *
 *  连接成功后触发client端onOpen方法，向server端发消息，server端@OnWebSocketMessage注解的onMessage方法会被触发执行，然后在server端控制台打印信息，并且向客户端发送信息，触发客户端onMessage方法
 *  另外server端@OnWebSocketConnect注解的onOpen方法会被触发执行，向client发送消息，触发客户端onMessage方法
 *
 *  总结：连接成功会触发client和server端@OnWebSocketConnect注解的onOpen方法
 *       一方发消息会触发client的onMessage方法或者server端@OnWebSocketMessage注解的onMessage方法
 *       连接关闭时候会触发client的onClose方法和server端@OnWebSocketClose注解的onClose方法
 *
 *
 *  注意 客户端和服务端的onMessage方法不能同时向对象发送消息，否则双方会陷入收发消息的死循环状态
 */
public class MyWebSocketClient extends WebSocketClient {


    //client端请求url中的/要和startServer中上下文路径要同有同无，保持一致
    static String url = "ws://127.0.0.1:7778/test/";
    static String url2 = "ws://127.0.0.1:8080/base/path1/";
    static String url2_2 = "ws://127.0.0.1:8080/base/path2/";
    static String url3 = "ws://127.0.0.1:7778/test2/";
    static String url4 = "ws://127.0.0.1:8080/base/path4/echo/";

    static MyWebSocketClient myClient;

    public static void main(String[] args) throws URISyntaxException, InterruptedException {

        myClient = new MyWebSocketClient(url3);

        System.out.println("before connect: " + myClient.getReadyState());//还没有进行连接时候返回 NOT_YET_CONNECTED

        myClient.connect();//这里是启动一个新的线程发起connect动作,和其他线程并发执行

        System.out.println("after connect: " + myClient.getReadyState());//由于connect是新线程发起的连接过程，所以这一句的执行可能早于connect,因此状态可能是NOT_YET_CONNECTED

        Thread.sleep(3*1000);//3s之内，主线程处于阻塞状态，后面代码无法执行；connect线程可能完成连接，然后触发client的onOpen方法和server端@OnWebSocketConnect注解的方法

        System.out.println("当前状态："+myClient.getReadyState());



        Thread.sleep(3*1000);
        myClient.closeConnection(1,"");//3s之后关闭连接，此时会触发客户端onClose方法和服务端 @OnWebSocketClose注解的onClose方法

    }

    public MyWebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake shake) {
        //System.out.println("onopen method connect: "+myClient.getReadyState());
        myClient.send("这是客户端onOpen发送的数据内容");
        System.out.println("客户端消息： 握手...");
    }



    @Override
    public void onMessage(String paramString) {

        System.out.println("客户端接收到消息：" + paramString);
    }


    /**
     * 在 WebSocket 连接的readyState 变为 CLOSED时被调用
     *
     * @param paramInt
     * @param paramString
     * @param paramBoolean
     */
    @Override
    public void onClose(int paramInt, String paramString, boolean paramBoolean) {
       // System.out.println("onClose method: "+myClient.getReadyState());
        System.out.println("客户端关闭...");
        //myClient.send("这是客户端onClose发送的数据内容");  该方法是连接关闭时候触发，所以send消息没有意义
    }

    @Override
    public void onError(Exception e) {
        System.out.println("客户端异常" + e);
    }


}
