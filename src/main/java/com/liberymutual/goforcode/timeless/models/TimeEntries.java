package com.liberymutual.goforcode.timeless.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.liberymutual.goforcode.timeless.services.TimelessService;

public class TimeEntries {

	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date week;
	private double Sunday = 0;
	private double Monday = 0; 
	private double Tuesday = 0; 
	private double Wednesday = 0; 
	private double Thursday = 0; 
	private double Friday = 0; 
	private double Saturday = 0; 
	private double totalHours;
	
	
	@Override
	public String toString() {
		return Integer.toString(id) + week + Double.toString(Sunday) + Double.toString(Monday) + Double.toString(Tuesday) + Double.toString(Wednesday) + Double.toString(Thursday) + Double.toString(Friday) + Double.toString(Saturday) + Double.toString(totalHours);
	}
	
	public void getHours() {
		TimelessService service = new TimelessService();
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
		
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
		String simpleWeek = formatDate.format(getWeek());
		return simpleWeek;				
	}
	
	public void setSimpleWeek(String simpleWeek) {
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
		try {
			week = formatDate.parse(simpleWeek);
		} catch (ParseException e) {
			System.out.println("Simple date failure");
		}
	}
	
	public String getHTMLDate() {
		SimpleDateFormat formatHTMLDate = new SimpleDateFormat("yyyy-MM-dd");
		String htmlDate = formatHTMLDate.format(getWeek());
		return htmlDate;				
	}
	
	public Date getWeek() {
		return week;
	}
	
	public void setWeek(Date week) {
		this.week = week;
	}
	
	public Double getTotalHours() {
		totalHours = Sunday + Monday + Tuesday + Wednesday + Thursday + Friday + Saturday;
		return totalHours;
	}
	
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
	
	

	
}