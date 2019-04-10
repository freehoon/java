package com.freehoon.web.user.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freehoon.web.user.model.UserVO;
import com.freehoon.web.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		
		model.addAttribute("userVO", new UserVO());
		
		return "user/signupForm";
	}
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public String getUserList(Model model) throws Exception{
		logger.info("getUserList();....");
		
		model.addAttribute("userList", userService.getUserList());
		
		return "user/userList";
	}
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public String getUserInfo(Model model
			, @RequestParam("uid") String uid) throws Exception{
		logger.info("getUserList();....");
		
		model.addAttribute("userInfo", userService.getUserInfo(uid));
		
		return "user/userList";
	}
	
	
}
