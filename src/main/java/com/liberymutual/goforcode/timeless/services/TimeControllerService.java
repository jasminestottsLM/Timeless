package com.liberymutual.goforcode.timeless.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import com.liberymutual.goforcode.timeless.models.TimeEntries;

@Service
public class TimeControllerService {

	private int nextId = 0;
	
//	List<TimeEntries> entries = new ArrayList<TimeEntries>();

	public void create(TimeEntries entry) {
		System.out.println("tried to create");
		entry.setId(nextId);
		nextId += 1;
		
		System.out.println(entry.getSunday());
		Date tempWeek = entry.getWeek();
		System.out.println(tempWeek);
		// don't forget to increment once list is established by stopping and restarting program
		
		try (FileWriter writer = new FileWriter("timesheet.csv" , true);
				CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {
			String week = entry.getSimpleDate();
			String[] timeEntry = {Integer.toString(entry.getId()), entry.getSimpleDate(), 
					Double.toString(entry.getSunday()),
					Double.toString(entry.getMonday()),
					Double.toString(entry.getTuesday()),
					Double.toString(entry.getWednesday()),
					Double.toString(entry.getThursday()),
					Double.toString(entry.getFriday()),
					Double.toString(entry.getSaturday())};
//			String[] timeEntry = {Integer.toString(entry.getId()), week};
			System.out.println("tried to print");
			
			printer.printRecord(timeEntry);
			
		} catch (IOException e) {
			System.out.println("error on create");
		}
		
		System.out.println("good create");
	}
}
