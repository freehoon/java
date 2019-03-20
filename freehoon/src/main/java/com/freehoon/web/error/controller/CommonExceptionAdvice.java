package com.freehoon.web.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
//	@ExceptionHandler(RuntimeException.class)
//	public ModelAndView errorException(Model model, Exception e) {
//		logger.info("exeption : " + e.getMessage());
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("error/exception");
//		//model.addAttribute("exception", e);
//		mav.addObject("exception", e);
//		return mav;//"error/exception";
//	}
	
	@ExceptionHandler(RuntimeException.class)
	public String errorException(Model model, Exception e) {
		logger.info("@ControllerAdvice 방식 \n###exeption : " + e.getMessage());
		
		model.addAttribute("exception", e);
		
		return "error/exception";
	}
	
//	@ExceptionHandler(RuntimeException.class)
//	public String errorException(HttpServletResponse response, Exception e, Model model) {
//		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//		model.addAttribute("exception", e);
//		return "error/exception";
//	}
}
