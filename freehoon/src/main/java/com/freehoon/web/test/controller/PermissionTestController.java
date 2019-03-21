package com.freehoon.web.test.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freehoon.common.CommonUtils;

@Controller
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class PermissionTestController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String test(Model model) throws Exception{
		
		String path = "/Users/freehoon/test.txt";
		File file = new File(path);
		if(file.exists()) {
			//Util.setPermission(file, "775");
			CommonUtils.setPermission(path, "664");
		}
		
		return "test";
	}
}
