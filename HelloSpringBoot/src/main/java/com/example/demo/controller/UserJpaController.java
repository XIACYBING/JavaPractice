package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*@Description 用户信息控制器
*@author wang.yubin
*@date 5/27/2019
*/

@Controller
@RequestMapping("/user")
public class UserJpaController {

  @Autowired
  private UserJpa userJpa;

  @RequestMapping(value = "/list",method = RequestMethod.GET)
  public List<User> list(){
    return userJpa.findAll();
  }

  @RequestMapping(value = "/add",method = RequestMethod.POST)
  public List<User> add(User user){
    userJpa.save(user);
    return userJpa.findAll();
  }

  @RequestMapping(value = "/del",method = RequestMethod.GET)
  public List<User> del(Long id){
    userJpa.deleteById(id);
    return userJpa.findAll();
  }

  @RequestMapping(value = "/freeMarker")
  public String showUser(Model model){
    List<User> list = userJpa.findAll();
    model.addAttribute("list",list);
    return "showUser";
  }

}
