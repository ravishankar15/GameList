package com.test.gamelist.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("home");
	}
}