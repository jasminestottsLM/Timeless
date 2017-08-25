package com.liberymutual.goforcode.timeless.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.liberymutual.goforcode.timeless.services.TimeControllerService;

public class TimeEntries {

	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	// MM/dd/yyyy
	private Date week;
	public String simpleWeek;
	private double Sunday = 0;
	private double Monday = 0; 
	private double Tuesday = 0; 
	private double Wednesday = 0; 
	private double Thursday = 0; 
	private double Friday = 0; 
	private double Saturday = 0; 
	private double totalHours = 0;
	
	public void getHours() {
		TimeControllerService service = new TimeControllerService();
//		Hours = service.add(entry);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setSunday(double Sunday) {
		this.Sunday = Sunday;
	}
	
	public double getSunday() {
		return Sunday;
	}
	
	public void setMonday(double Monday) {
		this.Monday = Monday;
	}
	
	public double getMonday() {
		return Monday;
	}
	
	public void setTuesday(double Tuesday) {
		this.Tuesday = Tuesday;
	}
	
	public double getTuesday() {
		return Tuesday;
	}
	
	public void setWednesday(double Wednesday) {
		this.Wednesday = Wednesday;
	}
	
	public double getWednesday() {
		return Wednesday;
	}
	
	public void setThursday(double Thursday) {
		this.Thursday = Thursday;
	}
	
	public double getThursday() {
		return Thursday;
	}
	
	public void setFriday(double Friday) {
		this.Friday = Friday;
	}
	
	public double getFriday() {
		return Friday;
	}
	
	public void setSaturday(double Saturday) {
		this.Saturday = Saturday;
	}
	
	public double getSaturday() {
		return Saturday;
	}
	
	
	public String getSimpleWeek() {
		
		System.out.println(getWeek());
		System.out.println("begin");
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("mid");
//		Date week = getWeek();
		String simpleWeek = formatDate.format(getWeek());
		
		
//		simpleWeek = formatDate.format(week);
		
		System.out.println("just before check");
		System.out.println(simpleWeek);
		return simpleWeek;
				
	}
	
	public void setSimpleWeek(String simpleWeek) {
		this.simpleWeek = simpleWeek;
	}
	
	public Date getWeek() {
		System.out.println("got week? " + week);
		return week;
	}
	
	public void setWeek(Date week) {
		System.out.println("set week? " + week);
		this.week = week;
	}
	
	public Double getTotalHours() {
		totalHours = Sunday + Monday + Tuesday + Wednesday + Thursday + Friday + Saturday;
		return totalHours;
	}
	
	public void setTotalHours() {
		this.totalHours = totalHours;
	}
	
}