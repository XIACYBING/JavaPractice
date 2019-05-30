package com.example.demo.config;

import com.example.demo.servlet.ServletRegistrationServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: HelloSpringBoot
 * @description: 测试ServletRegistrationBean在Config类中的使用
 * @author: wang.yubin
 * @create: 2019/05/27
 */
@Configuration
@SuppressWarnings("unchecked")
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        return new ServletRegistrationBean(new ServletRegistrationServlet(),"/configServlet");
    }

}
