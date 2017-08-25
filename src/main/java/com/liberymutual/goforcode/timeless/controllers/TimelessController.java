package com.liberymutual.goforcode.timeless.controllers;

import java.util.Date;
import java.util.List;

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
	private TimeEntries deletemesoon;
		
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
		List<TimeEntries> entries = service.getAll();
		mv.addObject("timeEntries", entries);
		
//		if (entries.size() != 0) {
					
//		mv.addObject("timeEntries", entries);
		
//		double sum = service.add(deletemesoon);	
//		mv.addObject("sum", sum);
//		}
		
		return mv;
	}	
	
	@PostMapping("home") 
	public String timeStuff(TimeEntries entry, String button) {
		deletemesoon = entry;
		if (button.equals("update")) {
			double sum = service.add(entry);	
			System.out.println("got to this point with sum = " + sum);
		} else {
			service.add(entry);
			service.create(entry);
			
		}
		
		return "redirect:/home";
	}
	
	
}