package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
*@Description
*@author wang.yubin
*@date 5/27/2019
*/
@Controller
@RequestMapping
public class HelloController extends HttpServlet {

  @RequestMapping(value = "/hello",method = RequestMethod.GET)
  public String hello(){
    System.out.println("HelloController_hello()");
    return "hello";
  }

  @RequestMapping("/index")
  public String index(){
    System.out.println("Helloontroller_index()");
    return "index";
  }


  @RequestMapping(value = "/toJson",method = RequestMethod.GET)
  @ResponseBody
  public Map<String,Object> toJson(){
    Map<String,Object> retMap = new HashMap<>(1);
    retMap.put("a","A");
    return retMap;
  }

  @RequestMapping(value = "/testvim",method = RequestMethod.GET)
  @ResponseBody
  public Map<String,Object> testVim(){
    Map<String,Object> retMap = new HashMap<>(1);
    retMap.put("testVimEditor","success");
    return retMap;
  }
	  
}
