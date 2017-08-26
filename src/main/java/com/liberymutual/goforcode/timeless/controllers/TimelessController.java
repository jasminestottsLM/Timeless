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
import com.liberymutual.goforcode.timeless.services.TimelessService;

@Controller
@RequestMapping("/")
public class TimelessController {

	private TimelessService service;
	private Date week;
	private TimeEntries deletemesoon;
	private double currentSum;
	private double currentSunday;
	private double currentMonday;
	private double currentTuesday;
	private double currentWednesday;
	private double currentThursday;
	private double currentFriday;
	private double currentSaturday;
	private String currentWeek;
	
	public TimelessController(TimelessService service) {
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
		mv.addObject("sum", currentSum);
		mv.addObject("currentWeek", currentWeek);
		mv.addObject("currentSunday", currentSunday);
		mv.addObject("currentMonday", currentMonday);
		mv.addObject("currentTuesday", currentTuesday);
		mv.addObject("currentWednesday", currentWednesday);
		mv.addObject("currentThursday", currentThursday);
		mv.addObject("currentFriday", currentFriday);
		mv.addObject("currentSaturday", currentSaturday);
		for (TimeEntries entry : entries) {
			System.out.println(entry);
		}
		
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
			double Sunday = entry.getSunday();
			double Monday = entry.getMonday();
			double Tuesday = entry.getTuesday();
			double Wednesday = entry.getWednesday();
			double Thursday = entry.getThursday();
			double Friday = entry.getFriday();
			double Saturday = entry.getSaturday();
			String altCurrentWeek = entry.getHTMLDate();
			System.out.println("current week value is " + altCurrentWeek);
			currentSum = sum;
			currentWeek = altCurrentWeek;
			currentSunday = Sunday;
			currentMonday = Monday;
			currentTuesday = Tuesday;
			currentWednesday = Wednesday;
			currentThursday = Thursday;
			currentFriday = Friday;
			currentSaturday = Saturday;
			System.out.println("got to this point with sum = " + sum);
		} else {
//			service.add(entry);
			service.create(entry);
			
		}
		
		return "redirect:/home";
	}
	
	
}