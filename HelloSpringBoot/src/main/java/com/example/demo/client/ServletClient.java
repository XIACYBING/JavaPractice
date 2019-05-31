package com.example.demo.client;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

/**
 * @program: HelloSpringBoot
 * @description: 测试HttpClient请求Servlet
 * @author: wang.yubin
 * @create: 2019/05/27
 */
public class ServletClient {

    private static HttpClient client = HttpClientBuilder.create().build();
    private static HttpGet get = new HttpGet();
    private static HttpPost post = new HttpPost();
    private static  CloseableHttpResponse response = null;
    private static HttpEntity responseEntity = null;

    public static void main(String[] args) throws IOException {

    }

    private static void firstGet() throws IOException {
        get.setURI(URI.create("http://localhost:8081/servletMethod"));
        System.out.println("执行HttpGet");
        CloseableHttpResponse response = (CloseableHttpResponse) client.execute(get);
        System.out.println("获取Get请求的配置信息");
        System.out.println("HttpGet执行完成");
        responseEntity = response.getEntity();
        System.out.println(EntityUtils.toString(responseEntity));
    }

    private static void userGet() throws IOException {
        get.setURI(URI.create("http://localhost:8081/user/list"));
        System.out.println("开始获取用户信息");
        response = (CloseableHttpResponse) client.execute(get);
        System.out.println("获取用户信息完成");
        responseEntity = response.getEntity();
        System.out.println("用户信息：" + EntityUtils.toString(responseEntity));
    }

    private static void userAddByGet() throws IOException {
        StringBuffer url = new StringBuffer("http://localhost:8081/user/add?");
        url.append("name=zhaoliu");
        url.append("&");
        url.append("pwd=5");
        get.setURI(URI.create(url.toString()));
        response = (CloseableHttpResponse) client.execute(get);
        System.out.println("添加用户信息完成！");
        System.out.println("获取更新后的用户信息");
        userGet();
    }

    private static void userAddByPost() throws IOException {
        post.setURI(URI.create("http://localhost:8081/user/add"));
        User user = new User();
        user.setName("liqi");
        user.setPwd("8");
        System.out.println(JSON.toJSONString(user));
        StringEntity entity = new StringEntity(JSON.toJSONString(user),"UTF-8");
        post.setEntity(entity);
        post.setHeader("Content-Type","application/json;charset=utf8");
        client.execute(post);
        userGet();
    }


}
