package com.liberymutual.goforcode.timeless.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.liberymutual.goforcode.timeless.models.TimeEntries;
import com.liberymutual.goforcode.timeless.services.TimeControllerService;

@Controller
@RequestMapping("/")
public class TimelessController {

	private TimeControllerService service;
	private Date week;
	
	public TimelessController(TimeControllerService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public String redirectToDefault() {
		return "redirect:/home";
	}
	
	@GetMapping("home") 
	public ModelAndView timeEntries() {
		ModelAndView mv = new ModelAndView("timeless/default");
//		List<Entries> entries = service.getAll();
		
//		mv.addObject("timeEntries", entries);
		return mv;
	}	
	

	@PostMapping("home") 
	public String createEntry(TimeEntries entry) {
		service.create(entry);
		return "redirect:/home";
	}
	
}
