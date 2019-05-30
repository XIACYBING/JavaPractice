package com.example.demo;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Wangy on 4/11/2019.
 */
@Configuration
public class DruidConfiguration {

  @Bean
  public ServletRegistrationBean statViewServlet(){
    /*创建Servlet注册实体*/
    ServletRegistrationBean srb=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    /*设置IP白名单*/
    srb.addInitParameter("allow","127.0.0.1");
    /*设置IP黑名单：如果deny和allow同时存在，deny优先*/
    srb.addInitParameter("deny","192.168.0.19");
    /*设置控制台管理用户*/
    srb.addInitParameter("loginUserName","druid");
    srb.addInitParameter("loginPassWord","123456");
    /*是否可以重置数据*/
    srb.addInitParameter("resetEnable","false");
    return srb;
  }

  @Bean
  public FilterRegistrationBean statFilter(){
    /*创建过滤器*/
    FilterRegistrationBean frb=new FilterRegistrationBean(new WebStatFilter());
    /*设置过滤器过滤路径*/
    frb.addUrlPatterns("/*");
    /*忽略过滤的形式*/
    frb.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    return frb;
  }

}
