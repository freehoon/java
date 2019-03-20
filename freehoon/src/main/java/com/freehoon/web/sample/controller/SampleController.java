package com.freehoon.web.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping(value = "/sample/font-sample")
	public String font_sample(){
		return "/sample/font-sample";
	}
}
