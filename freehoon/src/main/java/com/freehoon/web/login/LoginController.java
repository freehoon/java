package com.freehoon.web.login;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freehoon.web.user.model.UserVO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception {
		logger.debug("login form");
		model.addAttribute("userVO", new UserVO());
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void logined(Model model, HttpServletResponse response) throws Exception {
		logger.debug("logined");
		
		response.sendRedirect("/board/getBoardList");
	}
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		logger.debug("signup Form");
		model.addAttribute("userVO", new UserVO());
		return "login/signupForm";
	}
	
}
