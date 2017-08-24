package com.liberymutual.goforcode.timeless.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TimelessController {

	@GetMapping("")
	public String redirectToDefault() {
		return "redirect:/home";
	}
	
	@GetMapping("home") 
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("timeless/default");
		return mv;
	}
	
}
