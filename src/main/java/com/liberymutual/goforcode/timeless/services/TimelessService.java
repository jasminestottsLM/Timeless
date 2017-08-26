package com.liberymutual.goforcode.timeless.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.liberymutual.goforcode.timeless.models.TimeEntries;

@Service
public class TimelessService {

	private int nextId = 0;
	public int sizeOfArray;
	
	

	public List<TimeEntries> getAll() {
		
		List<TimeEntries> entries = new ArrayList<TimeEntries>();
		
		if (entries.size() == 0 ) {
		
		try (Reader in = new FileReader("timesheet.csv")){
			
			for(CSVRecord record : CSVFormat.DEFAULT.parse(in).getRecords()) {
				TimeEntries entry = new TimeEntries();
				int tempId = Integer.parseInt(record.get(0));
				entry.setId(tempId);
				entry.setSimpleWeek(record.get(1));
				entry.setSunday(Double.parseDouble(record.get(2)));
				entry.setMonday(Double.parseDouble(record.get(3)));
				entry.setTuesday(Double.parseDouble(record.get(4)));
				entry.setWednesday(Double.parseDouble(record.get(5)));
				entry.setThursday(Double.parseDouble(record.get(6)));
				entry.setFriday(Double.parseDouble(record.get(7)));
				entry.setSaturday(Double.parseDouble(record.get(8)));
				entry.setTotalHours(entry.getTotalHours());
				entries.add(entry);
				nextId += 1;
			}
			
		} catch (FileNotFoundException e) {
			System.out.print("failed to get entries");
		} catch (IOException e) {
			System.out.print("failed to get entries");
		} 
		}
		
		sizeOfArray = entries.size();
		return entries;
	}

	
	public List<TimeEntries> reverseArray() {
		
		List<TimeEntries> entries = getAll();
		
		List<TimeEntries> reverseEntries = new ArrayList<TimeEntries>();
			
		if (reverseEntries.size() == 0 ) {
		int countRemainingEntries = reverseEntries.size();
		
		for (TimeEntries entry : entries) {
			if (entry.getId() == countRemainingEntries) {
				reverseEntries.add(entry);
				countRemainingEntries +=1;
			}
		}
		}
		System.out.println("Did this reverse the array?" + reverseEntries);
		return reverseEntries;
	}

	
	public Date currentDate(TimeEntries entry) {
		Date currentDate = entry.getWeek();
		return currentDate;
	}
	
	
	public double add(TimeEntries entry) {
		double sum = entry.getSunday() + entry.getMonday() + entry.getTuesday() + entry.getWednesday() + entry.getThursday() + entry.getFriday() + entry.getSaturday(); 
		return sum;
	}
	
	public void create(TimeEntries entry) {
		nextId = sizeOfArray;
		nextId += 1;
		
		entry.setId(nextId);
		
		Date tempWeek = entry.getWeek();
		// don't forget to increment once list is established by stopping and restarting program
		
		try (FileWriter writer = new FileWriter("timesheet.csv" , true);
				CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) { 
			String week = entry.getSimpleWeek();
			String [] timeEntry = {Integer.toString(entry.getId()), entry.getSimpleWeek(), 
					Double.toString(entry.getSunday()),
					Double.toString(entry.getMonday()),
					Double.toString(entry.getTuesday()),
					Double.toString(entry.getWednesday()),
					Double.toString(entry.getThursday()),
					Double.toString(entry.getFriday()),
					Double.toString(entry.getSaturday()),
					Double.toString(entry.getTotalHours())
			};
//			String[] timeEntry = {Integer.toString(entry.getId()), week};
			System.out.println("tried to print");
			
			printer.printRecord(timeEntry);
			
		} catch (IOException e) {
			System.out.println("error on create");
		}
		
		System.out.println("good create");
	}
}
