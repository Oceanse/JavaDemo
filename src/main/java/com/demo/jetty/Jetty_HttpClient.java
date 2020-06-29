package com.demo.jetty;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpMethod;
import org.testng.annotations.Test;

public class Jetty_HttpClient {

    /**
     * net/jetty/JettyDemo.java处理请求
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.setFollowRedirects(false);
        httpClient.start();  // Start HttpClient

        //等价于httpClient.newRequest("http://localhost:8080/base/hi?name=ocean&passwd=123123").method(HttpMethod.GET)
        Request request = httpClient.newRequest("http://localhost:8080/base/hi")
                .method(HttpMethod.GET)
                .param("name","ocean")
                .param("passwd","123123");
        //Request request = httpClient.newRequest("http://localhost:8083/demo/speak").method(HttpMethod.GET);

        ContentResponse response = request.send();
        String contentAsString = response.getContentAsString();
        System.out.println("contentAsString====================: "+contentAsString);
        httpClient.stop();



    }

    /**
     * net/jetty/JettyDemo.java处理请求
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.setFollowRedirects(false);
        httpClient.start();  // Start HttpClient

       //HttpClient.GET(...)履行一个HTTP GET请求到一个给定的URI，成功后返回一个ContentResponse。
        ContentResponse response = httpClient.GET("http://localhost:8080/base/hi?name=ocean&passwd=123123");
        String contentAsString = response.getContentAsString();
        System.out.println(response);
        System.out.println();
        System.out.println(contentAsString);
        httpClient.stop();
    }


    /**
     * net/jetty/JettyDemo.java处理请求
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        JSONObject data = new JSONObject();
        HttpClient httpClient = new HttpClient();
        httpClient.setFollowRedirects(false);
        httpClient.start();  // Start HttpClient

        //HttpClient.GET(...)履行一个HTTP GET请求到一个给定的URI，成功后返回一个ContentResponse。
        Request request = httpClient.POST("http://localhost:8080/base/hi?name=ocean&passwd=123123")
               .header("head", "headvalue");
        ContentResponse response = request.send();

        String contentAsString = response.getContentAsString();
        System.out.println(response);
        System.out.println();
        System.out.println(contentAsString);
        httpClient.stop();
    }


    /**
     * net/jetty/JettyDemo3.java 处理请求
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.setFollowRedirects(false);
        httpClient.start();  // Start HttpClient

        //HttpClient.GET(...)履行一个HTTP GET请求到一个给定的URI，成功后返回一个ContentResponse。
        ContentResponse response = httpClient.GET("http://localhost:8888/base/hi?name=ocean&passwd=123123");
        String contentAsString = response.getContentAsString();
        System.out.println(response);
        System.out.println();
        System.out.println(contentAsString);
        httpClient.stop();
    }

    /**
     * com.demo.jetty.JettyDemo4 处理请求
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.setFollowRedirects(false);
        httpClient.start();  // Start HttpClient

        //HttpClient.GET(...)履行一个HTTP GET请求到一个给定的URI，成功后返回一个ContentResponse。
        ContentResponse response = httpClient.GET("http://localhost:8080/base/rest/v1/jtcontroller/subpath");
        String contentAsString = response.getContentAsString();
        System.out.println(response);
        System.out.println();
        System.out.println(contentAsString);
        httpClient.stop();
    }

}
