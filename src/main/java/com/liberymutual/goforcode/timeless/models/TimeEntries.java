package com.liberymutual.goforcode.timeless.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TimeEntries {

	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	// MM/dd/yyyy
	private Date week;
	public String simpleWeek;
	private double Sunday = 0; 
	
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
	
	public String getSimpleDate() {
		
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
	
	public Date getWeek() {
		System.out.println("got week? " + week);
		return week;
	}
	
	public void setWeek(Date week) {
		System.out.println("set week? " + week);
		this.week = week;
	}
	
	
}
