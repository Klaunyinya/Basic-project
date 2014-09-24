package com.basic.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.model.User;
import com.basic.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	@ResponseBody @RequestMapping(value = "/registrationRequest",  method=RequestMethod.POST, produces = "application/json")
	public String regUser(@RequestBody String userdatas) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userdatas, User.class);
		return userService.saveUser(user);
	}
	
	@ResponseBody @RequestMapping(value = "/loginRequest", method=RequestMethod.POST, produces = "application/json")
	public User loginUser(@RequestBody String userdatas) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userdatas, User.class);
		user = userService.getUser(user.getUserName(), user.getPassword());
		return user;
	}
	
	@ResponseBody @RequestMapping(value = "/getAllUserRequest", method=RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() throws JsonParseException, JsonMappingException, IOException {
		List<User> users = userService.getAllUsers(); 
		return users;
	}
	
}
