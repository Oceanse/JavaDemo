package com.demo.others;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 可以使用Apache的httpclient工具调用其他项目的Rest接口
 */
public class HttpClientDemo {

    //GET  http://192.168.56.102:9090/hectar/v1/service
    //GET  http://www.baidu.com
    //GET  http://localhost:8083/showheader
    @Test
    public void getTest() throws IOException {
        String url="http://localhost:8083/showheader";
        HttpClient  httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(new BasicHeader("header", "oceanheads"));
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity resEntity = response.getEntity();
        String message = EntityUtils.toString(resEntity, "utf-8");
        System.out.println(message);

        //HTTP响应报文也由三部分组成：响应行、响应头、响应体
        System.out.println();
        System.out.println(response.getStatusLine());//获得响应状态行
        System.out.println(response.getStatusLine().getStatusCode());//获得响应状态行的状态码
        System.out.println(response.getStatusLine().getProtocolVersion());
    }


    @Test
    public void getTest2() throws IOException {
        String url="http://localhost:8083/showheader";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest request = RequestBuilder.get().setUri(url).setHeader(new BasicHeader("header", "oceanheads")).build();
        HttpResponse response = httpClient.execute(request);
        HttpEntity resEntity = response.getEntity();
        String message = EntityUtils.toString(resEntity, "utf-8");
        System.out.println(message);

        //HTTP响应报文也由三部分组成：响应行、响应头、响应体
        System.out.println();
        System.out.println(response.getStatusLine());//获得响应状态行
        System.out.println(response.getStatusLine().getStatusCode());//获得响应状态行的状态码
        System.out.println(response.getStatusLine().getProtocolVersion());
    }




    //POST  http://192.168.56.102:9090/hectar/v1/service
    @Test
    public void postTest() throws IOException {
        Path path = Paths.get("C:\\Users\\epanhai\\git\\practice\\JavaDemo\\src\\main\\resources\\aat_register.gson");
        String registerStr = new String(Files.readAllBytes(path));
        String aatUrl="http://192.168.56.102:9090/hectar/v1/service";
        HttpClient  httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(aatUrl);
        StringEntity stringEntity = new StringEntity(registerStr, "utf-8");
        httpPost.setEntity(stringEntity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        String message = EntityUtils.toString(entity, "utf-8");
        System.out.println(message);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        System.out.println(httpResponse.getStatusLine().getProtocolVersion());

    }


    @Test
    public void postDog() throws IOException{
        String url="http://localhost:8083/demo/postdog";
        String body="{\n" +
                "    \"name\": \"dahung\",\n" +
                "    \"age\": 88\n" +
                "}";
        HttpClient httpClient=HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);

        //Content-Type表示客户端发送给服务器端的数据格式,服务端接收的是json请求格式
        /* @RequestMapping("/dog")
           public Dog showDog(@RequestBody Dog dog){
                System.out.println(dog);
                return dog;
        }*/
        StringEntity stringEntit=new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntit);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        String message = EntityUtils.toString(entity);
        System.out.println(message);
    }





}

