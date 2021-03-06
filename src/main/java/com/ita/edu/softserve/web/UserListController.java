package com.ita.edu.softserve.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ita.edu.softserve.manager.UserManager;

/**
 * 
 * class UserListController
 *
 */
@Controller
public class UserListController {
 
 @Autowired
 private UserManager users;
 
 @RequestMapping(value = "userlist", method = RequestMethod.GET)
 public String index(Map<String, Object> modelMap){
  
  modelMap.put("userList", users.findAllUsers());
  return "userlist";
 }

}
